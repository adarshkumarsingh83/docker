package com.espark.adarsh.controller;

import com.espark.adarsh.model.MessageBean;
import com.espark.adarsh.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/message/save")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendMessage(@RequestBody MessageBean messageBean) {
        messageService.sendMessage(messageBean);
    }


    @GetMapping("/message/{id}")
    public MessageBean getMessage(@PathVariable("id") Long id) {
        return this.messageService.getMessage(id);
    }
}
