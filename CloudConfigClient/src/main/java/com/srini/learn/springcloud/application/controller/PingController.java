package com.srini.learn.springcloud.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srini.learn.springcloud.application.CloudConfigurationProperties;

@RestController
public class PingController {
	@Autowired
	private CloudConfigurationProperties ccp;

	@Value("${application.specific.prop}")
	private String appProp;

	@RequestMapping(path = "/cloudConfig", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private CloudConfigurationProperties getCloudConfig() {
		return ccp;
	}

	@RequestMapping(path = "/appProp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	private String getappSpecificProp() {
		return appProp;
	}
}
