package com.chenfei.cfgo.study.web.controller.test;

import com.chenfei.cfgo.study.service.feign.UserFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Resource
    private UserFeignService userFeignService;

    @RequestMapping("/getUserInfo")
    String getUserInfo() {
        return userFeignService.getUserInfo();
    }
}
