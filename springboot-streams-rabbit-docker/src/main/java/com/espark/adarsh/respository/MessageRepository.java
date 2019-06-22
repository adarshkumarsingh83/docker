package com.espark.adarsh.respository;

import com.espark.adarsh.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository  extends CrudRepository<MessageEntity,Long> {
}
