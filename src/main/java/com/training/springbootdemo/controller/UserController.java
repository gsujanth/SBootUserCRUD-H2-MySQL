package com.training.springbootdemo.controller;

import com.training.springbootdemo.model.User;
import com.training.springbootdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
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
        try {
            userService.updateUser(userId, user);
        } catch(Exception e){
            log.error("Exception in updateUser() - {}", e.getMessage());
        }
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
