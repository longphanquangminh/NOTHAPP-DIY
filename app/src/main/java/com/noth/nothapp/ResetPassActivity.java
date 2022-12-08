package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.noth.nothapp.databinding.ActivityResetPassBinding;

public class ResetPassActivity extends AppCompatActivity {
    ActivityResetPassBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResetPassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imvBackToLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ResetPassActivity.this,"Đã hủy thao tác đổi mật khẩu!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        binding.btnConfirmChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ResetPassActivity.this,"Đổi mật khẩu thành công!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


}