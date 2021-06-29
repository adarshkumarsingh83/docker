package com.espark.adarsh.service;

import com.espark.adarsh.entity.MessageEntity;
import com.espark.adarsh.model.MessageBean;
import com.espark.adarsh.respository.MessageRepository;
import com.espark.adarsh.stream.MessageStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@EnableBinding(MessageStreams.class)
public class MessageListener {

    @Autowired
    private MessageRepository messageRepository;

    @StreamListener(MessageStreams.INPUT)
    public void handleMessageBean(MessageBean messageBean) {
        log.info("Received messageBean: {}", messageBean);
        this.messageRepository.save(new MessageEntity(messageBean));
    }
}
