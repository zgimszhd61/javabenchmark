package com.freedom.javacodesimple.api.xxe;

import org.jdom2.input.sax.SAXHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

@RestController
@RequestMapping("/api")
public class XxeController {


    //2023.06.23:返回值为success.
    //攻击Payload:"<!DOCTYPE doc [ \n" +
    //                    "<!ENTITY xxe SYSTEM \"http://127.0.0.1:1664\">\n" +
    //                    "]><doc>&xxe;</doc>"

    @GetMapping("/xxe/bad01")
    public String xxe01(String xmlContent) throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputStream is = new ByteArrayInputStream(xmlContent.getBytes());
        Document doc = db.parse(is);
        return "success";
    }

    @GetMapping("/xxe/bad03")
    public String xxe03(String xmlContent) throws IOException, ParserConfigurationException, SAXException {
        SAXParserFactory factory  = SAXParserFactory.newInstance();
        SAXParser saxparser = factory.newSAXParser();
        SAXHandler handler = new SAXHandler();
        saxparser.parse(xmlContent, handler);
        return "success";
    }


}
