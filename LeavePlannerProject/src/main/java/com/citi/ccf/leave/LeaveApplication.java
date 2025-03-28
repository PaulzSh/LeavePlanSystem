package com.citi.ccf.leave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  // From spring-cloud-commons
public class LeaveApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeaveApplication.class, args);
    }
}