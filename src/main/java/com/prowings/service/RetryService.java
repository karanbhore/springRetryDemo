package com.prowings.service;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class RetryService {

	@Retryable(value = { ArithmeticException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	public String retryDemo() {
		log.info(">>>>>>>>>>>>>> get hello started!!");
		int num = 11;
		if (num % 2 == 0) {
			log.info("get hello completed!!");
			return "success";
		} else
			throw new ArithmeticException();
	}

	@Recover
	public String getBackendResponseFallback(ArithmeticException e, String param1, String param2) {
		return "Backend is unavailable even after 3 rety attempts!!!!";
	}
	
}
