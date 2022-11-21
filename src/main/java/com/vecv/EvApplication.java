package com.vecv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EvApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvApplication.class, args);
	}

}
