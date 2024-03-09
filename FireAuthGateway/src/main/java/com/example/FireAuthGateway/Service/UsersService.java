package com.example.FireAuthGateway.Service;

import com.example.FireAuthGateway.Entity.Users;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
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

        Firestore dbFirestore=FirestoreClient.getFirestore();

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
    }

}