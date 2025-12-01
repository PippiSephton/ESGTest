package com.esg.test.ESGTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.esg.test.ESGTest.repository")
@ComponentScan(basePackages = {"com.esg.test.ESGTest.service", "com.esg.test.ESGTest.controller", "com.esg.test.ESGTest.repository"})
public class EsgTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsgTestApplication.class, args);
	}

}
