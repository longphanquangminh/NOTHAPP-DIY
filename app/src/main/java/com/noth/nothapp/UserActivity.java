package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.noth.nothapp.databinding.ActivityMainBinding;
import com.noth.nothapp.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {
    ActivityUserBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.llCheckOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this, OrderInfoActivity.class));
            }
        });
        binding.llChinhSuaHoSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this, EditUserActivity.class));
            }
        });
        binding.llChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this, ResetPassActivity.class));
            }
        });
        binding.llAddressBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this, AddressBookActivity.class));
            }
        });
        binding.llPaymentMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserActivity.this, PaymentMethodActivity.class));
            }
        });
        binding.llLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                MainActivity.fa.finish();
                Toast.makeText(UserActivity.this,"Đăng xuất thành công!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserActivity.this, SigninActivity.class));
            }
        });
    }
}