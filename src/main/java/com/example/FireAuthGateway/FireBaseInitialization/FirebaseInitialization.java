package com.example.FireAuthGateway.FireBaseInitialization;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@Configuration
public class FirebaseInitialization {

    @Value("${firebase.credential.path}")
    private String credentialPath;
    @PostConstruct
    public void initialization() {
        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream(credentialPath);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            log.info("Firebase initialized successfully.");
        } catch (IOException e) {
            log.error("Error occurred while initializing Firebase: {}", e.getMessage());
        } finally {
            if (serviceAccount != null) {
                try {
                    serviceAccount.close();
                } catch (IOException e) {
                    log.error("Error closing service account file: {}", e.getMessage());
                }
            }
        }
    }
}
/*@Configuration
public class FirebaseInitialization {
    @Bean
    public FirebaseApp getFireStore(@Value("${firebase.credential.path}") String credentialPath) throws IOException {
        var serviceAccount = new FileInputStream(credentialPath);
        var credentials = GoogleCredentials.fromStream(serviceAccount);

        System.out.println(credentials);

        var options = FirestoreOptions.newBuilder()
                .setCredentials(credentials).build();

        System.out.println(options);
      //  return options.getService();
        return FirebaseApp.initializeApp(String.valueOf(options));

    }
}*/
