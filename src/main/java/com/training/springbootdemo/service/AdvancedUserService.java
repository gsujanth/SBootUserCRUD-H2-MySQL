package com.training.springbootdemo.service;

import com.training.springbootdemo.model.AdvancedUser;
import com.training.springbootdemo.model.FullName;
import com.training.springbootdemo.repository.AdvancedUserJdbcRepository;
import com.training.springbootdemo.repository.AdvancedUserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdvancedUserService {

    @Autowired
    private AdvancedUserJpaRepository advancedUserJpaRepository;

    @Autowired
    private AdvancedUserJdbcRepository advancedUserJdbcRepository;

    public AdvancedUser getUserByLastName(String lastName) {
        return advancedUserJpaRepository.findByLastName(lastName);
    }

    public void createAdvancedUser(AdvancedUser advancedUser) {
        log.debug("Creating AdvancedUser: {}", advancedUser);
        advancedUserJpaRepository.save(advancedUser);
    }

    public List<FullName> getAdvancedUsersFullNames() {
        return advancedUserJdbcRepository.getAdvancedUsersFullNames();
    }

    public AdvancedUser getUserByFirstName(String firstName) {
        return advancedUserJdbcRepository.getAdvancedUserByFirstName(firstName);
    }
}
