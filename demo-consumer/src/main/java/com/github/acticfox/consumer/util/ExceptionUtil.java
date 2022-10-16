package com.github.acticfox.consumer.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.github.acticfox.common.api.result.ResultDTO;

public class ExceptionUtil {

    public static ResultDTO<?> handleException(BlockException ex) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("Oops: " + ex.getClass().getCanonicalName());
        map.put("code", ex.getClass().getCanonicalName());
        map.put("message", "通过@SentinelResource注解配置限流埋点并自定义处理限流后的逻辑");
        return ResultDTO.buildFailedResult("RateLimit.Block", "限流异常");
    }

}
