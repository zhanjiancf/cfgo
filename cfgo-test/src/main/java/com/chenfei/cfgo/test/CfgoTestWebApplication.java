package com.chenfei.cfgo.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableTransactionManagement
//@EnableAspectJAutoProxy
//@ConfigurationPropertiesScan(basePackages = "com.chenfei.cfgo")
//@EnableConfigurationProperties
@ComponentScan(basePackages = "com.chenfei.cfgo"
//        useDefaultFilters = false,
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)}
            )
@MapperScan(basePackages = "com.chenfei.cfgo.test.mapper")
@SpringBootApplication
public class CfgoTestWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CfgoTestWebApplication.class, args);
    }

}
