package com.explore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 1.添加spring-cloud-starter-netflix-eureka-server依赖
 * 2.配置Eureka-server
 * 3.使用@EnableEurekaServer标记Eureka-server
 * @author wwang
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class EurekaApp {
public static void main(String[] args) {
	SpringApplication.run(EurekaApp.class, args);
}
}