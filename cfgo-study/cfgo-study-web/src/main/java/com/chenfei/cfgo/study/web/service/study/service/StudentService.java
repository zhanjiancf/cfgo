package com.chenfei.cfgo.study.web.service.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenfei.cfgo.study.web.entity.study.Student;

/**
* @author chenfei
* @description 针对表【student】的数据库操作Service
* @createDate 2022-10-21 18:01:24
*/
public interface StudentService extends IService<Student> {

    String getStudentByName(String name);
}