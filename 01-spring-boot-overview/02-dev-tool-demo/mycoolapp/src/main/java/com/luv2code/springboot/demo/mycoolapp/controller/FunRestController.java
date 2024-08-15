package com.luv2code.springboot.demo.mycoolapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String returnHelloWorld(){
        return "Hello World!";
    }

    @GetMapping("/hello2")
    public String returnHelloWorld2(){
        return "this is Hello World2";
    }
}
