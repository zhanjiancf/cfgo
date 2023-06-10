package com.chenfei.cfgo.study.web.controller.test;

import com.chenfei.cfgo.study.web.service.study.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {

    @Value("${user.name}")
    private String name;

    @Resource
    private StudentService service;

    @RequestMapping("/hello")
    public String hell() {
        log.info("student:{}", service.getById("1"));
        return StringUtils.defaultIfBlank(name, "default 你好！");
    }
}
