package com.srini.learn.springcloud.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.srini.learn.springcloud.application.service.AppApiService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
public class HystrixExampleApplication {

	@Autowired
	AppApiService aas;

	public static void main(String[] args) {
		SpringApplication.run(HystrixExampleApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(path = "/h/i")
	public String getAppInstance() {
		return aas.getAppInstance();
	}

}
