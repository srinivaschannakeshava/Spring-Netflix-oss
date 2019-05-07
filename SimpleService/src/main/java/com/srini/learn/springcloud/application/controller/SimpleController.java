package com.srini.learn.springcloud.application.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	private String serviceName = "SimpleController";
	private int count = 0;

	@RequestMapping(path = "/count", method = RequestMethod.GET)
	public String getCount(@RequestHeader("x-location") String location) {
		return serviceName + " : " + count++ + " : Location :" + location;
	}
}
