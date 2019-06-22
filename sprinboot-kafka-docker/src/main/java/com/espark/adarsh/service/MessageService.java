package com.espark.adarsh.service;

import com.espark.adarsh.bean.MessageBean;
import org.springframework.stereotype.Service;

public interface MessageService {
    boolean sendMessage(MessageBean messageBean);

    MessageBean getMessage(String id);
}
