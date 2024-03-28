package com.example.FireAuthGateway.Service;

import com.example.FireAuthGateway.Entity.Users;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class UsersService {

    private static final String COLLECTION_NAME = "crud_user";


    public Users getUsersDetails(String username) {
        try {
            FirebaseApp customApp = FirebaseApp.getInstance(); // Retrieve custom app instance
            log.debug("Custom app instance: {}", customApp);

            Firestore dbFirestore = FirestoreClient.getFirestore(customApp); // Use custom app instance for Firestore
            log.debug("Firestore instance: {}", dbFirestore);

            DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(username);

            ApiFuture<DocumentSnapshot> future = documentReference.get();

            DocumentSnapshot document = future.get();
            log.debug("Document: {}", document);

            if (document.exists()) {
                Users users = document.toObject(Users.class);
                log.debug("Retrieved user details: {}", users);
                return users;
            } else {
                log.info("User with username {} does not exist", username);
                return null;
            }
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error retrieving user details: {}", e.getMessage(), e);
            return null;
        }
    }
}
