package com.srini.learn.springcloud.application;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "cloud")
@Data
public class CloudConfigurationProperties {
	
 private String name;
 private String scope;
 private String purpose;
 
}
