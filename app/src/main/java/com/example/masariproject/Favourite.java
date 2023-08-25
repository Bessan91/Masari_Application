package com.example.masariproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.masariproject.MyAdabter.myFavoriteList;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Favourite extends AppCompatActivity {
    LottieAnimationView favLottie;
    TextView txt;
    private boolean favOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);
        BottomNavigationView bottom_nav = findViewById(R.id.navBar);
        bottom_nav.setSelectedItemId(R.id.fav);
        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mainMenu:
                        startActivity(new Intent(getApplicationContext(), toursActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.fav:
                        return true;
                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
        favLottie = findViewById(R.id.favLottie);
        favLottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (favOn) {
                    favLottie.setMinAndMaxProgress(0.5f, 1.0f);
                    favLottie.playAnimation();
                    favOn = false;
                } else {
                    favLottie.setMinAndMaxProgress(0.0f, 0.5f);
                    favLottie.playAnimation();
                    favOn = true;
                }
            }
        });


        RecyclerView FavRecycler;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        FavRecycler = findViewById(R.id.fav_Booking);
        txt = findViewById(R.id.msg_empty);

        if (toursActivity.userInApp.getToursListFavorite().size() < 0) {
            String msg = " لا يوجد مسارات مفضلة لديك  :)";
            txt.setText(msg);
            txt.setVisibility(View.VISIBLE);
            FavRecycler.setVisibility(View.GONE);
        } else {

            txt.setVisibility(View.GONE);
            FavRecycler.setVisibility(View.VISIBLE);

            FavRecycler.setLayoutManager(linearLayoutManager);
            RecyclerView.Adapter adapter;
//            ArrayList<tours> list = new ArrayList<>();
//            list.add(new tours("y","p1"));
//            list.add(new tours("z","p1"));
//            list.add(new tours("x","p1"));
            //adapter=new myFavoriteList(list);
            adapter = new myFavoriteList(toursActivity.userInApp.getToursListFavorite());
            FavRecycler.setAdapter(adapter);


        }


    }
}