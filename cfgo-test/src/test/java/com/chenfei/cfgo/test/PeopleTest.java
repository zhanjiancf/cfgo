package com.chenfei.cfgo.test;

import com.chenfei.cfgo.test.entity.People;
import com.chenfei.cfgo.test.service.PeopleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PeopleTest {

    @Resource
    private PeopleService peopleService;

    @Test
    void addPeople() {
        People people = new People();
        people.setName("小黄");
        people.setSex(1);
        people.setInterest("上网");
        boolean saveFlag = peopleService.save(people);
    }

}
