package com.chenfei.cfgo.study.web.controller.test;

import com.chenfei.cfgo.common.util.ApplicationContextUtil;
import com.chenfei.cfgo.study.web.service.study.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions StudentController
 * @create 2022/10/22 10:02
 */
@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @PostMapping("/getStudentByName")
    public String getStudentByName(@RequestParam String name) {
        Object druidProperties = ApplicationContextUtil.getBean("druidProperties");
        log.info("druidPropertie:{}", druidProperties);
        return studentService.getStudentByName(name);
    }
}
