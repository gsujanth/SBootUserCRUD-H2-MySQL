package com.training.springbootdemo;

import com.training.springbootdemo.service.UserService;
import com.training.springbootdemo.controller.UserController;
import com.training.springbootdemo.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    UserService userServiceMock;

    @InjectMocks
    UserController userController;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }

    @Test
    public void testGreeting(){

        when(userServiceMock.getUser("Guntupalli")).thenReturn(new User(123,"Sujanth","Guntupalli"));
        assertThat(new User(123,"Sujanth","Guntupalli")).isEqualTo(userServiceMock.getUser("Guntupalli"));

    }
}