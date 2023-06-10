package com.chenfei.cfgo.user.web.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

//    @Value("${user.name}")
    private String name;

    @RequestMapping("/getUserInfo")
    public String getUserInfo() {
        return StringUtils.defaultIfBlank(name, "userInfo");
    }
}
