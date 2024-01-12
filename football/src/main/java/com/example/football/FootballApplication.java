package com.example.football;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.football.entity")
@EnableJpaRepositories("com.example.football.repository")
public class FootballApplication {
	public static void main(String[] args) {
		SpringApplication.run(FootballApplication.class, args);
	}
}
