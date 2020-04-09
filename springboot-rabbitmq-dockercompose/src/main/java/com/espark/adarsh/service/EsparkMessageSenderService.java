package com.espark.adarsh.service;

import com.espark.adarsh.bean.EpsarkMessage;
import com.espark.adarsh.configuration.ApplicationConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class EsparkMessageSenderService {


    private final RabbitTemplate rabbitTemplate;

    public EsparkMessageSenderService(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendMessage() {
        final EpsarkMessage message = new EpsarkMessage("hello from espark", new Random().nextInt(50), false);
        log.info("Sending message...");
        rabbitTemplate
                .convertAndSend(ApplicationConfiguration.EXCHANGE_NAME, ApplicationConfiguration.ROUTING_KEY, message);
    }
}
