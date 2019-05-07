package com.srini.learn.springcloud.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.srini.learn.springcloud.application.filter.LocationAppendFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@Configuration
public class ZuulProxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulProxyServiceApplication.class, args);
	}

	@Bean
	public LocationAppendFilter injectZuulLocationFilter() {
		return new LocationAppendFilter();
	}

}
