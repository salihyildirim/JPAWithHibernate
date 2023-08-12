package com.example.hibernateAndJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class HibernateAndJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAndJpaApplication.class, args);
	}

}
