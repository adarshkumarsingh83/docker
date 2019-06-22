package com.espark.adarsh.model;

import com.espark.adarsh.entity.MessageEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@JsonRootName(value = "messageBean")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
public class MessageBean {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("timeStamp")
    private Long timeStamp;
    @JsonProperty("message")
    private String message;

    @JsonCreator
    public MessageBean() {
    }

    public MessageBean(MessageEntity messageEntity) {
        this.id = messageEntity.getId();
        this.name = messageEntity.getName();
        this.timeStamp = messageEntity.getTimeStamp();
        this.message = messageEntity.getMessage();
    }

}
