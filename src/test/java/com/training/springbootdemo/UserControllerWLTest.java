package com.training.springbootdemo;

import com.training.springbootdemo.controller.UserController;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=UserController.class)
//@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerWLTest {

    @Autowired
    private MockMvc mockMvc;

    @Ignore
    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/json/user")).andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(content().
                        string("{\"id\":123,\"firstName\":\"Sujanth\",\"lastName\":\"Guntupalli\"}"));

        //content().string(containsString("Hello World")
    }
   // andExpect(MockMvcResutMatchers.status().isOk()).
    //andExpect(MockMvcResutMatchers.content().string("{\"id\":1, "flavor":"Butterscotch"}"));

}
