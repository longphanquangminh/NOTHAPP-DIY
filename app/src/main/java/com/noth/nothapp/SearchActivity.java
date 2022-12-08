package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.noth.nothapp.databinding.ActivitySearchBinding;
import com.noth.nothapp.Adapter.PopularAdapter;
import com.noth.nothapp.Model.Popular;
import com.noth.nothapp.R;

import java.util.ArrayList;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity implements PopularAdapter.IPopular {
    ActivitySearchBinding binding;
    ArrayList<Popular> popularArrayList;
    ArrayList<Popular> searchArrayList;
    PopularAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        popularArrayList = new ArrayList<>();
        searchArrayList = new ArrayList<>();
        adapter = new PopularAdapter(this);
        addDataSearch();
        initRecylerSearch();
        onClickSearchView();
        onClickBack();
    }

    private void onClickBack() {
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void onClickSearchView() {
        //Sử dụng searchView để tìm kiếm
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                popularArrayList.clear();
                if (newText.isEmpty()){
                    popularArrayList.addAll(searchArrayList);
                }else {
                    for (Popular list : searchArrayList) {
                        //So sánh nếu tên nếu giống sẽ thêm vào list mới
                        if (list.getNamePopular().toLowerCase(Locale.getDefault()).contains(newText.toLowerCase(Locale.getDefault()))){
                            popularArrayList.add(list);
                        }
                    }
                }
                initRecylerSearch();
                return true;
            }
        });
    }

    private void initRecylerSearch() {
        adapter = new PopularAdapter(this);
        binding.recyLerSearch.setLayoutManager(new GridLayoutManager(this,2));
        binding.recyLerSearch.setAdapter(adapter);
    }

    private void addDataSearch() {
        popularArrayList.add(new Popular("Ghế xoay",R.drawable.ghe2,5,2610000));
        popularArrayList.add(new Popular("Ghế Bành",R.drawable.ghe3,5,3610000));
        popularArrayList.add(new Popular("Sofa LINNAS",R.drawable.sofa1, 4.5f,4610000));
        popularArrayList.add(new Popular("Tủ PAX",R.drawable.tu,3.5f,5610000));
        popularArrayList.add(new Popular("Đèn HEKTAR",R.drawable.den,5,8610000));
        popularArrayList.add(new Popular("Ghế sofa",R.drawable.ghe4,5,7610000));
        popularArrayList.add(new Popular("Giường gỗ",R.drawable.giuong1,5,3610000));
        popularArrayList.add(new Popular("Sofa Dior",R.drawable.sofa2, 4.5f,4610000));
        popularArrayList.add(new Popular("Giường nhựa",R.drawable.giuong2,3.5f,5610000));
        popularArrayList.add(new Popular("Ghế gỗ",R.drawable.ghe,5,8610000));
        searchArrayList.addAll(popularArrayList);
    }

    @Override
    public int getCountPopular() {
        return popularArrayList.size();
    }

    @Override
    public Popular getListPopular(int position) {
        return popularArrayList.get(position);
    }

    @Override
    public void onClickItemPopular(int position) {
        Intent intent = new Intent(SearchActivity.this,DetailsActivity.class);
        Popular popular = popularArrayList.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("popular",popular);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}