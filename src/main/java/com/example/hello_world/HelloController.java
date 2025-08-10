package com.example.hello_world;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello(){
        log.info("GET request received: sayHello.");
        return "Hello World";
    }
}
