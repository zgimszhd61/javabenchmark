package com.freedom.javacodesimple.api.bsh;

import ognl.OgnlException;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.bsh.BshScriptEvaluator;
import org.springframework.scripting.groovy.GroovyScriptEvaluator;
import org.springframework.scripting.support.StaticScriptSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BshController {
    @GetMapping("/bsh/bad01")
    public String bsh01(String payload) throws OgnlException {
        BshScriptEvaluator evaluator = new BshScriptEvaluator();
//        String script = "java.lang.Runtime.getRuntime().exec(\"/System/Applications/Calculator.app/Contents/MacOS/Calculator\");";//ok
        evaluator.evaluate(new StaticScriptSource(payload));//重要.
        return  "{'msg':'false'}";
    }
}
