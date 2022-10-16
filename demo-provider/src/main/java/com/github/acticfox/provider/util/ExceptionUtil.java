package com.github.acticfox.provider.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class ExceptionUtil {
	
	public static Map<String,Object> handleException(BlockException ex) {
        Map<String,Object> map=new HashMap<>();
        System.out.println("Oops: " + ex.getClass().getCanonicalName());
        map.put("Oops",ex.getClass().getCanonicalName());
        map.put("msg","通过@SentinelResource注解配置限流埋点并自定义处理限流后的逻辑");
        return  map;
    }

}
