package com.espark.adarsh.service;

import com.espark.adarsh.entity.MessageEntity;
import com.espark.adarsh.model.MessageBean;
import com.espark.adarsh.respository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Slf4j
@Service
public class MessageServiceImpl implements MessageService{


    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void sendMessage(final MessageBean messageBean) {
        log.info("Sending messageBean {}", messageBean);
        this.messageRepository.save(new MessageEntity(messageBean));
    }

    @Override
    public MessageBean getMessage(Long id) {
        Optional<MessageEntity> optionalMessageEntity = this.messageRepository.findById(id);
        log.info("getMessage messageBean {}", optionalMessageEntity);
        return optionalMessageEntity.isPresent() ? new MessageBean(optionalMessageEntity.get()) : null;

    }
}
