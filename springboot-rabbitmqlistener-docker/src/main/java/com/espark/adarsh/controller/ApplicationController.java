package com.espark.adarsh.controller;

import com.espark.adarsh.bean.MessageBean;
import com.espark.adarsh.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageService messageService;

    @PostMapping("/message")
    public void sendMessage(@RequestBody MessageBean message) {
        logger.info("label='send-controller' {}", message);
        this.messageService.send(message);
    }

    @GetMapping("/message/{id}")
    public MessageBean getMessage(@PathVariable("id") String id) {
        MessageBean data = this.messageService.receive(id);
        logger.info("label='get-controller' {}", data);
        return data;
    }

}
