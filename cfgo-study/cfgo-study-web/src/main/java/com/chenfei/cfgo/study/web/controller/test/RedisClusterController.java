package com.chenfei.cfgo.study.web.controller.test;

import com.alibaba.fastjson.JSON;
import io.lettuce.core.*;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import io.lettuce.core.cluster.api.async.RedisClusterAsyncCommands;
import io.lettuce.core.cluster.models.partitions.ClusterPartitionParser;
import io.lettuce.core.cluster.models.partitions.Partitions;
import io.lettuce.core.cluster.models.partitions.RedisClusterNode;
import io.lettuce.core.models.role.RedisInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.lettuce.LettuceClusterConnection;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/redisCluster")
public class RedisClusterController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Value("${spring.redis.password}")
    private String redisPwd;

    private static final String KEY_PREFIX = "cfgo:study:web:id:";

    @RequestMapping("/test_cluster")
    public String testCluster() {
        String cache = stringRedisTemplate.opsForValue().get("cftest");
        if (StringUtils.hasText(cache)) {
            return cache;
        }
        String value = "666";
        boolean status = stringRedisTemplate.opsForValue().
                setIfAbsent("cftest", value, 1, TimeUnit.MINUTES);
        if (status) {
            log.info("setIfAbsent success");
            return value;
        } else {
            log.error("setIfAbsent fail");
            return null;
        }
    }

    @RequestMapping("generateDataToRedis")
    public void generateDataToRedis() {
        for (int i = 0; i < 10000; i++) {
            stringRedisTemplate.opsForValue()
                    .set(KEY_PREFIX + i, String.valueOf(i), 60, TimeUnit.MINUTES);
        }
    }

    @RequestMapping("/syncRedisDataToDb")
    public void syncRedisDataToDb() {
        RedisClusterConnection clusterConnection = stringRedisTemplate.getRequiredConnectionFactory().getClusterConnection();
        LettuceClusterConnection lettuceClusterConnection = (LettuceClusterConnection) clusterConnection;
        RedisClusterAsyncCommands<byte[], byte[]> redisClusterAsyncCommands = lettuceClusterConnection.getNativeConnection();
        ScanArgs scanArgs = ScanArgs.Builder.matches(KEY_PREFIX + "*").limit(500);
        Set<String> keySet = Collections.synchronizedSet(new HashSet<>(1000));
        RedisFuture<String> stringRedisFuture = redisClusterAsyncCommands.clusterNodes();
        String nodes;
        try {
            nodes = stringRedisFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        Partitions partitions = ClusterPartitionParser.parse(nodes);
        List<RedisClusterNode> redisMasterClusterNodeList = partitions.stream()
                .filter(node -> RedisInstance.Role.MASTER.equals(node.getRole()))
                .collect(Collectors.toList());
        CountDownLatch countDownLatch = new CountDownLatch(redisMasterClusterNodeList.size());
        redisMasterClusterNodeList.stream().parallel().forEach(node -> {
            // 使用单个节点的连接信息创建连接
            RedisURI nodeUri = RedisURI.builder().withHost(node.getUri().getHost())
                    .withPort(node.getUri().getPort())
                    .withDatabase(node.getUri().getDatabase())
                    .withPassword(redisPwd).build();
            StatefulRedisClusterConnection<String, String> nodeConnection = RedisClusterClient.create(nodeUri).connect();
            RedisAdvancedClusterAsyncCommands<String, String> nodeCommands = nodeConnection.async();
            String currentCursor;
            ScanCursor keyScanCursor = ScanCursor.INITIAL;;
            List<String> currentNodeKeys = new ArrayList<>();
            do {
                RedisFuture<KeyScanCursor<String>> redisFuture = nodeCommands.scan(keyScanCursor, scanArgs);
                try {
                    keyScanCursor = redisFuture.get();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
                List<String> keyScanCursorKeys = ((KeyScanCursor)keyScanCursor).getKeys();
                keySet.addAll(keyScanCursorKeys);
                currentNodeKeys.addAll(keyScanCursorKeys);
                currentCursor = keyScanCursor.getCursor();
            } while (!org.apache.commons.lang3.StringUtils.equals("0", currentCursor));
            log.info("node host:{} | currentNodeKeys:{}", nodeUri.getHost(), JSON.toJSONString(currentNodeKeys));
            log.info("node host:{} | currentNodeKeys size:{}", nodeUri.getHost(), currentNodeKeys.size());
            countDownLatch.countDown();
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("total keySet size:{}", keySet.size());
    }
}
