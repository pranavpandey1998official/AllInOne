package com.wisel.preschool.learning.allinonekids.adapters.viewHolder.NavBarViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wisel.preschool.learning.allinonekids.R;
import com.wisel.preschool.learning.allinonekids.utility.UtilityFile;

public class NavBarViewHolder extends RecyclerView.ViewHolder {

    public ImageView ivNavBarColor;
    public LinearLayout parentViewHolder;
    public TextView tvNavBarColor;


    public NavBarViewHolder(View itemView) {

        super(itemView);

        tvNavBarColor = itemView.findViewById(R.id.tvNavBar);
        tvNavBarColor.setTypeface(UtilityFile.getTfCursiveRegular()); //setting typeface for Topics in main activity
        ivNavBarColor = itemView.findViewById(R.id.ivNavBar);
        parentViewHolder= itemView.findViewById((R.id.llNavBarColor));

    }
}
