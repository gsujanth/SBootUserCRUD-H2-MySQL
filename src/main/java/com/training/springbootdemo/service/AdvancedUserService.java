package com.training.springbootdemo.service;

import com.training.springbootdemo.model.AdvancedUser;
import com.training.springbootdemo.repository.AdvancedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvancedUserService {

    @Autowired
    private AdvancedUserRepository advancedUserRepository;

    public AdvancedUser getUser(String str) {
        return advancedUserRepository.findByLastName(str);
    }
}
