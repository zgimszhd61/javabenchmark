package com.freedom.javacodesimple.api.jndi;

import ognl.OgnlException;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.groovy.GroovyScriptEvaluator;
import org.springframework.scripting.support.StaticScriptSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

@RestController
@RequestMapping("/api")
public class JndiController {
    @GetMapping("/jndi/bad01")
    public String jndi01(String payload) throws OgnlException, NamingException {
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        env.put(Context.PROVIDER_URL, "rmi://trusted-server:1099");
        InitialContext ctx = new InitialContext(env);

        // BAD: User input used in lookup
        ctx.lookup(payload);
        return  "{'msg':'false'}";
    }
}
