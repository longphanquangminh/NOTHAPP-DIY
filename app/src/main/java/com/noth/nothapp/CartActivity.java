package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.noth.nothapp.databinding.ActivityCartBinding;
import com.noth.nothapp.Adapter.CartAdapter;
import com.noth.nothapp.Model.Cart;
import com.noth.nothapp.R;
import com.noth.nothapp.Utils.Util;

import java.text.NumberFormat;
import java.util.Locale;

public class CartActivity extends AppCompatActivity implements CartAdapter.ICart {
    private static ActivityCartBinding binding;
    CartAdapter adapter;
    int slMua = 0;
    public static CartActivity faCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new CartAdapter(this);
        faCart = this;
        initRecylerViewCart();
        onClickBack();
        EvenChangeUtil();
        onClickMuaHang();
        onClickToFacebookMessenger();
    }

    private void onClickToFacebookMessenger() {
        binding.imvToFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 101517742793063 là facebook ID của fanpage NOTHAPP (nothapp2022)
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://messaging/" + "101517742793063"));
                startActivity(i);
            }
        });
    }

    private void onClickMuaHang() {
        binding.linearMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Util.CartArrayList.size()==0) {
                    Toast.makeText(CartActivity.this,"Chưa có sản phẩm trong giỏ hàng",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    //Khi click mua hàng thì sẽ truyền số lượng sang màn hình thanh toán
                    Intent intent = new Intent(CartActivity.this,PaymentActivity.class);
                    int sl = Integer.parseInt(binding.txtSoLuongMuaHang.getText().toString().trim());
                    intent.putExtra("soluong",sl);
                    startActivity(intent);
                    // finish();
                }
            }
        });
    }

    public static void EvenChangeUtil() {
        //Hàm tính tổng tiền và số lượng mua hàng . Khi tăng giảm thì tiền và số lượng cũng thay đổi ngay sau đó
        int tongTien = 0;
        int sl = 0;
        for (int i = 0; i< Util.CartArrayList.size(); i++){
            tongTien+= Util.CartArrayList.get(i).getPriceProduct();
            sl += Util.CartArrayList.get(i).getNumberProduct();
        }
        binding.txtSoLuongSP.setText("("+sl+")");
        binding.txtSoLuongMuaHang.setText(sl+"");
        binding.txtTongTienThanhToan.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(tongTien) + " VNĐ");
    }

    private void initRecylerViewCart() {
        //khởi tạo adapter và hiển thị dữ liệu lên recyclerView
        adapter = new CartAdapter(this);
        binding.recylerGioHang.setLayoutManager(new LinearLayoutManager(this));
        binding.recylerGioHang.setAdapter(adapter);
    }

    private void onClickBack() {
        //Nút back quay lại màn hình cũ
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public int getCount() {
        //hàm trả về số lượng của list giỏ hàng
        if (Util.CartArrayList==null){
            return 0;
        }
        return Util.CartArrayList.size();
    }

    @Override
    public Cart getListCart(int position) {
        return Util.CartArrayList.get(position);
    }
}