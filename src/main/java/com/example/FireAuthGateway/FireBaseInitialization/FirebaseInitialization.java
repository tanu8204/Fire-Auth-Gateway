package com.example.FireAuthGateway.FireBaseInitialization;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class FirebaseInitialization {

    private static final Map<String, FirebaseApp> instances = new HashMap<>();

    @Bean
    public FirebaseApp initialization() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp app = FirebaseApp.initializeApp(options, "myCustomAppName");
        synchronized (instances) {
            instances.put("myCustomAppName", app);
        }
        return app;
    }

    public static Map<String, FirebaseApp> getInstances() {
        return instances;
    }
}
