package com.espark.adarsh.entity;

import com.espark.adarsh.model.MessageBean;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long timeStamp;

    private String message;

    public MessageEntity(){

    }

    public MessageEntity(MessageBean messageBean){
        this.name=messageBean.getName();
        this.timeStamp=messageBean.getTimeStamp();
        this.message=messageBean.getMessage();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
