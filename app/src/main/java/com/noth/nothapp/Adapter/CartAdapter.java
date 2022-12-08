package com.noth.nothapp.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noth.nothapp.databinding.ItemCartBinding;
import com.noth.nothapp.Model.Cart;
import com.noth.nothapp.Utils.Util;
import com.noth.nothapp.CartActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private ICart iCart;

    public CartAdapter(ICart iCart) {
        this.iCart = iCart;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCartBinding binding = ItemCartBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CartViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Cart Cart = iCart.getListCart(position);
        holder.binding.imgGioHang.setImageResource(Cart.getImgCart());
        holder.binding.nameDetails.setText(Cart.getNameProduct());
        holder.binding.txtMoneyPopular.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(Cart.getPriceProduct()) +" VNĐ");
        holder.binding.txtNumber.setText(""+Cart.getNumberProduct());
        holder.binding.btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soLuongMoi = Integer.parseInt(holder.binding.txtNumber.getText().toString())+1;
                holder.binding.txtNumber.setText(String.valueOf(soLuongMoi));
                int slHienTai = Util.CartArrayList.get(position).getNumberProduct();
                int giaHienTai = Util.CartArrayList.get(position).getPriceProduct();
                Util.CartArrayList.get(position).setNumberProduct(soLuongMoi);
                double giaMoi = (soLuongMoi*giaHienTai)/slHienTai;
                Util.CartArrayList.get(position).setPriceProduct((int) giaMoi);
                holder.binding.txtMoneyPopular.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(giaMoi) +" VNĐ");
                CartActivity.EvenChangeUtil();
            }
        });
        holder.binding.btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soLuongMoi = Integer.parseInt(holder.binding.txtNumber.getText().toString())-1;
                holder.binding.txtNumber.setText(String.valueOf(soLuongMoi));
                int slHienTai = Util.CartArrayList.get(position).getNumberProduct();
                int giaHienTai = Util.CartArrayList.get(position).getPriceProduct();
                Util.CartArrayList.get(position).setNumberProduct(soLuongMoi);
                double giaMoi = (soLuongMoi*giaHienTai)/slHienTai;
                Util.CartArrayList.get(position).setPriceProduct((int) giaMoi);
                holder.binding.txtMoneyPopular.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(giaMoi) +" VNĐ");
                CartActivity.EvenChangeUtil();
                if (soLuongMoi<2){
                    holder.binding.btnTru.setVisibility(View.GONE);
                    holder.binding.txtNumber.setText(String.valueOf(soLuongMoi));
                }else {
                    holder.binding.btnTru.setVisibility(View.VISIBLE);
                    holder.binding.txtNumber.setText(String.valueOf(soLuongMoi));
                }
            }
        });
        holder.binding.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.CartArrayList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                CartActivity.EvenChangeUtil();
            }
        });
    }

    @Override
    public int getItemCount() {
        return iCart.getCount();
    }

    public interface ICart{
        int getCount();
        Cart getListCart(int position);
    }
    public class CartViewHolder extends RecyclerView.ViewHolder{
        private ItemCartBinding binding;
        public CartViewHolder(@NonNull ItemCartBinding binding) {
            super(binding.txtNumber.getRootView());
            this.binding = binding;
        }
    }
}
