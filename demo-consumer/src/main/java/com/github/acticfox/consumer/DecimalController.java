package com.github.acticfox.consumer;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.acticfox.consumer.monitor.PrometheusCustomMonitor;

import lombok.Data;

/**
 * @author kfy
 * @date 2022/07/27
 */
@RestController
public class DecimalController {
    @Resource
    private PrometheusCustomMonitor monitor;

    @RequestMapping("/decimal")
    @ResponseBody
    public Decimaler decimal() throws Exception {
        Decimaler decimaler = new Decimaler();
        decimaler.setA(Long.valueOf("123456789123456789"));
        decimaler.setB(new BigDecimal("123456788999.1278328273823"));
        return decimaler;
    }

    @Data
    private static class Decimaler {
        private Long a;

        private BigDecimal b;

    }

}
