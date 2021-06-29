package com.espark.adarsh.config;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.Duration;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.appender.LogstashTcpSocketAppender;
import net.logstash.logback.encoder.LogstashEncoder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ApplicationConfig {

    private static final String LOGSTASH_APPENDER_NAME = "LOGSTASH";

    @Value("${spring.logstash.url}")
    String url;

    @Value("${spring.application.name:'spring-boot-elk'}")
    String name;


    @Bean
    public LogstashTcpSocketAppender logstashAppender() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        LogstashTcpSocketAppender logstashTcpSocketAppender = new LogstashTcpSocketAppender();
        logstashTcpSocketAppender.setName(LOGSTASH_APPENDER_NAME);
        logstashTcpSocketAppender.setContext(loggerContext);
        logstashTcpSocketAppender.addDestination(url);
        LogstashEncoder encoder = new LogstashEncoder();
        encoder.setContext(loggerContext);
        encoder.setIncludeContext(true);
        encoder.setCustomFields("{\"espark\":\"" + name + "\"}");
        encoder.start();
        logstashTcpSocketAppender.setEncoder(encoder);
        logstashTcpSocketAppender.start();
        logstashTcpSocketAppender.setKeepAliveDuration(new Duration(300000));
        loggerContext.getLogger(Logger.ROOT_LOGGER_NAME).addAppender(logstashTcpSocketAppender);
        return logstashTcpSocketAppender;
    }

}
