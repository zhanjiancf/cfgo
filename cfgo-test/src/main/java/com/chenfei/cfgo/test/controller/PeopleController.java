package com.chenfei.cfgo.test.controller;

import com.chenfei.cfgo.test.entity.People;
import com.chenfei.cfgo.test.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2022/11/15 16:45
 */
@Slf4j
@RestController
@RequestMapping("/people")
public class PeopleController {

    @Resource
    private PeopleService peopleService;

    @PostMapping("/addPeople")
    public boolean addPeople(@RequestBody People people) {
        boolean saveFlag = peopleService.save(people);
        return saveFlag;
    }
}
