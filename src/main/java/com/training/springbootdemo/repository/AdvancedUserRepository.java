package com.training.springbootdemo.repository;

import com.training.springbootdemo.model.AdvancedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvancedUserRepository extends JpaRepository<AdvancedUser, Long> {

    AdvancedUser findByLastName(String lastName);
}
