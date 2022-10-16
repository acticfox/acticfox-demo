package com.github.acticfox.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.acticfox.api.service.HelloService;
import com.github.acticfox.common.api.result.ResultDTO;
import com.github.acticfox.consumer.util.ExceptionUtil;

@EnableDiscoveryClient
@SpringBootApplication
public class DubboClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboClientApplication.class, args);
    }

    @RestController
    static class TestController {
        Logger log = LoggerFactory.getLogger(TestController.class);

        @DubboReference
        HelloService helloService;

        @SentinelResource(value = "resource2", blockHandler = "handleException",
            blockHandlerClass = {ExceptionUtil.class})
        @GetMapping("/test")
        @ResponseBody
        public ResultDTO<String> test(String name) {
            log.info("name:{}", name);
            return helloService.hello(name);
        }
    }

}