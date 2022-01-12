package com.training.springbootdemo;

import static org.assertj.core.api.Assertions.assertThat;

import com.training.springbootdemo.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserCrudApplicationTests {

	@Autowired
	private HelloController controller;

	@Test
	public void contextLoads()throws Exception{
		assertThat(controller).isNotNull();
	}

}
