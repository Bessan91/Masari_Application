package com.example.masariproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img_logo = findViewById(R.id.img_logo);
        Animation top = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        img_logo.setAnimation(top);


        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, IntroductionActivity.class);
                startActivity(intent);
            }
        }, 5000);



    }

}