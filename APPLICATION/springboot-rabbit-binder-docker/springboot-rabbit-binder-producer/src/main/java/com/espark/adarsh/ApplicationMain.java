package com.espark.adarsh;

import com.espark.adarsh.bean.Employee;
import com.espark.adarsh.config.ApplicationBindingConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@EnableScheduling
@SpringBootApplication
@EnableBinding(ApplicationBindingConfig.class)
public class ApplicationMain {

    @Autowired
    ApplicationBindingConfig applicationBindingConfig;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }

    @Scheduled(fixedDelay = 1000)
    public void publishEmployeeData() {
        Employee employee = new Employee() {
            {
                setEmpId(System.nanoTime() + "");
                setEmpName("employee-" + this.getEmpId());
            }
        };
        log.info("Publish to Employee Channel {}", employee);
        applicationBindingConfig.employeeDataPublisher().send(MessageBuilder.withPayload(employee).build());
    }

}
