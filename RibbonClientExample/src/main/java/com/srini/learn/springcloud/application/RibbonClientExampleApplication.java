package com.srini.learn.springcloud.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class RibbonClientExampleApplication {

	@Autowired
	private RestTemplate restRibbonTemplate;
	@Autowired
	DiscoveryClient client;

	public static void main(String[] args) {
		SpringApplication.run(RibbonClientExampleApplication.class, args);
	}

	@RequestMapping("/i")
	public String getListofInstances() {
		StringBuilder sb = new StringBuilder();
		client.getServices().forEach(id -> {
			client.getInstances(id).forEach(instance -> {
				sb.append(instance.getServiceId() + ":" + instance.getHost() + ":" + instance.getPort() + "\n");
			});
		});
		return sb.toString();
	}

	@RequestMapping("/a/**")
	public ResponseEntity<String> getFromAppServ() {
		return restRibbonTemplate.getForEntity("http://APP-SERV/ping/instance", String.class);
	}

}
