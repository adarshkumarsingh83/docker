package com.espark.adarsh.springbootdocker.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/docker/welcome")
public class ApplicationController {

    @GetMapping
    public String getWelcome(){
        return "welcome to the docker";
    }
}
