package com.chenfei.cfgo.test.concurrent;

import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2023/6/20 18:31
 */
@Slf4j
public class CompletableFutureTest {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> stringList = new ArrayList<>();
        stringList.add("111");
        stringList.add("222");
        stringList.add("333");
        stringList.add("444");
        stringList.add("555");
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        String path = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX) + "test" + ExcelTypeEnum.XLSX.getValue();
        File file = new File("C:\\Users\\chenfei\\Desktop\\test\\cftest.txt");

        stringList.stream().forEach(item -> {
            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
                log.info("task-one thread name:{} | value:{}", Thread.currentThread().getName(), item);
                return item;
            }).thenAcceptAsync(it -> {
                log.info("task-two thread name:{} | value:{}", Thread.currentThread().getName(), it);
                appendToFileV2(it, file.getPath());
            });
            completableFutures.add(voidCompletableFuture);
        });
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        log.info("开始等");
        voidCompletableFuture.join();
        log.info("结束等");
    }

    public static synchronized void appendToFile(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendToFileV2(String content, String filePath) {
        try {
            FileUtils.writeStringToFile(new File(filePath), content + System.getProperty("line.separator"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
