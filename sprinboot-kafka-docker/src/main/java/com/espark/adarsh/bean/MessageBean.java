package com.espark.adarsh.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "espark")
public class MessageBean<T> {

    @Id
    private String messageId;
    private String definition;
    private T data;

    public MessageBean() {
    }

   /* @JsonCreator
    public MessageBean(@JsonProperty("messageId") String messageId,
                       @JsonProperty("definition") String definition
            , @JsonProperty("data") T data) {
        this.messageId = messageId;
        this.definition = definition;
        this.data = data;
    }*/

    public String getMessageId() {
        return messageId;
    }

    public String getDefinition() {
        return definition;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "messageId='" + messageId + '\'' +
                ", definition='" + definition + '\'' +
                ", data=" + data +
                '}';
    }
}
