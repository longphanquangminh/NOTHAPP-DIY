package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.noth.nothapp.databinding.ActivityOnBoardingBinding;
import com.noth.nothapp.databinding.ActivitySlashScreenBinding;

public class SlashScreenActivity extends AppCompatActivity {
    ActivitySlashScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySlashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayout llayout = (LinearLayout) findViewById(R.id.ll_Slash);
        llayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SlashScreenActivity.this, OnBoardingActivity.class));
                finish();
            }
        });
    }
}