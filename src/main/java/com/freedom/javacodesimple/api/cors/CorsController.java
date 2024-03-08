package com.freedom.javacodesimple.api.cors;

import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CorsController {

    @GetMapping("/cors/bad01")
    public void cors01(ServerHttpResponse resp){
        resp.getHeaders().add("Access-Control-Allow-Origin", "*");
    }
}
