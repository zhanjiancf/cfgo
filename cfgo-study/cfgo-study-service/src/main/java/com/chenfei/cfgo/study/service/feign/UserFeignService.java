package com.chenfei.cfgo.study.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(name = "cfgo-user", path = "/user")
public interface UserFeignService {

    @RequestMapping("/getUserInfo")
    String getUserInfo();
}

