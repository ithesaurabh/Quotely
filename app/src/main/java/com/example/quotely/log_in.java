package com.example.quotely;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class log_in extends AppCompatActivity {
    private Button login;
    private TextView newuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        login= findViewById(R.id.login);
        newuser = findViewById(R.id.newuser);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(log_in.this,homepage.class);
                startActivity(intent);
            }
        });
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(log_in.this,sign_up.class);
                startActivity(intent);
            }
        });

    }
}