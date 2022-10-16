package com.github.acticfox.provider;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.acticfox.provider.monitor.PrometheusCustomMonitor;

/**
 * @author kfy
 * @date 2022/07/27
 */
@RestController
public class OrderController {
    @Resource
    private PrometheusCustomMonitor monitor;

    @RequestMapping("/order")
    public String order() throws Exception {
        // 统计下单次数
        monitor.getOrderCount().increment();
        Random random = new Random();
        int amount = random.nextInt(100);
        // 统计金额
        monitor.getAmountSum().record(amount);
        return "下单成功, 金额: " + amount;
    }

}
