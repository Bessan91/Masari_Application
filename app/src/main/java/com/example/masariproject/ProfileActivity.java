package com.example.masariproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ProfileActivity extends AppCompatActivity {
    //i've added this
    LottieAnimationView personLottie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //navBar
        personLottie=findViewById(R.id.personLottie);
        personLottie.setRepeatCount(LottieDrawable.INFINITE);
        personLottie.playAnimation();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);
        BottomNavigationView bottom_nav=findViewById(R.id.navBar);
        bottom_nav.setSelectedItemId(R.id.account);
        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.mainMenu:
                        startActivity(new Intent(getApplicationContext(), toursActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.fav:
                        startActivity(new Intent(getApplicationContext(), Favourite.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.account:
                        return true;
                }
                return false;
            }
        });
    }

    public void btn_edit(View view) {
        Handler handler =new Handler();
        handler.postDelayed(() -> {
            Intent intent=new Intent(ProfileActivity.this,editPtofile.class);
            // userName .. search .. View data on EditText
            startActivity(intent);
            finish();
        },1000);
    }

    public void btn_position(View view) {
        //
    }

    public void btn_bookingList(View view) {
        Handler handler =new Handler();
        handler.postDelayed(() -> {
            Intent intent=new Intent(ProfileActivity.this, myListBooking.class);
            // userName .. search .. View ListBooking on ListView
            startActivity(intent);
            finish();
        },1000);
    }

    public void btn_Logout(View view) {
        Handler handler =new Handler();
        handler.postDelayed(() -> {
            Intent intent=new Intent(ProfileActivity.this,IntroductionActivity.class);
            // if You Sure ????????????????????????
            startActivity(intent);
            finish();
        },1000);
    }
}