package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.noth.nothapp.Utils.Util;
import com.noth.nothapp.databinding.ActivityContinuebuyBinding;

public class ContinuebuyActivity extends AppCompatActivity {
    ActivityContinuebuyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContinuebuyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        int slMuaHang = intent.getIntExtra("soluong",0);
        Util.CartArrayList.clear();
        binding.btnTiepTucMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xóa sản phẩm đã ấn mua thành công, sau đó khởi tạo Màn hình Cảm ơn và Tiếp tục mua hàng
                // Util.CartArrayList.clear();
                finish();
            }
        });
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 101517742793063 là facebook ID của fanpage NOTHAPP (nothapp2022)
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://messaging/" + "101517742793063"));
                startActivity(i);
            }
        });
    }
}