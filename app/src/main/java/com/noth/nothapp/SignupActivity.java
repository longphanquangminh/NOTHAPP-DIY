package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.noth.nothapp.ConfirmSignupActivity;
import com.noth.nothapp.R;
import com.noth.nothapp.databinding.ActivitySignupBinding;
import com.noth.nothapp.NothDatabase.Database;

public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding binding;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database = new Database(SignupActivity.this,"Database.sqlite",null,1);
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        customBtnSendOTP();
    }

    private void customBtnSendOTP() {
        binding.btnGuiOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = binding.edtPhone.getText().toString();
                if (TextUtils.isEmpty(phone)){
                    Toast.makeText(SignupActivity.this,"Dữ liệu không được để trống !!!",Toast.LENGTH_SHORT).show();
                }else {
                    //Thêm dữ liệu số điện thoại vào trong bảng database User
                    database.QueryData("INSERT INTO User VALUES(null,'" + phone + "')");
                    startActivity(new Intent(SignupActivity.this, ConfirmSignupActivity.class));
                    finish();
                }
            }
        });
    }
}