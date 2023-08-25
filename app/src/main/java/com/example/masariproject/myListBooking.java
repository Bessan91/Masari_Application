package com.example.masariproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.masariproject.MyAdabter.myListBookingAdapter;

public class myListBooking extends AppCompatActivity {

    TextView txt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_booking);

//        //navBar
//
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.logo);
//        BottomNavigationView bottom_nav=findViewById(R.id.navBar_x);
//        bottom_nav.setSelectedItemId(R.id.account);
//        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch(item.getItemId()){
//                    case R.id.mainMenu:
//                        startActivity(new Intent(getApplicationContext(), toursActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.fav:
//                        startActivity(new Intent(getApplicationContext(), Favourite.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.account:
//                        return true;
//                }
//                return false;
//            }
//        });


        RecyclerView bookingRecycler;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        bookingRecycler = findViewById(R.id.listBooking);
        txt = findViewById(R.id.msg_empty);

        if (toursActivity.userInApp.getToursBooking().size() < 0) {
            String msg = " لا يوجد مسارات محجوزة بعد :)";
            txt.setText(msg);
            txt.setVisibility(View.VISIBLE);
            bookingRecycler.setVisibility(View.GONE);
        } else {

            txt.setVisibility(View.GONE);
            bookingRecycler.setVisibility(View.VISIBLE);

            bookingRecycler.setLayoutManager(linearLayoutManager);
            RecyclerView.Adapter adapter;
            //adapter=new myListBookingAdapter(list);
//        ArrayList<tours> list = new ArrayList<>();
//        list.add(new tours("y","p1"));
//        list.add(new tours("z","p1"));
//        list.add(new tours("x","p1"));
            adapter = new myListBookingAdapter(toursActivity.userInApp.getToursBooking());
            bookingRecycler.setAdapter(adapter);

        }
    }










}