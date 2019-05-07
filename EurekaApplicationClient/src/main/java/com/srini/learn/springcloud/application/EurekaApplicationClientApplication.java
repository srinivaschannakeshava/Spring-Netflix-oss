package com.srini.learn.springcloud.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
public class EurekaApplicationClientApplication {
	@Autowired
	private EurekaClient client;
	
	@Autowired
	private RestTemplateBuilder restTempBuilder;

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplicationClientApplication.class, args);
	}
	@Scheduled(fixedRate = 1000)
	public void scheduleCall() {
		InstanceInfo nextServerFromEureka = client.getNextServerFromEureka("application-service", false);
		RestTemplate restTemplate = restTempBuilder.build();
	ResponseEntity<String> resp = restTemplate.exchange(nextServerFromEureka.getHomePageUrl()+"/ping/instance",HttpMethod.GET,null,String.class);
	System.out.println(resp.getBody());
	}
	

}
