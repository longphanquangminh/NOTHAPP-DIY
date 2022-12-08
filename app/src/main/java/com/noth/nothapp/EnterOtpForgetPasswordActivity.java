package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.noth.nothapp.databinding.ActivityEnterOtpForgetPasswordBinding;
import com.noth.nothapp.databinding.ActivitySigninBinding;

public class EnterOtpForgetPasswordActivity extends AppCompatActivity {
    ActivityEnterOtpForgetPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnterOtpForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EnterOtpForgetPasswordActivity.this,"Đã hủy thao tác quên mật khẩu!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        binding.btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EnterOtpForgetPasswordActivity.this,"Xác thực thành công! Hãy đổi mật khẩu!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EnterOtpForgetPasswordActivity.this, ForgotPasswordActivity.class));
                finish();
            }
        });
    }
}