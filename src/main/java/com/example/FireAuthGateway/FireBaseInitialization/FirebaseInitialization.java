package com.example.FireAuthGateway.FireBaseInitialization;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class FirebaseInitialization {

  
    @PostConstruct
    public void initialization() {
        try {
            // FileInputStream serviceAccount =
            //         new FileInputStream("./serviceAccountKey.json");
            String serviceAccount = System.getenv("serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

        FirebaseApp.initializeApp(options, "myCustomAppName");

         

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
