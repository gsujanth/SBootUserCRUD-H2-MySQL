package com.training.SpringBootDemo.Hello.Repository;

import com.training.SpringBootDemo.Hello.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLastName(String lName);

}
