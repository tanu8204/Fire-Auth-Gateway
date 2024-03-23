package com.example.FireAuthGateway.FireBaseInitialization;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class FirebaseInitialization {

    private static final Map<String, FirebaseApp> instances = new HashMap<>();

    @PostConstruct
    public void initialization() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("./serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp app = FirebaseApp.initializeApp(options, "myCustomAppName");

            synchronized (instances) {
                instances.put("myCustomAppName", app);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}