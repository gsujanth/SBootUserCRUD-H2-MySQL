package com.training.springbootdemo.controller;

import com.training.springbootdemo.service.UserService;
import com.training.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(){

    }

    @GetMapping("/default")
    public User getDefaultUser(){
        return userService.getUser("Guntupalli");
    }

    @GetMapping("/all")
    public List<User> getAllUsers() throws ExecutionException, InterruptedException {
        return userService.getUsers().get();
    }

    @PostMapping(path = "/add")
    public void addUser(Long id, @RequestBody User user, @RequestHeader String source) {
        userService.addUser(user);
    }

    @PutMapping(path = "/update/{userId}")
    public void updateUser(@PathVariable long userId, @RequestBody User user) {
        userService.updateUser(userId,user);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/future/{value}")
    public Object getValueFromCompletedFuture(@PathVariable Object value) throws ExecutionException, InterruptedException {
        return userService.returnCompletedFutureWithGivenValue(value).get();
    }

}
