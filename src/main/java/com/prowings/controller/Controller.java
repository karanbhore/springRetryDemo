package com.prowings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.service.RetryService;

@RestController
public class Controller {

	@Autowired
	RetryService retryService;
	@GetMapping("/hello")
	public String retryDemo() {
		return retryService.retryDemo();
	}
}
