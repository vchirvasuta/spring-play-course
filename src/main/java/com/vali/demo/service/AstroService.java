package com.vali.demo.service;

import com.vali.demo.json.AstroResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class AstroService {

    private final RestTemplate template;
    private final WebClient client;

    @Autowired
    public AstroService(RestTemplateBuilder templateBuilder, WebClient.Builder wcBuilder) {
        template = templateBuilder.build();
        client = wcBuilder.baseUrl("http://api.open-notify.org").build();
    }


    public AstroResult getAstronauts() {
        String url = "http://api.open-notify.org/astros.json";
        return template.getForObject(url, AstroResult.class);
    }

    public AstroResult getAstronautsWC() {
        return client.get()
                .uri("/astros.json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResult.class)
                .block(Duration.ofSeconds(2));
    }

}
