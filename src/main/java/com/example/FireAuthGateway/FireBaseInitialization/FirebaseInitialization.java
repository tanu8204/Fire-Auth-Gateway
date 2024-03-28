/*
package com.example.FireAuthGateway.FireBaseInitialization;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Service
public class FirebaseInitialization {

    @Async
    @PostConstruct
    public CompletableFuture<Void> initializationAsync() {
        return CompletableFuture.runAsync(() -> {
            try {
                FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");

                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                FirebaseApp.initializeApp(options);
                System.out.println("Firebase initialized successfully");
                System.out.println(options);
            } catch (IOException e) {
                e.printStackTrace();
                throw new IllegalStateException("Error initializing Firebase", e);
            }
        });
    }
}
*/
