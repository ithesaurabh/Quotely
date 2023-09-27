package com.example.quotely;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.FirebaseFirestore;

public class sign_up extends AppCompatActivity {
    private TextView email,password;
 private Button signup;
 private TextView alreadyUser;

 FirebaseDatabase rootNode;
 DatabaseReference reference ;
// FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = findViewById(R.id.emailId);
        password = findViewById(R.id.choosepassword);
        signup= findViewById(R.id.login);
        alreadyUser = findViewById(R.id.newuser);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(sign_up.this,homepage.class);
                startActivity(intent);
            }
        });
        alreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sign_up.this,log_in.class);
                startActivity(intent);
            }
        });

    }
}