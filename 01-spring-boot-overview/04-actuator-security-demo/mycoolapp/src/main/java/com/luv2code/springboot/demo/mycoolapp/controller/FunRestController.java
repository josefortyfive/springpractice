package com.luv2code.springboot.demo.mycoolapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose
    @GetMapping("/")
    public String returnHelloWorld(){
        return "Hello World!";
    }

    @GetMapping("/hello2")
    public String returnHelloWorld2(){
        return "this is Hello World2";
    }

    //expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k";
    }

    //expose a new endpoint for "fortune"

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day!";
    }

}
