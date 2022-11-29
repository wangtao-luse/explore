package com.explore.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShiroApp {
public static void main(String[] args) {
	SpringApplication.run(ShiroApp.class, args);
}
}
