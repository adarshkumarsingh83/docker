package com.espark.adarsh.repository;

import com.espark.adarsh.bean.MessageBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MessageRepository extends MongoRepository<MessageBean,String> {

    public MessageBean findByMessageId(String messageId);

    public List<MessageBean> findAll();
}
