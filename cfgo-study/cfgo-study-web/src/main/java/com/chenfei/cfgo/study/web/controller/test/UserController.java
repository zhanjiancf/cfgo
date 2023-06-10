package com.chenfei.cfgo.study.web.controller.test;

import com.chenfei.cfgo.study.web.business.UserBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2022/10/23 8:59
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserBusiness userBusiness;

    @PostMapping("/getUserInfoById")
    String getUserInfoById(@RequestParam String id) {
        String userInfo = userBusiness.getUserInfoById(id);
        log.info("userInfo:{}", userInfo);
        return userInfo;
    }
}
