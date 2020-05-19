package com.espark.adarsh;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public final class ApplicationController {

    @GetMapping("/greeting")
    public final String greeting() throws UnknownHostException {
        return "welcome to the espark adarsh  " + InetAddress.getLocalHost().getHostAddress();
    }
}