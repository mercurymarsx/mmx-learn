package com.ohmmx.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class LearnApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LearnApplication.class, args);
	}
}
