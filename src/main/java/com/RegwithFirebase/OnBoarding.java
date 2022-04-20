package com.RegwithFirebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class OnBoarding {

    public static void Switch(){

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Indicate your role!");
        System.out.println("Choose 1 - Admin, 2 - Student/Candidate!");
        int i = input.nextInt();
        if (i==1){
            Admin.main(args);
        }else if(i==2){
            Registration.main(args);
        }else{
            System.out.println("Enter the valid Input!!!");
            main(args);
        }

    }
}
