package com.freedom.javacodesimple.api.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class SpelController {
    @GetMapping("/spel/bad01")
    public String spel01(String cmd) {
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        Expression expression = spelExpressionParser.parseExpression(cmd);
        String out = (String) expression.getValue();
        out = out.concat(" get");
        return out;
    }
    @GetMapping("/spel/bad02")
    public String spel02(String cmd) {
//        String script = "T(java.lang.Runtime).getRuntime().exec('open -a Calculator')";
        SpelExpressionParser parser = new SpelExpressionParser();
        SpelExpression expr = parser.parseRaw(cmd);
        expr.getValue();
        return "success";
    }
}
