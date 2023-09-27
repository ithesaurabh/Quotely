package com.example.quotely;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class homepage extends AppCompatActivity {

    // creating a variable for
    // our Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our
    // Database Reference for Firebase.
    DatabaseReference databaseReference;
    private TextView Quote;
    private ImageView heart,hamburger;
   private RecyclerView category;
    String[] dataset = {"Motivation","Fitness","Poetic","Commerce","Politics"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        FirebaseApp.initializeApp(this);
        // below line is used to get the instance
        // of our Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get
        // reference for our database.
        databaseReference = firebaseDatabase.getReference("Data");


        Quote = findViewById(R.id.quote);

        // calling method
        // for getting data.
        getdata();


        hamburger = findViewById(R.id.hamburger);
        heart = findViewById(R.id.heart);
        category = findViewById(R.id.categoryRV);

        category_adapter cdapter = new category_adapter(dataset);
        LinearLayoutManager LLM = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        category.setLayoutManager(LLM);
        category.setAdapter(cdapter);
        final boolean[] isLiked = {false};
        int[] imageResources = {R.drawable.liked, R.drawable.heart};
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn).duration(10).repeat(0).playOn(heart);
                isLiked[0] = !isLiked[0];
                heart.setImageResource(imageResources[isLiked[0] ? 0 : 1]);

            }

        });
        hamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,hamburger.class);
                startActivity(intent);
            }
        });
    }


    private void getdata() {

        // calling add value event listener method
        // for getting the values from database.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                Quote.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(homepage.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}