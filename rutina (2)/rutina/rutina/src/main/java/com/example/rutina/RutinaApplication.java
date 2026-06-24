package com.example.rutina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.example.rutina.client")
@SpringBootApplication
public class RutinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RutinaApplication.class, args);
	}

}
