package com.freedom.javacodesimple.api.groovyShell;

import cn.hutool.extra.expression.engine.mvel.MvelEngine;
import ognl.OgnlException;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.groovy.GroovyScriptEvaluator;
import org.springframework.scripting.support.StaticScriptSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class groovyController {
    @GetMapping("/groovy/bad01")
    public String groovy01(String payload) throws OgnlException {
        GroovyScriptEvaluator gse = new GroovyScriptEvaluator();
        ScriptSource scriptSource = new StaticScriptSource(payload);//关键用户输入
//        ScriptSource scriptSource = new StaticScriptSource("\"open -a Calculator\".execute().text");//关键用户输入
        gse.evaluate(scriptSource);
        return  "{'msg':'false'}";
    }
}
