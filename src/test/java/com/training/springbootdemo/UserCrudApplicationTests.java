package com.training.springbootdemo;

import static org.assertj.core.api.Assertions.assertThat;

import com.training.springbootdemo.controller.HelloController;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCrudApplicationTests {

	@Autowired
	private HelloController controller;

	@Ignore
	@Test
	public void contextLoads()throws Exception{
		assertThat(controller).isNotNull();
	}

}
