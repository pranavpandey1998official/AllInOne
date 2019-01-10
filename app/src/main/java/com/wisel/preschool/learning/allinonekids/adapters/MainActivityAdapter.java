package com.wisel.preschool.learning.allinonekids.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wisel.preschool.learning.allinonekids.data.MainActivityData.MainActivityObject;
import com.wisel.preschool.learning.allinonekids.R;
import com.wisel.preschool.learning.allinonekids.activity.TopicViewActivity;
import com.wisel.preschool.learning.allinonekids.adapters.viewHolder.MainActivityViewHolder;
import com.wisel.preschool.learning.allinonekids.utility.UtilityFile;

import java.util.List;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityViewHolder> {

    private Context context;

    private List<MainActivityObject> mainActivityObjectList ;

    public MainActivityAdapter(List<MainActivityObject> mainActivityObjectList, Context context) {

        this.mainActivityObjectList = mainActivityObjectList;
        this.context = context;

    }

    @Override
    public MainActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_recycler_view_holder, parent, false);
        return new MainActivityViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MainActivityViewHolder holder, int position) {

        Drawable drawable = UtilityFile.loadImageFromAssets(mainActivityObjectList.get(position).image);

        holder.tvTopic.setText(mainActivityObjectList.get(position).title);
        holder.ivTopic.setImageDrawable(drawable);
        holder.ivTopic.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.llParent.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        TextView t = v.findViewById(R.id.tvTopic);

                        Intent intent = new Intent(context, TopicViewActivity.class);
                        intent.putExtra("topic", t.getText().toString());
                        context.startActivity(intent);

                    }
                }
        );
    }

    @Override
    public int getItemCount() {

        return mainActivityObjectList.size();

    }
}
