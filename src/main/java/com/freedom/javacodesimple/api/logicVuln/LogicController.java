package com.freedom.javacodesimple.api.logicVuln;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// 2023.06.28-潜在逻辑漏洞问题.
@RestController
@RequestMapping("/api")
public class LogicController {
    @GetMapping("/logic/bad01")
    public String hardPassword01(String username){
        if (username.equals("ADMIN")) {
            return "{'msg':'success'}";
        }
        return  "{'msg':'false'}";
    }
}
