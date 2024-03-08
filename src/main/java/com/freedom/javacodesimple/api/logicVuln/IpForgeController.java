package com.freedom.javacodesimple.api.logicVuln;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IpForgeController {
    @RequestMapping("/ipforge/good01")
    public String ipforgegood01(HttpServletRequest request) {
        // 无法伪造
        return request.getRemoteAddr();

    }
    @RequestMapping("/ipforge/bad01")
    public String ipforgebad01(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        // 可以伪造
        return ip;
    }
    @RequestMapping("/ipforge/bad02")
    public String ipforgebad02(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        // 可以伪造
        return ip;
    }
}
