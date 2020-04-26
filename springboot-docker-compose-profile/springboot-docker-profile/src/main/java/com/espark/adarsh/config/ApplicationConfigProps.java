package com.espark.adarsh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("espark.props")
@EnableConfigurationProperties
public class ApplicationConfigProps {

    private String name;
    private String message;
    private String profile;


}
