package com.RegwithFirebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Admin {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> query = db.collection("register").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        Scanner input = new Scanner(System.in);
        int i = 0;
        for (int j = 0; j < 3; j++) {
            System.out.println("Enter Admin Password to proceed");
            String pass = input.nextLine();
            if (pass.equals("admin@123")) {
                System.out.println("Choose the action to be carried out!!! - \n\n 1 - To Display all the data!,\n\n 2 - To Search particular Data using email id!,\n\n 3 - To Delete particular Data using email id!");
                int k = input.nextInt();
                if (k == 1) {

                    for (QueryDocumentSnapshot document : documents) {
                        System.out.println("Email: " + document.getId());
                        System.out.println("Name: " + document.getData());
                    }
                    Admin.main(args);
                } else if (k == 2) {
                    System.out.println("Enter Email ID to be searched");
                    input.nextLine();
                    String emailsearch = input.nextLine();
                    for (QueryDocumentSnapshot document : documents) {
                        if (document.getId().equals(emailsearch)) {
                            System.out.println("Email: " + document.getId());
                            System.out.println("Name: " + document.getData());
                        }
                    }
                    Admin.main(args);
                } else if (k == 3) {
                    System.out.println("Enter Email ID to be deleted");
                    input.nextLine();
                    String delete = input.nextLine();
                    for (QueryDocumentSnapshot document : documents) {
                        if (document.getId().equals(delete)) {
                            document.getReference().delete();
                        }
                        System.out.println("Data related to "+delete+" has been deleted!!!!");
                    }
                    Admin.main(args);
                } else {
                    System.out.println("Enter correct number to choose actions!!!");
                }
                break;
            } else if (i == 2) {
                System.out.println("You have 0 attempts left!!!");
                System.out.println("You have entered incorrect password 3 times, Try again from the begining!!!");
                OnBoarding.main(args);
            } else {
                i++;
                System.out.println("Enter correct password." + (3 - i) + " attempts left.");
            }
        }
    }
}

