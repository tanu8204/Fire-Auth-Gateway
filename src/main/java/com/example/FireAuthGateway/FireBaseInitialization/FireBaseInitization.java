package com.example.FireAuthGateway.FireBaseInitialization;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class FireBaseInitization {

    @PostConstruct
    public void initializeFirestore() throws IOException, FileNotFoundException {
        FileInputStream serviceAccount =
                new FileInputStream("./serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        // Clear existing FirebaseApp instances
        for (FirebaseApp app : FirebaseApp.getApps()) {
            app.delete();
        }

        // Initialize FirebaseApp with the new options
        FirebaseApp.initializeApp(options);
    }

}
