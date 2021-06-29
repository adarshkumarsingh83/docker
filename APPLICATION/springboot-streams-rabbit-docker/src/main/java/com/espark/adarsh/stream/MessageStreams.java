package com.espark.adarsh.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageStreams {

    final String INPUT = "message-in";
    final String OUTPUT = "message-out";

    @Input(INPUT)
    SubscribableChannel inboundMessage();

    @Output(OUTPUT)
    MessageChannel outboundMessage();
}
