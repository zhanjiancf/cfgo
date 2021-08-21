package com.chenfei.cfgoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement
//@EnableAspectJAutoProxy
@SpringBootApplication
public class CfgoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CfgoWebApplication.class, args);
//        new ClassPathXmlApplicationContext();
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(config.class);
//        annotationConfigApplicationContext.getBean();
    }

}
