package com.example.masariproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.masariproject.Model.IUsersData;
import com.example.masariproject.Model.Users;
import com.example.masariproject.Model.UsersData;

public class SignupActivity extends AppCompatActivity {

    private EditText editFullname;
    private EditText editEmail ;
    private EditText editPass ;
    private EditText editpass_check ;
    private TextView errortxt ;


    String email="" ;
    String pass ="";
    String pass_ch="";
    String name="" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setValue();
    }

    public void setValue (){
        editFullname=findViewById(R.id.edit_Fullname);
        editEmail=findViewById(R.id.edit_email);
        editPass=findViewById(R.id.edit_pass);
        editpass_check=findViewById(R.id.edit_pass_check);
        errortxt=findViewById(R.id.error_txt);
        errortxt.setVisibility(View.GONE);

    }

    public void btnBack(View view) {
        Handler handler =new Handler();
        handler.postDelayed(() -> {
            Intent intent=new Intent(SignupActivity.this,IntroductionActivity.class);
            startActivity(intent);
            finish();
        },1000);
    }

    public void btn_Create(View view) {

        email = editEmail.getText().toString();
        pass = editPass.getText().toString() ;
        pass_ch = editpass_check.getText().toString() ;
        name = editFullname.getText().toString() ;


        if(email.isEmpty()||name.isEmpty()||pass.isEmpty()||pass_ch.isEmpty()){
            String error = "يرجى إدخال كافة البيانات !";
            errortxt.setText(error.toString());
            errortxt.setVisibility(View.VISIBLE);
        }
        else {
            if (!(pass.equals(pass_ch))) {
                String error = "تـأكد من تطابق كلمة السر مع تأكيدها !";
                errortxt.setText(error.toString());
                errortxt.setVisibility(View.VISIBLE);
            }else {
                Users newUser = new Users(name, email, pass);

                IUsersData user = new UsersData();
                Users ifUserExist = user.SearchForUserByEmail(email);

                if (ifUserExist.getId() != -1) {
                    String error = "البريد الإلكتروني المدخل موجود!!!";
                    errortxt.setText(error.toString());
                    errortxt.setVisibility(View.VISIBLE);
                } else {
                    //user.AddNewUser(newUser);
                    Handler handler = new Handler();
                    handler.postDelayed(() -> {

                        //user.AddNewUser(newUser);
                        Log.i("n", "User SignUp -->>>>>.." + newUser.getEmail());

                        Intent intent = new Intent(SignupActivity.this, toursActivity.class);
                        // intent.putExtra("NewUser", newUser.getEmail());
                        intent.putExtra("NewUser", newUser);
                        startActivity(intent);
                        finish();
                    }, 1000);
                }
            }
        }
    }



    @Override
    protected void onStop() {

        if(!editFullname.getText().toString().isEmpty()) {
            name=editFullname.getText().toString().trim();
        }
        if(!editEmail.getText().toString().isEmpty()) {
            email = editEmail.getText().toString().trim();
        }
        if(!editPass.getText().toString().isEmpty()) {
            pass = editPass.getText().toString().trim();
        }
        if(!editpass_check.getText().toString().isEmpty()) {
            pass_ch = editpass_check.getText().toString().trim();
        }

        super.onStop();

    }

    @Override
    protected void onResume() {
        if(!email.isEmpty())
            editEmail.setText(email);

        if(!pass.isEmpty())
            editPass.setText(pass);

        if(!name.isEmpty())
            editFullname.setText(name);

        if(!pass_ch.isEmpty())
            editpass_check.setText(pass_ch);

        super.onResume();
    }
}