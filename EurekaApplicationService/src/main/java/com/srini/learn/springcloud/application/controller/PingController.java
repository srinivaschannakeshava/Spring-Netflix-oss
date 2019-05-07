package com.srini.learn.springcloud.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {
	@Value("${service.instance.name}")
	private String instance;

	private int count = 0;

	@RequestMapping(path = "/instance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getInstanceValue(@RequestHeader(name = "x-location", required = false) String location) {
		count++;
		if (count % 5 == 0) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (count % 7 == 0) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return "{\"instanceName\":" + instance + ",count : " + count + ",\"location\":" + location + "}";
	}
}
