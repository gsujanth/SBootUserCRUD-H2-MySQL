package com.training.springbootdemo.controller;

import com.training.springbootdemo.model.AdvancedUser;
import com.training.springbootdemo.service.AdvancedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/advancedUsers")
public class AdvancedUserController {

    @Autowired
    private AdvancedUserService advancedUserService;

    @GetMapping("/default")
    public AdvancedUser getDefaultAdvancedUser(){
        return advancedUserService.getUser("Guntupalli");
    }

    @PostMapping
    public void createAdvancedUser(@RequestBody @Valid AdvancedUser advancedUser){
        System.out.println(advancedUser);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
    }
}
