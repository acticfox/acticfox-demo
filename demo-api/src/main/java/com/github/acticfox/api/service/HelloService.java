package com.github.acticfox.api.service;

import com.github.acticfox.common.api.annotation.RpcValidator;
import com.github.acticfox.common.api.result.ResultDTO;

import jakarta.validation.constraints.NotBlank;

public interface HelloService {

    @RpcValidator
    ResultDTO<String> hello(@NotBlank(message = "name不能为空") String name);

}
