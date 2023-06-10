package com.chenfei.cfgo.study.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions 配置数据源
 * @create 2022/10/22 16:08
 */
@Configuration
public class DataSourceConfig {

    @Resource
    private DruidProperties druidProperties;

    @Bean(name = "mysqlStudyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.cfgo-study")
    public DataSource dataSourceStudy() {
        // 不传type的参数默认使用的是Hikari数据库连接池
        DataSource dataSource = DataSourceBuilder.create().type(DruidDataSource.class).build();
        druidProperties.dataSource((DruidDataSource) dataSource);
        return dataSource;
    }

    @Bean(name = "mysqlTestDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.cfgo-test")
    public DataSource dataSourceTest() {
        // 不传type的参数默认使用的是Hikari数据库连接池
        DataSource dataSource = DataSourceBuilder.create().type(DruidDataSource.class).build();
        druidProperties.dataSource((DruidDataSource) dataSource);
        return dataSource;
    }
}
