package com.chenfei.cfgo.study.web.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chenfei.cfgo.common.result.R;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2023/10/26 18:12
 */
public class ExceptionUtil {

    public static R fallback(Integer id,Throwable e){
        return R.error(-2,"===被异常降级啦===");
    }

    public static R handleException(Integer id, BlockException e){
        return R.error(-2,"===被限流啦===");
    }
}
