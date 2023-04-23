package com.vali.demo.service;

import com.vali.demo.json.Response;
import com.vali.demo.json.Result;
import com.vali.demo.json.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GeocoderService {
    private static final String KEY="AIzaSyDw_d6dfxDEI7MAvqfGXEIsEMwjC1PWRno";

    private final WebClient client;

    @Autowired
    public GeocoderService(WebClient.Builder builder) {
        client = builder.baseUrl("https://maps.googleapis.com").build();
    }

    public Site getLatLng(String... address) {
        String encoded = Stream.of(address)
                .map(s -> URLEncoder.encode(s, StandardCharsets.UTF_8))
                .collect(Collectors.joining(","));
        String path = "/maps/api/geocode/json";
        Response response = client.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                        .queryParam("address", encoded)
                        .queryParam("key", KEY)
                        .build()
                )
                .retrieve()
                .bodyToMono(Response.class)
                .block(Duration.ofSeconds(30));

        return new Site(response.getFormattedAddress(),
                response.getLocation().getLat(),
                response.getLocation().getLng());
    }
}
