//package com.chenfei.cfgo.test.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * @author 464498258@qq.com
// * @version 1.0.0
// * @descriptions 配置数据源
// * @create 2022/10/22 16:08
// */
//@Configuration
//public class DataSourceConfig {
//
//    @Bean(name = "mysqlTestDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSourceTest() {
//        // 不传type的参数默认使用的是Hikari数据库连接池
//        DataSource dataSource = DataSourceBuilder.create().build();
//        return dataSource;
//    }
//}
