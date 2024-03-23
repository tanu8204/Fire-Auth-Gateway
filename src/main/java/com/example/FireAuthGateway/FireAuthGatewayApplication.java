package com.example.FireAuthGateway;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.io.FileNotFoundException;


@SpringBootApplication
public class FireAuthGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(FireAuthGatewayApplication.class, args);



	}

}
