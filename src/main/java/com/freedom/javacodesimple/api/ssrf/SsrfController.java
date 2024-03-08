package com.freedom.javacodesimple.api.ssrf;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


// https://github.com/proudwind/javasec_study/blob/master/java%E4%BB%A3%E7%A0%81%E5%AE%A1%E8%AE%A1-ssrf.md
@RestController
@RequestMapping("/api")
public class SsrfController {
    @GetMapping("/ssrf/bad01")
    public String ssrf01(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        return connection.getResponseMessage();
    }
    @GetMapping("/ssrf/bad02")
    public String ssrf02(String imageUrl) throws IOException {
        BufferedImage img = ImageIO.read(new File(imageUrl));
        return "yes";
    }

}
