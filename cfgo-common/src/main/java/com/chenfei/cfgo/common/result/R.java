package com.chenfei.cfgo.common.result;

import lombok.Data;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2023/10/26 18:21
 */
@Data
public class R<T> {
    private Integer code;

    private String msg;

    private T data;

    public static R success(Integer code, String msg) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static R error(Integer code, String msg) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
}
