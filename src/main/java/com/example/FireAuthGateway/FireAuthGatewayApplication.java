package com.example.FireAuthGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.FireAuthGateway.FirebaseInitialization","com.example.FireAuthGateway.Controller", "com.example.FireAuthGateway.Service"})
public class FireAuthGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(FireAuthGatewayApplication.class, args);



	}

}
