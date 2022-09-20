package com.boot.mvc20220916nk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.boot.mvc20220916nk", "Student"})
public class Mvc20220916NkApplication {

	public static void main(String[] args) {

		SpringApplication.run(Mvc20220916NkApplication.class, args);

	}

}
