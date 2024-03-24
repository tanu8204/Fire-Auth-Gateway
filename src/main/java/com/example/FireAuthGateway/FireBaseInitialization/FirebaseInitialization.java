package com.example.FireAuthGateway.FireBaseInitialization;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.Map;

@Service
public class FirebaseInitialization {

 //   private CountDownLatch latch = new CountDownLatch(1);  // Initialize latch with count 1

    private FirebaseApp firebaseApp;

    @PostConstruct
    public void initialization() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("./serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://fir-db-5c67e.firebaseio.com")
                    .setProjectId("fir-db-5c67e")
                    .build();

           this.firebaseApp = FirebaseApp.initializeApp(options, "myCustomAppName");
            System.out.println("Firebase initialized successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (firebaseApp == null) {
                throw new IllegalStateException("FirebaseApp initialization failed");
            }
        }
    }


}


