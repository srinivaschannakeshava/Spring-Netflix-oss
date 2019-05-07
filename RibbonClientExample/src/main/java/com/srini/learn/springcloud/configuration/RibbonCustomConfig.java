package com.srini.learn.springcloud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class RibbonCustomConfig {
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}

	@Bean
	public IPing ribbonPing() {
		return new PingUrl();
	}
}
