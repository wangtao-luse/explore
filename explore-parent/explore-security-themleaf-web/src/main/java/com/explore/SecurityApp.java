package com.explore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class SecurityApp {
public static void main(String[] args) {
	SpringApplication.run(SecurityApp.class, args);
}
@Bean
//使用轮询的负载均衡 @LoadBalanced
@LoadBalanced
public RestTemplate getRestTemplate(){
    return new RestTemplate();
}
}
