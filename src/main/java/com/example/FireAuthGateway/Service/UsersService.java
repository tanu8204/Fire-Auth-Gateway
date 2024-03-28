/*
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


    public Users getUsersDetails(String username) throws ExecutionException, InterruptedException {

        FirebaseApp customApp = FirebaseApp.getInstance(); // Retrieve custom app instance
        System.out.println("customApp");
        Firestore dbFirestore = FirestoreClient.getFirestore(customApp); // Use custom app instance for Firestore
        System.out.println("dbFirestore");


        DocumentReference documentReference=dbFirestore.collection(COLLECTION_NAME).document(username);

        ApiFuture<DocumentSnapshot> future= documentReference.get();

        DocumentSnapshot document= future.get();
        System.out.println("document");

        Users users=null;
        if(document.exists()){
            users=document.toObject(Users.class);
            System.out.println("users");
            return users;
        }else{
            System.out.println("null");
            return null;

        }
    }
}*/
