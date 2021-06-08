package com.training.springbootdemo.service;

import com.training.springbootdemo.repository.UserRepository;
import com.training.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String str) {
        return userRepository.findByLastName(str);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    @Async
    public Future<List<User>> getUsers() {
        return new AsyncResult<List<User>>(userRepository.findAll());
    }

    public void updateUser(long userId, User user) {
        User userToUpdate = userRepository.getOne(userId);
        userToUpdate.setId(user.getId());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userRepository.save(userToUpdate);
    }

    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    public Future<Object> returnCompletedFutureWithGivenValue(Object value){
        return CompletableFuture.completedFuture(value);
    }
}
