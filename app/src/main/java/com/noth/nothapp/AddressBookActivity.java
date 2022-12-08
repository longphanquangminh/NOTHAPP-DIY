package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.noth.nothapp.Adapter.AddressAdapter;
import com.noth.nothapp.Model.Address;
import com.noth.nothapp.databinding.ActivityAddressBookBinding;

import java.util.ArrayList;

public class AddressBookActivity extends AppCompatActivity implements AddressAdapter.IAddress {

    ActivityAddressBookBinding binding;
    ArrayList<Address> addressArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddressBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addressArrayList = new ArrayList<>();
        addDataAddress();
        initRecylerAddress();
        onBack();
    }

    private void onBack() {
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initRecylerAddress() {
        AddressAdapter addressAdapter = new AddressAdapter((AddressAdapter.IAddress) this);
        binding.recycLerAddress.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.recycLerAddress.setAdapter(addressAdapter);
    }

    private void addDataAddress() {
        addressArrayList.add(new Address("Long Phu", "0909652563", "27 Hong Ha"));
        addressArrayList.add(new Address("Trung Quan", "0909888999", "108 Hai Ba Trung"));
        addressArrayList.add(new Address("Minh Long", "0909456789", "32 Nguyen Kiem"));
        addressArrayList.add(new Address("My Tam", "0909123456", "92 Ngo Tat To"));
        addressArrayList.add(new Address("Ngoc Mai", "0909989898", "205 Pasteur"));
    }

    @Override
    public int getCount() {
        return addressArrayList.size();
    }

    @Override
    public Address getListAddress(int position) {
        return addressArrayList.get(position);
    }
}