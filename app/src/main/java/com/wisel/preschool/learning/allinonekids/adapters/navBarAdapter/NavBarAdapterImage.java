package com.wisel.preschool.learning.allinonekids.adapters.navBarAdapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wisel.preschool.learning.allinonekids.R;
import com.wisel.preschool.learning.allinonekids.adapters.viewHolder.NavBarViewHolder.NavBarViewHolder;
import com.wisel.preschool.learning.allinonekids.data.ImageData.ImageObject;
import com.wisel.preschool.learning.allinonekids.utility.UtilityFile;

import java.util.List;

public class NavBarAdapterImage extends RecyclerView.Adapter<NavBarViewHolder> {

    private Context context;
    private ViewPager viewPager;

    private List<ImageObject> imageObjectList;

    public NavBarAdapterImage(List<ImageObject> list, ViewPager viewPager, Context context) {

        this.imageObjectList = list;
        this.viewPager = viewPager;
        this.context = context;

    }

    @Override
    public NavBarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.navbar_reclycler_view_holder, parent, false);
        NavBarViewHolder holder = new NavBarViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull NavBarViewHolder holder, final int position) {

        holder.tvNavBarColor.setText(imageObjectList.get(position).title);
        Drawable drawable = UtilityFile.loadImageFromAssets(imageObjectList.get(position).image);
        holder.ivNavBarColor.setImageDrawable(drawable);
        holder.parentViewHolder.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(position);
                    }
                }
        );

    }

    @Override
    public int getItemCount() {

        return imageObjectList.size();

    }
}


