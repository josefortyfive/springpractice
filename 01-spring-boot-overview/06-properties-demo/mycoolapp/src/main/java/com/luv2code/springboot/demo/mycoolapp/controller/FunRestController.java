package com.luv2code.springboot.demo.mycoolapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for: coach.name and team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;


    @GetMapping("/coachinfo")
    public String coachInfo(){
        return "The name of the coach is "+coachName;
    }
    @GetMapping("/teaminfo")
    public String teamInfo(){
        return "The name of the team is "+teamName;
    }

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
