package com.example.quotely;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class bookmark extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView back;
    String[] l = {"aaaaaaaaaaa","bbbbbbbbbbb","cccccccccccc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        back = findViewById(R.id.buttonback);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bookmark_adapter adapter = new bookmark_adapter(l);
        recyclerView.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bookmark.this,homepage.class);
                startActivity(intent);
            }
        });
    }
}