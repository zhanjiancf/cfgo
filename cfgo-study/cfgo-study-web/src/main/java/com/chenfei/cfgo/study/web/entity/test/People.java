package com.chenfei.cfgo.study.web.entity.test;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName people
 */
@Data
public class People implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String interest;

    /**
     * 
     */
    private Integer sex;

    private static final long serialVersionUID = 1L;
}