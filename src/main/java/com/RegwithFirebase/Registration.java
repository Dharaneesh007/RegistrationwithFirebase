package com.RegwithFirebase;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class Registration {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

        Firestore db = FirestoreClient.getFirestore();
        Map<String, RegistrationModel> data = new HashMap<>();
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\tZOHO Career Registration Form \n");
        System.out.println("Enter your Name : ");
        String name = input.nextLine();
        System.out.println("Enter your Date of Birth : ");
        String dob = input.nextLine();
        System.out.println("Enter your Email ID : ");
        String email = input.nextLine();
        System.out.println("Enter your College Name : ");
        String clgName = input.nextLine();
        System.out.println("Enter your Year of Passing : ");
        int yearOfPassing = input.nextInt();
        System.out.println("Are you Employed : (y/n)");
        String check = input.next();
        Boolean employed = false;
        int exp = 0;
        Double currentLPA = 0.0;
        if (Objects.equals(check, "y") || Objects.equals(check, "Y")) {
            employed = true;
            System.out.println("Enter your Experience in Years : ");
            exp = input.nextInt();
            System.out.println("Enter your Current LPA : ");
            currentLPA = input.nextDouble();
        }
        data.put(name, (new RegistrationModel(name, dob, email, clgName, yearOfPassing, employed, exp, currentLPA)));
        DocumentReference docRef = db.collection("register").document(name);
        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println("Thanks for choosing ZOHO Career.\nThe details of " + name + " will be verified and futher process will be intimated through the mail \n");
        System.out.println("Enter your choice - \n\n 1 - Register another, \n\n 2 - Exit");
        int no = input.nextInt();
        if (no == 1) {
            main(args);
        }
        OnBoarding.main(args);
    }
}
