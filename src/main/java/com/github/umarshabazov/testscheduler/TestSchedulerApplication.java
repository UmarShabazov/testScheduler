package com.github.umarshabazov.testscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@EnableWebSecurity
//@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class TestSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSchedulerApplication.class, args);
	}

}
