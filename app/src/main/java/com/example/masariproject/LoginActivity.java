package com.example.masariproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.masariproject.Model.IUsersData;
import com.example.masariproject.Model.Users;
import com.example.masariproject.Model.UsersData;



    public class LoginActivity extends AppCompatActivity {
        //private Button buttonLogin;
        private EditText editEmail;
        private EditText editPass;
        private TextView txt_error;

        String email = "", pass = "";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            editEmail = findViewById(R.id.editEmail);
            editPass = findViewById(R.id.editPass);
            txt_error = findViewById(R.id.txt_error);
            txt_error.setVisibility(View.GONE);
        }

        public void btnLogin(View view) {
            email = editEmail.getText().toString().trim();
            pass = editPass.getText().toString().trim();

            //search for Email And Pass (Validation)
            IUsersData user = new UsersData();
            Users user_login = user.SearchForUser(email, pass);
            //Log.i("nn",user_login.getId()+"");


            if (((!email.isEmpty()) && (!pass.isEmpty())) && (user_login.getId() != -1)) {

                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    Intent intent = new Intent(this, toursActivity.class);
                    intent.putExtra("Users", user_login.getEmail().trim());
                    startActivity(intent);
                    finish();
                }, 100);
            } else {
                txt_error.setVisibility(View.VISIBLE);
            }
        }


        public void btn_Back(View view) {
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                Intent intent = new Intent(LoginActivity.this, IntroductionActivity.class);
                startActivity(intent);
                finish();
            }, 100);
        }


        @Override
        protected void onStop() {
            super.onStop();

            if (!editEmail.getText().toString().isEmpty()) {
                email = editEmail.getText().toString().trim();
            }
            if (!editPass.getText().toString().isEmpty()) {
                pass = editPass.getText().toString().trim();
            }
        }

        @Override
        protected void onResume() {
            super.onResume();
            if (!email.isEmpty())
                editEmail.setText(email);

            if (!pass.isEmpty())
                editPass.setText(pass);
        }
    }
