package com.espark.adarsh.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public final class EpsarkMessage implements Serializable {

    private final String text;
    private final int priority;
    private final boolean secret;

    public EpsarkMessage(@JsonProperty("text") String text,
                         @JsonProperty("priority") int priority,
                         @JsonProperty("secret") boolean secret) {
        this.text = text;
        this.priority = priority;
        this.secret = secret;
    }

    public String getText() {
        return text;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isSecret() {
        return secret;
    }

    @Override
    public String toString() {
        return "EpsarkMessage{" +
                "text='" + text + '\'' +
                ", priority=" + priority +
                ", secret=" + secret +
                '}';
    }
}
