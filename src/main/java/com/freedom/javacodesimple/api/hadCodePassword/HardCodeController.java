package com.freedom.javacodesimple.api.hadCodePassword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HardCodeController {
    @GetMapping("/hardPassword/bad01")
    public String hardPassword01(){
        String SECRET_PASSWORD = "letMeIn!";
        String accessKeyId = "letMeIn!";
        String accessKeySecret = "letMeIn!";
        return  "{'msg':'success'}";
    }
}
