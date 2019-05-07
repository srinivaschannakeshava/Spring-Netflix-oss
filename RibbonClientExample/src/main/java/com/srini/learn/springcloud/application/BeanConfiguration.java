package com.srini.learn.springcloud.application;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.srini.learn.springcloud.configuration.RibbonCustomConfig;

@Configuration
@RibbonClient(name = "custom-ribbon", configuration = RibbonCustomConfig.class)
public class BeanConfiguration {

	@Bean
	@LoadBalanced
	public RestTemplate getRibbonRestTemplate() {
		return new RestTemplate();
	}
}
