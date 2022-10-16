package com.github.acticfox.provider;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

    /**
     * 健康检查，系统部署需要 请不要删除！！
     */
    @GetMapping("/checkhealth.htm")
    public @ResponseBody String checkPreload() {

        return "success";
    }

}
