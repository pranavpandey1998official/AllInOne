package com.wisel.preschool.learning.allinonekids.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wisel.preschool.learning.allinonekids.adapters.navBarAdapter.NavBarAdapterImage;
import com.wisel.preschool.learning.allinonekids.adapters.topicViewPagerAdapter.ImageFragmentAdapter;
import com.wisel.preschool.learning.allinonekids.data.ColorData.ColorData;
import com.wisel.preschool.learning.allinonekids.data.ColorData.ColorObject;
import com.wisel.preschool.learning.allinonekids.R;
import com.wisel.preschool.learning.allinonekids.adapters.navBarAdapter.navBarAdapterColor;
import com.wisel.preschool.learning.allinonekids.adapters.topicViewPagerAdapter.ColorFragmentAdapter;
import com.wisel.preschool.learning.allinonekids.data.ImageData.ImageData;
import com.wisel.preschool.learning.allinonekids.data.ImageData.ImageObject;
import com.wisel.preschool.learning.allinonekids.utility.UtilityFile;

import org.json.JSONException;

import java.util.ArrayList;

public class TopicViewActivity extends AppCompatActivity {

    private ImageButton ibNext;
    private ImageButton ibPrevious;
    private ImageButton ibHome;
    private ImageButton ibPlaySound;
    private RecyclerView rvLesson;
    private TextView tvTitle;
    private ViewPager vpLesson;

    private String sTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_view);
        try {
            initialDataSetup();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    void initialDataSetup() throws JSONException {

        Bundle bundle = getIntent().getExtras();

        sTitle = bundle.getString("topic");

        if (sTitle.equals("Colors")) {

            ArrayList<ColorObject> data;
            data = new ColorData().data;
            initialUISetupForColor(data);

        } else {

            ArrayList<ImageObject> data = new ImageData(sTitle).data;
            initialUISetup(data);

        }

    }

    void initialUISetup(ArrayList<ImageObject> data) {

        titleSetup();

        vpLesson = findViewById(R.id.vpLesson);
        setOnClickListener();

        rvLesson = findViewById(R.id.rvLesson);
        rvLesson.setHasFixedSize(true);
        rvLesson.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvLesson.setAdapter(new NavBarAdapterImage(data, vpLesson, getApplication()));


        vpLesson.setAdapter(new ImageFragmentAdapter(getSupportFragmentManager(), data));

    }

    void initialUISetupForColor(ArrayList<ColorObject> data) {

        rvLesson = findViewById(R.id.rvLesson);
        rvLesson.setHasFixedSize(true);
        rvLesson.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        vpLesson = findViewById(R.id.vpLesson);
        rvLesson.setAdapter(new navBarAdapterColor(data, vpLesson, getApplication()));

        titleSetup();

        setOnClickListener();
        ColorFragmentAdapter adapter;
        adapter = new ColorFragmentAdapter(getSupportFragmentManager(), data);
        vpLesson.setAdapter(adapter);

    }

    private void setOnClickListener() {

        ibNext = findViewById(R.id.ibNext);
        ibPrevious = findViewById(R.id.ibPrevious);
        ibHome = findViewById(R.id.ibHome);
        ibPlaySound = findViewById(R.id.ibPlaySound);

        ibNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpLesson.setCurrentItem(getItem(+1), true);
            }
        });

        ibPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpLesson.setCurrentItem(getItem(-1), true);
            }
        });

        ibHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    void titleSetup() {

        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setTypeface(UtilityFile.getTfCapsItalic());
        tvTitle.setText(sTitle);

    }

    private int getItem(int i) {

        return vpLesson.getCurrentItem() + i;

    }

}
