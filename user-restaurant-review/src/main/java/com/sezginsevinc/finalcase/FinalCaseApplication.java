package com.sezginsevinc.finalcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class FinalCaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinalCaseApplication.class, args);
	}

}
