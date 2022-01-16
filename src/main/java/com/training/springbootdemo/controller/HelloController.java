package com.training.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greeting() {
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello " +   name ;
    }
}
