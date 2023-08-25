package com.example.masariproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class editPtofile extends AppCompatActivity {

    LottieAnimationView personLottie;

    TextView edit_pName;
    TextView edit_phone ;
    TextView edit_chPass ;
    TextView edit_pPass ;

    String ch_pass="";
    String pass="" ;
    String name="" ;
    String phone="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ptofile);

//        //navBar
//        personLottie=findViewById(R.id.personLottie);
//        personLottie.setRepeatCount(LottieDrawable.INFINITE);
//        personLottie.playAnimation();
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.logo);
//        BottomNavigationView bottom_nav=findViewById(R.id.navBar);
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



        setValue();

    }

    public void setValue(){
        edit_chPass=findViewById(R.id.edit_chPass);
        edit_pName=findViewById(R.id.edit_pName);
        edit_phone=findViewById(R.id.edit_phone);
        edit_pPass=findViewById(R.id.edit_pPass);

    }


    public void btn_pEdit(View view) {

        String ch_pass = edit_chPass.getText().toString().trim();
        String pass = edit_pPass.getText().toString().trim();
        String name = edit_pName.getText().toString().trim() ;
        String phone = edit_phone.getText().toString().trim() ;


        if(ch_pass.isEmpty() || pass.isEmpty() || name.isEmpty() || phone.isEmpty() ){

            Toast.makeText(getApplicationContext(), "يرجى إدخال البيانات كاملة", Toast.LENGTH_SHORT).show();

        }else {
            if (!ch_pass.equals(pass)) {
                Toast.makeText(getApplicationContext(), "كلمة المرور غير متطابقة", Toast.LENGTH_SHORT).show();
            } else {
                toursActivity.userInApp.setFullName(name);
                toursActivity.userInApp.setPassword(pass);
                toursActivity.userInApp.setPhoneNumber(phone);
                Toast.makeText(getApplicationContext(), "تم تعديل البيانات بنجاح :) ", Toast.LENGTH_SHORT).show();
                Log.i("user In Edit Profile ", toursActivity.userInApp.toString());

            }

            Handler handler = new Handler();
            handler.postDelayed(() -> {
                Intent intent = new Intent(editPtofile.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }, 1000);
        }

    }


    @Override
    protected void onStop() {
        super.onStop();

        if(!edit_pPass.getText().toString().isEmpty()) {
            ch_pass=edit_pPass.getText().toString().trim();
        }
        if(!edit_pName.getText().toString().isEmpty()) {
            name = edit_pName.getText().toString().trim();
        }
        if(!edit_pPass.getText().toString().isEmpty()) {
            pass = edit_pPass.getText().toString().trim();
        }
        if(!edit_phone.getText().toString().isEmpty()) {
            phone = edit_phone.getText().toString().trim();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(!ch_pass.isEmpty())
            edit_chPass.setText(ch_pass);

        if(!name.isEmpty())
            edit_pName.setText(name);

        if(!pass.isEmpty())
            edit_pPass.setText(pass);

        if(!phone.isEmpty())
            edit_phone.setText(phone);
    }


}