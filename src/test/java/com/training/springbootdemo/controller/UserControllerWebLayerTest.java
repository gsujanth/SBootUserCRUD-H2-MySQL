package com.training.springbootdemo.controller;

import com.training.springbootdemo.model.User;
import com.training.springbootdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerWebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser(username = "user1", password = "pwd", roles = "USER")
    public void shouldReturnDefaultMessage() throws Exception {
        User user = new User(123, "Sujanth", "Guntupalli");
        doReturn(user).when(userService).getUser("Guntupalli");

        this.mockMvc.perform(get("/user/default")
                .contentType(MediaType.APPLICATION_JSON)
                //.header("x-api-key","yOlO$$$")
        ).andExpect(status().isOk())
                .andExpect(content().string("{\"id\":123,\"firstName\":\"Sujanth\",\"lastName\":\"Guntupalli\"}"));
    }
}
