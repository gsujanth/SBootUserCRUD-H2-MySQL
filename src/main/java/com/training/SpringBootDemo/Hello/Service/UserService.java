package com.training.SpringBootDemo.Hello.Service;

import com.training.SpringBootDemo.Hello.Repository.UserRepository;
import com.training.SpringBootDemo.Hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUser(String str){
        return userRepository.findByLastName(str);
    }

    public void addUser(User user ){
        userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void updateUser(long userId,User user){
        User userToUpdate = userRepository.getOne(userId);
        userToUpdate.setId(user.getId());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userRepository.save(userToUpdate);
    }

    public void deleteUser(long userId){
        userRepository.deleteById(userId);
    }
}
