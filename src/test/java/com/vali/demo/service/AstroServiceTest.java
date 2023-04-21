package com.vali.demo.service;

import com.vali.demo.json.Assignment;
import com.vali.demo.json.AstroResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroServiceTest {

    @Autowired
    private AstroService service;


    @Test
    void getAstronauts() {
        AstroResult result = service.getAstronauts();
        int number = result.getNumber();
        System.out.println("There are " + number + " people in space");

        List<Assignment> people = result.getPeople();

        assertAll(
                () -> assertTrue(number>=0),
                () -> assertEquals(number, people.size())
        );
    }

}