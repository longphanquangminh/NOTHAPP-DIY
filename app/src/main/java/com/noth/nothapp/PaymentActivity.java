package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.noth.nothapp.Utils.Util;
import com.noth.nothapp.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {
    ActivityPaymentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        int slMuaHang = intent.getIntExtra("soluong",0);
        binding.txtSoLuongDonHang.setText(String.valueOf(slMuaHang));
        binding.btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Bắt đầu một lệnh mới, kích hoạt PaymentActivity và ContinuebuyActivity.
                Intent intent = new Intent(PaymentActivity.this, ContinuebuyActivity.class);
                //Nạp chồng dữ liệu
                intent.putExtra("soluong", slMuaHang);
                startActivity(intent);
                finish();
                DetailsActivity.faDetails.finish();
                CartActivity.faCart.finish();
            }
        });
        //Kích hoạt nút back
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.imgGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Tạo hoạt động cho 2 nút radioDiscount và radioMomo,
        // mặc định giá trị là false để hệ thống ko tick sẵn --> cho khách hàng tick chọn
        binding.radioDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.radioMomo.setChecked(false);
            }
        });
        binding.radioMomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.radioDiscount.setChecked(false);
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