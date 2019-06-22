package com.espark.adarsh.service;

import com.espark.adarsh.model.MessageBean;

public interface MessageService  {
    void sendMessage(MessageBean messageBean);

    MessageBean getMessage(Long id);
}
