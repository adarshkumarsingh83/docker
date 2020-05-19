package com.espark.adarsh.listener;

import com.espark.adarsh.bean.MessageBean;
import com.espark.adarsh.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

public class KafkaMessageListener {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageRepository messageRepository;

    @KafkaListener(topics = "${kafka.topic}")
    public void onReceiving(MessageBean messageBean, @Header(KafkaHeaders.OFFSET) Integer offset,
                            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
         this.messageRepository.save(messageBean);
        log.info("Processing topic = {}, partition = {}, offset = {}, messageBean = {}",
                topic, partition, offset, messageBean);
    }
}
