package com.noth.nothapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.noth.nothapp.CartActivity;
import com.noth.nothapp.DetailsActivity;
import com.noth.nothapp.SearchActivity;
import com.noth.nothapp.databinding.ActivityMainBinding;
import com.noth.nothapp.Adapter.CategoryAdapter;
import com.noth.nothapp.Adapter.DiscountAdapter;
import com.noth.nothapp.Adapter.PopularAdapter;
import com.noth.nothapp.Adapter.ViewPagerAdapter;
import com.noth.nothapp.Model.Category;
import com.noth.nothapp.Model.Discount;
import com.noth.nothapp.Model.Pager;
import com.noth.nothapp.Model.Popular;
import com.noth.nothapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.iCategory, DiscountAdapter.ISale, PopularAdapter.IPopular {
    ActivityMainBinding binding;
    int current;
    Runnable runnable;
    ArrayList<Category> categoryArrayList;
    ArrayList<Discount> giamGiaArrayList;
    ArrayList<Popular> phoBienArrayList;
    public static MainActivity fa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        categoryArrayList = new ArrayList<>();
        giamGiaArrayList = new ArrayList<>();
        phoBienArrayList = new ArrayList<>();
        fa = this;
        customViewFliper();
        addDataCategory();
        addDataGiamGia();
        addDataPhoBien();
        initRecylerCategory();
        intiReclerGiamGia();
        initRecylerPhoBien();
        onClickSearch();
        onClickCart();
        onClickToFacebookMessenger();
        onClickNavbarUser();
        onClickNotification();
    }

    private void onClickNotification() {
        binding.imvNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NotifyActivity.class));
            }
        });
    }

    private void onClickNavbarUser() {
        binding.imvNavbarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UserActivity.class));
            }
        });
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

    private void onClickCart() {
        binding.imvGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });
    }

    private void onClickSearch() {
        binding.edtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });
    }

    private void initRecylerPhoBien() {
        //khởi tạo adapter và hiển thị dữ liệu lên recyclerView
        PopularAdapter popularAdapter = new PopularAdapter(this);
        binding.recylerPhoBien.setLayoutManager(new GridLayoutManager(this,2));
        binding.recylerPhoBien.setAdapter(popularAdapter);
    }

    private void addDataPhoBien() {
        phoBienArrayList.add(new Popular("Ghế xoay",R.drawable.ghe2,5,2610000));
        phoBienArrayList.add(new Popular("Ghế Bành",R.drawable.ghe3,5,3610000));
        phoBienArrayList.add(new Popular("Sofa LINNAS",R.drawable.sofa1, 4.5f,4610000));
        phoBienArrayList.add(new Popular("Tủ PAX",R.drawable.tu,3.5f,5610000));
        phoBienArrayList.add(new Popular("Đèn HEKTAR",R.drawable.den,5,8610000));
        phoBienArrayList.add(new Popular("Ghế sofa",R.drawable.ghe4,5,7610000));
    }

    private void addDataCategory() {
        categoryArrayList.add(new Category("Ghế"));
        categoryArrayList.add(new Category("Sofa"));
        categoryArrayList.add(new Category("Bàn"));
        categoryArrayList.add(new Category("Tủ"));
        categoryArrayList.add(new Category("Đèn"));
    }
    private void addDataGiamGia(){
        giamGiaArrayList.add(new Discount(30,R.drawable.ghe1,"5.852.000","4.096.000",25));
        giamGiaArrayList.add(new Discount(27,R.drawable.sofa1,"5.852.000","4.096.000",11));
        giamGiaArrayList.add(new Discount(32,R.drawable.giuong1,"5.852.000","4.096.000",22));
        giamGiaArrayList.add(new Discount(25,R.drawable.ghe2,"5.852.000","4.096.000",27));
        giamGiaArrayList.add(new Discount(50,R.drawable.ghe3,"5.852.000","4.096.000",35));
        giamGiaArrayList.add(new Discount(10,R.drawable.giuong2,"5.852.000","4.096.000",45));
    }

    private void intiReclerGiamGia() {
        DiscountAdapter DiscountAdapter = new DiscountAdapter(this);
        binding.recylerGiamGia.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.recylerGiamGia.setAdapter(DiscountAdapter);
    }

    private void initRecylerCategory() {
        CategoryAdapter categoryAdapter = new CategoryAdapter(this);
        binding.recycLerMenu.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.recycLerMenu.setAdapter(categoryAdapter);
    }

    private void customViewFliper() {
        //Hiển thị các banner quản cáo
        ArrayList<Pager> pagerArrayList = new ArrayList<>();
        pagerArrayList.add(new Pager("https://scontent.fsgn6-1.fna.fbcdn.net/v/t39.30808-6/315649569_101518716126299_8395370912680806739_n.png?_nc_cat=106&ccb=1-7&_nc_sid=e3f864&_nc_ohc=9LmGdO6iZXAAX_QMUsF&_nc_oc=AQkA4Bsopr0ctq2hBt2Wnf0gCkv6VPqeJyk0y1ujbSLuY7zdOCFU5BjoyEmVvl0m024&_nc_ht=scontent.fsgn6-1.fna&oh=00_AfBkfLMTf1OIO5yNzWrtoPJHA4RIGZrDdtffqGyIkWpTyw&oe=63938803"));
        pagerArrayList.add(new Pager("https://admin.mhomedecor.com.vn/storage/media/v7dglvfPocxYNNrEbDGheXAHPSiw9teN6IR1CkDD.jpg"));
        pagerArrayList.add(new Pager("https://znews-photo.zingcdn.me/w660/Uploaded/wyhktpu/2021_05_07/200902_Styler_Banner_LivingRoom_Black_2.jpg"));
        pagerArrayList.add(new Pager("https://media.shoptretho.com.vn/upload/image/news/20221005/post-f.png"));
        pagerArrayList.add(new Pager("https://image.shutterstock.com/image-vector/modern-flat-furniture-concept-banner-260nw-1596871756.jpg"));
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(pagerArrayList);
        binding.viewPager.setAdapter(viewPagerAdapter);
        binding.circleIndicator.setViewPager(binding.viewPager);
        Handler handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                //cài đặt thời gian cứ 4s là đổi sang ảnh khác
                current =binding.viewPager.getCurrentItem();
                current++;
                if (current>=binding.viewPager.getAdapter().getCount()){
                    current =0;
                }
                binding.viewPager.setCurrentItem(current,true);
                handler.postDelayed(runnable,4000);
            }
        };
        handler.postDelayed(runnable,4000);
    }

    @Override
    public int getCountCategory() {
        return categoryArrayList.size();
    }

    @Override
    public Category getIemCategory(int position) {
        return categoryArrayList.get(position);
    }

    @Override
    public int getCount() {
        return giamGiaArrayList.size();
    }

    @Override
    public Discount getListSale(int position) {
        return giamGiaArrayList.get(position);
    }

    @Override
    public int getCountPopular() {
        return phoBienArrayList.size();
    }

    @Override
    public Popular getListPopular(int position) {
        return phoBienArrayList.get(position);
    }

    @Override
    public void onClickItemPopular(int position) {
        //Khi click vào item phổ biến thì sẽ truyền dữ liệu sang màn hình details
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        Popular popular = phoBienArrayList.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("popular",popular);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}