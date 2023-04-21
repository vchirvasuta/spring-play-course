package com.vali.demo.service;

import com.vali.demo.json.AstroResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AstroService {

    private final RestTemplate template;

    @Autowired
    public AstroService(RestTemplateBuilder templateBuilder) {
        template = templateBuilder.build();
    }


    public AstroResult getAstronauts() {
        String url = "http://api.open-notify.org/astros.json";
        return template.getForObject(url, AstroResult.class);
    }

}
