package com.freedom.javacodesimple.api.xss;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class XssController {
    @GetMapping("xss/bad")
    public String xss(@RequestParam("name") String name) {
        return name;
    }
}
