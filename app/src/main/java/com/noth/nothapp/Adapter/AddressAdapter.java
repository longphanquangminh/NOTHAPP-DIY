package com.noth.nothapp.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noth.nothapp.databinding.ItemAddressBinding;
import com.noth.nothapp.Model.Address;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder> {
    private IAddress iAddress;

    public AddressAdapter(IAddress iAddress) {
        this.iAddress = iAddress;
    }

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAddressBinding binding = ItemAddressBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new AddressViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        Address address = iAddress.getListAddress(position);
        holder.binding.txtUserName.setText(address.getNameUser());
        holder.binding.txtPhone.setText(address.getPhoneNum());
        holder.binding.txtAddress.setText(address.getAddress());
    }

    @Override
    public int getItemCount() {
        return iAddress.getCount();
    }

    public class AddressViewHolder extends RecyclerView.ViewHolder {
        ItemAddressBinding binding;
        public AddressViewHolder(@NonNull ItemAddressBinding binding) {
            super(binding.txtUserName.getRootView());
            this.binding = binding;
        }
    }

    public interface IAddress {
        int getCount();
        Address getListAddress(int position);
    }
}
