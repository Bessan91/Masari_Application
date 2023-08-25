package com.example.masariproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class IntroductionActivity extends AppCompatActivity {

    ViewFlipper flip ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        flip=findViewById(R.id.flip);
        int[] images = {R.drawable.s1, R.drawable.s2, R.drawable.s3} ;

        for (int image : images) {
            flipperImages(image);
        }



    }

    public void flipperImages(int img){
        ImageView imgView = new ImageView(this);
        imgView.setBackgroundResource(img);

        flip.addView(imgView);
        flip.setFlipInterval(4000); //4sec
        flip.setAutoStart(true);

        flip.setInAnimation(this,android.R.anim.slide_in_left);
        flip.setOutAnimation(this,android.R.anim.slide_out_right);

    }

    public void login(View view) {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(IntroductionActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, 1000);



    }

    public void sign(View view) {
        Handler handler =new Handler();
        handler.postDelayed(() -> {
            Intent intent=new Intent(IntroductionActivity.this,SignupActivity.class);
            startActivity(intent);
            finish();
        },1000);
    }
}