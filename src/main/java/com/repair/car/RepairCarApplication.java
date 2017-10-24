package com.repair.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.repair.car")
public class RepairCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepairCarApplication.class, args);
	}
}