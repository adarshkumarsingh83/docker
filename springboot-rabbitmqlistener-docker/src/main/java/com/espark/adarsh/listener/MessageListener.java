package com.espark.adarsh.listener;

import com.espark.adarsh.bean.MessageBean;
import com.espark.adarsh.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    private MessageRepository messageRepository;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitListener(queues = "${app.queue}")
    private void getMessage(MessageBean messageBean) {
        this.messageRepository.save(messageBean);
        logger.info("label='listener' {}", messageBean);
    }

}
