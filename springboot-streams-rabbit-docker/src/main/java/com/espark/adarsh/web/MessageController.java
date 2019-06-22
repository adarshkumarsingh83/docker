package com.espark.adarsh.web;

import com.espark.adarsh.model.MessageBean;
import com.espark.adarsh.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendMessage(@RequestBody MessageBean messageBean) {
        messageService.sendMessage(messageBean);
    }


    @GetMapping("/message/{id}")
    public MessageBean getMessage(@PathVariable("id") Long id) {
        return this.messageService.getMessage(id);
    }
}
