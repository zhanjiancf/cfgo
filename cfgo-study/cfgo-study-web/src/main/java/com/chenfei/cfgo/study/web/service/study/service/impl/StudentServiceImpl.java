package com.chenfei.cfgo.study.web.service.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenfei.cfgo.study.web.constant.TransactionManagerType;
import com.chenfei.cfgo.study.web.entity.study.Student;
import com.chenfei.cfgo.study.web.mapper.study.StudentMapper;
import com.chenfei.cfgo.study.web.service.study.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author chenfei
* @description 针对表【student】的数据库操作Service实现
* @createDate 2022-10-21 18:01:24
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService {

    @Transactional(TransactionManagerType.STUDY)
    @Override
    public String getStudentByName(String name) {
        Student student = query().eq("name", name).one();
        return JSON.toJSONString(student);
    }
}