package com.chenfei.cfgo.study.web;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement
//@EnableAspectJAutoProxy
@ConfigurationPropertiesScan(basePackages = "com.chenfei.cfgo")
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.chenfei.cfgo"
//        useDefaultFilters = false,
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)}
            )
@EnableFeignClients(basePackages = "com.chenfei.cfgo.study.service.feign")
@SpringBootApplication
public class CfgoStudyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CfgoStudyWebApplication.class, args);
//        new ClassPathXmlApplicationContext();
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(config.class);
//        annotationConfigApplicationContext.getBean();
    }

}
