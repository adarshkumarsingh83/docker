package com.espark.adarsh.service;

import com.espark.adarsh.entity.MessageEntity;
import com.espark.adarsh.model.MessageBean;
import com.espark.adarsh.respository.MessageRepository;
import com.espark.adarsh.stream.MessageStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.util.Optional;


@Slf4j
@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageStreams messageStreams;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void sendMessage(final MessageBean messageBean) {
        log.info("Sending messageBean {}", messageBean);

        MessageChannel messageChannel = messageStreams.outboundMessage();
        messageChannel.send(MessageBuilder
                .withPayload(messageBean)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                .build());
    }

    @Override
    public MessageBean getMessage(Long id) {
        Optional<MessageEntity> optionalMessageEntity = this.messageRepository.findById(id);
        log.info("getMessage messageBean {}", optionalMessageEntity);
        return optionalMessageEntity.isPresent() ? new MessageBean(optionalMessageEntity.get()) : null;

    }
}
