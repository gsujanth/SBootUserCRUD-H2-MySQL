package com.training.springbootdemo;

import com.training.springbootdemo.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ApplicationContextLoadTest {

	@Autowired
	private HelloController helloController;

	@Test
	public void contextLoads()throws Exception{
		assertThat(helloController).isNotNull();
	}

}
