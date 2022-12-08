package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.noth.nothapp.databinding.ActivityDetailsBinding;
import com.noth.nothapp.databinding.ActivityOnBoardingBinding;

public class OnBoardingActivity extends AppCompatActivity {
    ActivityOnBoardingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnBoardingActivity.this, SigninActivity.class));
                finish();
            }
        });
    }
}