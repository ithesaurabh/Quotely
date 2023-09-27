package com.example.quotely;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.ObjectsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class hamburger extends AppCompatActivity {
private ListView list;
private ImageView cross;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburger);
        list = findViewById(R.id.menu);
        cross = findViewById(R.id.cross);

        ArrayList<menu> arrayList = new ArrayList<>();
        arrayList.add(new menu(R.drawable.bookmark,"Favourites    "));
        arrayList.add(new menu(R.drawable.star,"Rate Us       "));
        arrayList.add(new menu(R.drawable.info_circle_fill,"About         "));
        arrayList.add(new menu(R.drawable.contact_us,"Contact Us    "));

        list_adapter ladapter = new list_adapter(this,R.layout.listview_lrf,arrayList);
        list.setAdapter(ladapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(hamburger.this,bookmark.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Toast.makeText(hamburger.this, "App hasn't been published yet", Toast.LENGTH_SHORT).show();
                }
                if (position == 2){
                    Intent intent = new Intent(hamburger.this,about.class);
                    startActivity(intent);
                }

            }
        });

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hamburger.this,homepage.class);
                startActivity(intent);
            }
        });

    }
}