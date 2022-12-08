package com.noth.nothapp.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noth.nothapp.databinding.ItemCategoryBinding;
import com.noth.nothapp.Model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private iCategory iCategory;

    public CategoryAdapter(CategoryAdapter.iCategory iCategory) {
        this.iCategory = iCategory;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = iCategory.getIemCategory(position);
        holder.binding.txtNameCategory.setText(category.getNameCategory());
    }

    @Override
    public int getItemCount() {
        return iCategory.getCountCategory();
    }

    public interface iCategory{
        int getCountCategory();
        Category getIemCategory(int position);
    }
    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        ItemCategoryBinding binding;
        public CategoryViewHolder(@NonNull ItemCategoryBinding binding) {
            super(binding.txtNameCategory.getRootView());
            this.binding = binding;
        }
    }
}
