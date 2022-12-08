package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.noth.nothapp.R;
import com.noth.nothapp.databinding.ActivityConfirmSignupBinding;

public class ConfirmSignupActivity extends AppCompatActivity {
    ActivityConfirmSignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmSignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //Quay lại màn hình cũ
            }
        });
        binding.btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConfirmSignupActivity.this,"Đăng ký thành công! Mời bạn đăng nhập!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}