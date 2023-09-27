package com.example.quotely;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ImageView logoImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Objects.<ActionBar>requireNonNull(getSupportActionBar()).hide();

        logoImg = findViewById(R.id.logoImg);
        YoYo.with(Techniques.FadeIn).duration(800).repeat(0).playOn(logoImg);

        Thread thread = new Thread(){

            public void run(){
                try{
                    sleep(2000);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                finally{
                    Intent intent = new Intent(MainActivity.this,sign_up.class);
                    startActivity(intent);
                    finish();
                }
            }

        };thread.start();

    }
}