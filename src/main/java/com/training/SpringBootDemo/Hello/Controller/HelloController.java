package com.training.SpringBootDemo.Hello.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greeting() {
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String SayHello(@PathVariable String name){
        return "Hello " +   name ;
    }
}
