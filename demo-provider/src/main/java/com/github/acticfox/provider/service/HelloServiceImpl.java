package com.github.acticfox.provider.service;

import org.apache.dubbo.config.annotation.DubboService;

import com.github.acticfox.api.service.HelloService;
import com.github.acticfox.common.api.result.ResultDTO;

@DubboService
public class HelloServiceImpl implements HelloService {

    @Override
    public ResultDTO<String> hello(String name) {
        return ResultDTO.buildSuccessResult("hello " + name);
    }

}
