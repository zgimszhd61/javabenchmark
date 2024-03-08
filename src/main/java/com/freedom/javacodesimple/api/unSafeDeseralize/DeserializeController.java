package com.freedom.javacodesimple.api.unSafeDeseralize;

import ognl.OgnlException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api")
public class DeserializeController {
    @GetMapping("/deserialize/bad01")
    public String Deserialize01(String payload) throws OgnlException, IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(payload.getBytes(StandardCharsets.UTF_8));
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object obj = (Object) ois.readObject();
        return  "{'msg':'false'}";
    }
}
