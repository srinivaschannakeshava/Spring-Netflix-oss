package com.srini.learn.springcloud.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class AppApiService {
	@Autowired
	RestTemplate restTemplate;

	@Value("${app.service.url}")
	private String serviceUrl;

	@HystrixCommand(fallbackMethod = "serviceDown", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") })
	public String getAppInstance() {
		return restTemplate.getForEntity(serviceUrl, String.class).getBody();
	}

	public String serviceDown() {
		return "Service is Down :(";
	}

}
