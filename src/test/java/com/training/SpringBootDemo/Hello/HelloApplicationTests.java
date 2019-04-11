package com.training.SpringBootDemo.Hello;

import static org.assertj.core.api.Assertions.assertThat;

import com.training.SpringBootDemo.Hello.Controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloApplicationTests {

	@Autowired
	private HelloController controller;

	@Test
	public void contextLoads()throws Exception{
		assertThat(controller).isNotNull();
	}

}
