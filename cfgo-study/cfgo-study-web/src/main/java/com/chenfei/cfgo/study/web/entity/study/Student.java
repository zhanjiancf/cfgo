package com.chenfei.cfgo.study.web.entity.study;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName student
 */
@Data
public class Student implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 
     */
    private Integer age;

    /**
     * 年级
     */
    private Integer grade;

    /**
     * 班级
     */
    private Integer classGrade;

    /**
     * 家庭住址
     */
    private String homeAddress;

    private static final long serialVersionUID = 1L;
}