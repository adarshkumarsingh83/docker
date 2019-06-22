package com.espark.adarsh.controller;

import com.espark.adarsh.bean.MessageBean;
import com.espark.adarsh.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/message")
    public String sendMessage(@RequestBody MessageBean messageBean) {
        boolean response = this.messageService.sendMessage(messageBean);
        return (response ? "DATA SEND TO KAFA " : "DATA NOT SEND TO KAFA");
    }

    @GetMapping("/message/{id}")
    public MessageBean getMessage(@PathVariable("id") String id) {
        MessageBean response = this.messageService.getMessage(id);
        return response;
    }
}
