package com.chenfei.cfgo.test.reflect;

import lombok.Data;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2022/11/5 22:57
 */
@Data
public class Student extends People{
    // 学号
    private String no;
    // 年级
    private int grade;
    // 班级
    private String classz;
}
