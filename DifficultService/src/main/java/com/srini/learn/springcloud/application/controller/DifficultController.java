package com.srini.learn.springcloud.application.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DifficultController {

	private String serviceName = "DifficultController";
	private int count = 0;

	@RequestMapping(path = "/count", method = RequestMethod.GET)
	public String getCount(@RequestHeader("x-location") String location) {
		return serviceName + " : " + count++ + " : Randomn number : " + Math.abs(Math.random()) + " : Location :"
				+ location;
	}
}
