package com.chenfei.cfgo.study.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2022/10/25 14:59
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidProperties {

    private int initialSize;

    private int maxActive;

    private int minIdle;

    private boolean poolPreparedStatements;

    private String validationQuery;

    private int validationQueryTimeout;

    private boolean testOnBorrow;

    private boolean testOnReturn;

    private boolean testWhileIdle;

    private String filters;

    public void dataSource(DruidDataSource druidDataSource) {
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setValidationQueryTimeout(validationQueryTimeout);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        try {
            druidDataSource.setFilters(filters);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
