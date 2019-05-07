package com.srini.learn.springcloud.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DifficultServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DifficultServiceApplication.class, args);
	}

}
