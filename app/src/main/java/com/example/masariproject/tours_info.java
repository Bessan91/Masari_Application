package com.example.masariproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.masariproject.Model.tours;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class tours_info extends AppCompatActivity {
    private ImageView info_img;
    private TextView title, description, features;
    private Button book;
    private tours object;
    LottieAnimationView favLottie;
    private boolean favOn=false,booked=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours_info);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);
        setupViews();
        getBundle();
        BottomNavigationView bottom_nav=findViewById(R.id.navBar);
        bottom_nav.setSelectedItemId(R.id.mainMenu);
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
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        favLottie=findViewById(R.id.favLottie);
        favLottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(favOn){
                    favLottie.setSpeed(-1);
                    favLottie.playAnimation();
                    favOn = false;
                    //delete From favorate :
                    toursActivity.userInApp.deleteFromListFavorit(object);

                }
                else{
                    favLottie.setSpeed(1);
                    favLottie.playAnimation();
                    favOn = true;
                    //add:
                    toursActivity.userInApp.AddToListFavorate(object);
                }
            }
        });

    }

    private void getBundle() {
        object=(tours)getIntent().getSerializableExtra("object");
        int drawableResourceId=this.getResources().getIdentifier(object.getImage(),"drawable",this.getPackageName());
        Glide.with(tours_info.this).load(drawableResourceId).into(info_img);
        title.setText(object.getName());
        description.setText(object.getDescription());
        features.setText(object.getFeatures());
    }

    private void setupViews() {
        info_img=findViewById(R.id.info_img);
        title=findViewById(R.id.title);
        description=findViewById(R.id.description);
        features=findViewById(R.id.features);
        book=findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (booked) {
                    Toast.makeText(getApplicationContext(), "تم إلغاء حجز المسار", Toast.LENGTH_SHORT).show();
                    book.setText("حجز المسار");
                    booked=false;
                    //delete :
                    toursActivity.userInApp.deleteFromListBooking(object);
                }
                else{
                    Toast.makeText(getApplicationContext(), "تم حجز المسار", Toast.LENGTH_SHORT).show();
                    book.setText("إلغاء الحجز");
                    booked=true;
                    //add
                    toursActivity.userInApp.AddToListBooking(object);

                }
            }

        });
    }
}