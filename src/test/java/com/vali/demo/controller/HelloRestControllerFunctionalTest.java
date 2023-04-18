package com.vali.demo.controller;

import com.vali.demo.json.Greeting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerFunctionalTest {

    @Test
    public void greedWithName(@Autowired TestRestTemplate template) {
       Greeting response = template.getForObject("/rest?name=Dolly", Greeting.class);
        Assertions.assertEquals("Greeting{message='Hello, Dolly!'}", response.toString());
    }

    @Test
    public void greedWithoutName(@Autowired TestRestTemplate template) {
        ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
        Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
        Assertions.assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());

        Greeting response = entity.getBody();

        if (response != null) {
            Assertions.assertEquals("Hello, World!", response.getMessage());
        }
    }
}
