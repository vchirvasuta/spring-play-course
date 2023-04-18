package com.vali.demo.json;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Greeting {

    private String message;

    private Greeting() {

    }

    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "message='" + message + '\'' +
                '}';
    }
}
