package com.noth.nothapp.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noth.nothapp.databinding.ItemPopularBinding;
import com.noth.nothapp.Model.Popular;

import java.text.NumberFormat;
import java.util.Locale;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {
    private IPopular iPopular;

    public PopularAdapter(IPopular iPopular) {
        this.iPopular = iPopular;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPopularBinding binding = ItemPopularBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PopularViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Popular popular = iPopular.getListPopular(position);
        holder.binding.namePopular.setText(popular.getNamePopular());
        holder.binding.imagePopular.setImageResource(popular.getImgPopular());
        holder.binding.rating.setRating(popular.getRating());
        holder.binding.txtMoneyPopular.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(popular.getMoneyPopular()) +" VNĐ");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iPopular.onClickItemPopular(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return iPopular.getCountPopular();
    }

    public interface IPopular{
        int getCountPopular();
        Popular getListPopular(int position);
        void onClickItemPopular(int position);
    }
    public class PopularViewHolder extends RecyclerView.ViewHolder{
        ItemPopularBinding binding;
        public PopularViewHolder(@NonNull ItemPopularBinding binding) {
            super(binding.namePopular.getRootView());
            this.binding = binding;
        }
    }
}
