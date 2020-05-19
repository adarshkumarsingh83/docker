package com.espark.adarsh.service;

import com.espark.adarsh.bean.MessageBean;
import com.espark.adarsh.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class MessageServiceImpl implements MessageService{

    private  final Logger logger=LoggerFactory.getLogger(getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    Environment environment;

    @Value("${app.exchange}")
    private String exchange;

    @Value("${app.queue}")
    private String queue;

    @Value("${app.routing.key}")
    private String routingKey;


    @Override
    public void send(MessageBean message) {
        logger.info("label='send ' {}",message);
        if (!StringUtils.isEmpty(message)) {
            rabbitTemplate.convertAndSend(exchange, routingKey, message);
        }
    }

    @Override
    public MessageBean receive(String id) {
        MessageBean messageBean= this.messageRepository.findByMessageId(id);
        logger.info("label='receive ' {}",messageBean);
        return messageBean;
    }
}
