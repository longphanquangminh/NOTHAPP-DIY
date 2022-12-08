package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.noth.nothapp.databinding.ActivityEnterUserInfoForgetPasswordBinding;

public class EnterUserInfoForgetPasswordActivity extends AppCompatActivity {
    ActivityEnterUserInfoForgetPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnterUserInfoForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnGuiOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EnterUserInfoForgetPasswordActivity.this,"Vui lòng nhập OTP được gửi đến SĐT bạn nhập",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EnterUserInfoForgetPasswordActivity.this, EnterOtpForgetPasswordActivity.class));
                finish();
            }
        });
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EnterUserInfoForgetPasswordActivity.this,"Đã hủy thao tác quên mật khẩu!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}