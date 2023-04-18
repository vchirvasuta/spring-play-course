package com.vali.demo;

import com.vali.demo.json.Greeting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(context);

		System.out.println(context.getClass().getName());

		int count = context.getBeanDefinitionCount();
		System.out.println("Number of loaded beans is " + count);

		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}

	@Test
	void noGreedingInAppContext() {
		Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean(Greeting.class));
	}


}
