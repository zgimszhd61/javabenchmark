package com.freedom.javacodesimple.api.ongl;

import ognl.Ognl;
import ognl.OgnlException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OnglController {
    @GetMapping("/ognl/bad01")
    public String ognl01(String payload) throws OgnlException {
        //        String payload = "@com.github.fartherp.framework.common.util.Tools@executeShell('/System/Applications/Calculator.app/Contents/MacOS/Calculator')";
        //        Ognl.getValue(Ognl.parseExpression(payload),null);
        Ognl.getValue(Ognl.parseExpression(payload),null);

        return  "{'msg':'false'}";
    }
}
