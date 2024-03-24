package com.example.FireAuthGateway.Service;

import com.example.FireAuthGateway.Entity.Users;
import com.example.FireAuthGateway.FireBaseInitialization.FirebaseInitialization;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UsersService {

    private static final String COLLECTION_NAME = "crud_user";

    public String saveUsers(Users users) throws ExecutionException, InterruptedException {

        Firestore dbFirestore=FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document(users.getUsername()).set(users);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public Users getUsersDetails(String username) throws ExecutionException, InterruptedException {

        FirebaseApp customApp = FirebaseApp.getInstance("myCustomAppName"); // Retrieve custom app instance
        Firestore dbFirestore = FirestoreClient.getFirestore(customApp); // Use custom app instance for Firestore


        DocumentReference documentReference=dbFirestore.collection(COLLECTION_NAME).document(username);

        ApiFuture<DocumentSnapshot> future= documentReference.get();

        DocumentSnapshot document= future.get();

        Users users=null;
        if(document.exists()){
            users=document.toObject(Users.class);
            return users;
        }else{
            return null;
        }
        /*try {
            FirebaseApp customApp = firebaseInitialization.getFirebaseApp();
            Firestore dbFirestore = FirestoreClient.getFirestore(customApp);

            DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(username);
            ApiFuture<DocumentSnapshot> future = documentReference.get();
            DocumentSnapshot document = future.get();

            if (document.exists()) {
                return document.toObject(Users.class);
            } else {
                logger.warn("User with username '{}' not found", username);
                return null;
            }
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Error getting user details", e);
            // Handle the error appropriately, e.g., throw custom exception or return null
            return null;
        }*/

    }


    public String updateUsers(Users users) throws ExecutionException, InterruptedException {

        Firestore dbFirestore=FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document(users.getUsername()).set(users);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public String deleteUsers(String username) throws ExecutionException, InterruptedException {

        Firestore dbFirestore=FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document(username).delete();

        return "Document with Product ID "+username+" has been deleted successfully";
    }
}
