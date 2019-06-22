package com.espark.adarsh.service;

import com.espark.adarsh.bean.MessageBean;
import com.espark.adarsh.repository.MessageRepository;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate<String, MessageBean> messageBeanKafkaTemplate;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public boolean sendMessage(MessageBean messageBean) {
        try {
            SendResult<String, MessageBean> sendResult = messageBeanKafkaTemplate.sendDefault(messageBean.getMessageId(), messageBean).get();
            RecordMetadata recordMetadata = sendResult.getRecordMetadata();
            LOGGER.info("topic = {}, partition = {}, offset = {}, messageBean = {}",
                    recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), messageBean);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MessageBean getMessage(String id){
        MessageBean response = this.messageRepository.findByMessageId(id);
        LOGGER.info("Response From the mongodb  messageBean = {}", response);
        return response!=null ? response : null;
    }
}
