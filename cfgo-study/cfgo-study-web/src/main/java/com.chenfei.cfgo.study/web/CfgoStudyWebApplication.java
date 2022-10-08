package com.chenfei.cfgo.study.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableTransactionManagement
//@EnableAspectJAutoProxy
@SpringBootApplication
public class CfgoStudyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CfgoStudyWebApplication.class, args);
//        new ClassPathXmlApplicationContext();
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(config.class);
//        annotationConfigApplicationContext.getBean();
    }

}
