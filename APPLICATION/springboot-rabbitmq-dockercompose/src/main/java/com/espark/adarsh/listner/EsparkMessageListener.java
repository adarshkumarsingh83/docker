package com.espark.adarsh.listner;

import com.espark.adarsh.bean.EpsarkMessage;
import com.espark.adarsh.configuration.ApplicationConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EsparkMessageListener {


    @RabbitListener(queues = ApplicationConfiguration.QUEUE_GENERIC_NAME)
    public void receiveMessage(final Message message) {
        log.info("Received message as generic: {}", message.toString());
    }

    @RabbitListener(queues = ApplicationConfiguration.QUEUE_SPECIFIC_NAME)
    public void receiveMessage(final EpsarkMessage customMessage) {
        log.info("Received message as specific class: {}", customMessage.toString());
    }
}
