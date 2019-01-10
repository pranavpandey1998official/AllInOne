package com.wisel.preschool.learning.allinonekids.adapters.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wisel.preschool.learning.allinonekids.R;

public class MainActivityViewHolder extends RecyclerView.ViewHolder {

    public ImageView ivTopic;
    public LinearLayout llParent;
    public TextView tvTopic;

    public MainActivityViewHolder(View itemView) {

        super(itemView);
        tvTopic = itemView.findViewById(R.id.tvTopic);

        //title.setTypeface(UtilityFile.getTfCursiveRegular());

        ivTopic = itemView.findViewById(R.id.ivTopic);
        llParent = itemView.findViewById((R.id.rvMainActivity));

    }

}
