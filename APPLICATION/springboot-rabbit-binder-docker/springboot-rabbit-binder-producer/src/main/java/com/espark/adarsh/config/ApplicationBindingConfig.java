package com.espark.adarsh.config;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ApplicationBindingConfig {

    @Output("employee-output-channel")
    MessageChannel employeeDataPublisher();

}
