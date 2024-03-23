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

    /*@PostConstruct
    public void initialization() {
        FileInputStream serviceAccount =
                null;
        try {
            serviceAccount = new FileInputStream("./serviceAccountKey.json");


        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

        private static boolean firebaseInitialized = false;
        @PostConstruct
        public void initialization() {
            if (!firebaseInitialized) {
                try {
                    FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
                    FirebaseOptions options = new FirebaseOptions.Builder()
                            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                            .build();
                    FirebaseApp.initializeApp(options);
                    firebaseInitialized = true;
                } catch (FileNotFoundException e) {
                    System.err.println("Service account JSON file not found.");
                    e.printStackTrace();
                } catch (IOException e) {
                    System.err.println("Error reading service account JSON file.");
                    e.printStackTrace();
                } catch (Exception e) {
                    System.err.println("Error initializing Firebase.");
                    e.printStackTrace();
                }
            }
        }

}
