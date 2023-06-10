package com.chenfei.cfgo.study.web.business.impl;

import com.alibaba.fastjson.JSONObject;
import com.chenfei.cfgo.study.web.business.UserBusiness;
import com.chenfei.cfgo.study.web.entity.study.Student;
import com.chenfei.cfgo.study.web.entity.test.People;
import com.chenfei.cfgo.study.web.service.study.service.StudentService;
import com.chenfei.cfgo.study.web.service.test.service.PeopleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2022/10/23 8:46
 */
@Service
public class UserBusinessImpl implements UserBusiness {

    @Resource
    private StudentService studentService;

    @Resource
    private PeopleService peopleService;

    @Override
    public String getUserInfoById(String id) {
        Student student = studentService.query().eq("id", id).one();
        People people = peopleService.query().eq("id", id).one();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("student", student);
        jsonObject.put("people", people);
        return jsonObject.toJSONString();
    }
}
