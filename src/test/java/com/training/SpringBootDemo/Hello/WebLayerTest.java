package com.training.SpringBootDemo.Hello;

import com.training.SpringBootDemo.Hello.Controller.HelloController;
import com.training.SpringBootDemo.Hello.Controller.UserController;
import com.training.SpringBootDemo.Hello.Service.UserService;
import com.training.SpringBootDemo.Hello.model.User;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

      @Mock
    UserService userServiceMock;

    @InjectMocks
    UserController userController;

    @Ignore
    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }

    @Ignore
    @Test
    public void testGreeting(){

        when(userServiceMock.getUser("Guntupalli")).thenReturn(new User(123,"Sujanth","Guntupalli"));
        Assert.assertEquals(new User(123,"Sujanth","Guntupalli"),userServiceMock.getUser("Guntupalli"));

    }

//    @Mock
//    DataService dataServiceMock;
//
//    @InjectMocks
//    SomeBusinessImpl businessImpl;
//
//    @Test
//    public void testFindTheGreatestFromAllData() {
//        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
//        assertEquals(24, businessImpl.findTheGreatestFromAllData());
//    }
//
//    @Test
//    public void testFindTheGreatestFromAllData_ForOneValue() {
//        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 15 });
//        assertEquals(15, businessImpl.findTheGreatestFromAllData());
//    }
//
//    @Test
//    public void testFindTheGreatestFromAllData_NoValues() {
//        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
//        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
//    }
//}
}