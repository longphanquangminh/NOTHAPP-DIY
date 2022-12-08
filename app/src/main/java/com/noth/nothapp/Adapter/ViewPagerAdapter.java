package com.noth.nothapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.noth.nothapp.Model.Pager;
import com.noth.nothapp.R;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private List<Pager> pagerList;

    public ViewPagerAdapter(List<Pager> pagerList) {
        this.pagerList = pagerList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_view_pager,container,false);
        ImageView imgPager = view.findViewById(R.id.imgPager);
        Pager pager = pagerList.get(position);
        Glide.with(container.getContext()).load(pager.getResoucePager()).into(imgPager);
        //add view
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if (pagerList != null) {
            return pagerList.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
