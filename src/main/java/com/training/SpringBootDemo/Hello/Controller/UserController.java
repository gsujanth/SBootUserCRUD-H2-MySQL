package com.training.SpringBootDemo.Hello.Controller;

import com.training.SpringBootDemo.Hello.Service.UserService;
import com.training.SpringBootDemo.Hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/json")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(){

    }

    @GetMapping("/user")
    public User getUser(){
        return userService.getUser("Guntupalli");
    }

    @GetMapping("/users")
    public List<User> getUsers() throws ExecutionException, InterruptedException {
        return userService.getUsers().get();
    }

    @PostMapping(path = "/user/add")
    public void addUser(Long id, @RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping(path = "/user/update/{userId}")
    public void updateUser(@PathVariable long userId, @RequestBody User user) {
        userService.updateUser(userId,user);
    }

    @DeleteMapping(path = "/user/delete/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/future/{value}")
    public Object getValueFromCompletedFuture(@PathVariable Object value) throws ExecutionException, InterruptedException {
        return userService.returnCompletedFutureWithGivenValue(value).get();
    }

}
