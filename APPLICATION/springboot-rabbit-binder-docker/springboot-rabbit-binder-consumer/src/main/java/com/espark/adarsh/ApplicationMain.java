package com.espark.adarsh;

import com.espark.adarsh.bean.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@SpringBootApplication
@EnableBinding(Sink.class)
public class ApplicationMain {


    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void employeeDataListener(Employee employee) {
        log.info("Subscribed To Employee Channel {}", employee);
    }
}
