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
                    .build();

           this.firebaseApp = FirebaseApp.initializeApp(options, "myCustomAppName");
            System.out.println("Firebase initialized successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (firebaseApp == null) {
            throw new IllegalStateException("FirebaseApp initialization failed");
        }
    }

    public FirebaseApp getFirebaseApp() {
        if (firebaseApp == null) {
            throw new IllegalStateException("FirebaseApp initialization failed");
        }
        return firebaseApp;
    }

//    public void awaitInitialization() throws InterruptedException {
//        latch.await();  // Wait for initialization to signal completion
//    }
/*
    private static final Logger logger = LoggerFactory.getLogger(FirebaseInitialization.class);

    private FirebaseApp firebaseApp;

    @PostConstruct
    public void initialization() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream(Config.serviceAccountKeyPath);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(Config.firebaseDatabaseURL)
                    .build();

            this.firebaseApp = FirebaseApp.initializeApp(options, "myCustomAppName");
            logger.info("Firebase initialized successfully");
        } catch (IOException e) {
            logger.error("Error initializing Firebase", e);
            throw new IllegalStateException("Error initializing Firebase", e);
        }

    }

    public FirebaseApp getFirebaseApp() {
        return firebaseApp;
    }*/

}


