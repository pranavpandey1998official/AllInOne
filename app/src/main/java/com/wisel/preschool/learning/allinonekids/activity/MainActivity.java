package com.wisel.preschool.learning.allinonekids.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wisel.preschool.learning.allinonekids.data.MainActivityData.MainActivityData;
import com.wisel.preschool.learning.allinonekids.data.MainActivityData.MainActivityObject;
import com.wisel.preschool.learning.allinonekids.R;
import com.wisel.preschool.learning.allinonekids.adapters.MainActivityAdapter;
import com.wisel.preschool.learning.allinonekids.utility.Constants;
import com.wisel.preschool.learning.allinonekids.utility.UtilityFile;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTopic;

    private UtilityFile utilityFile;

    // XML Views
    // JAVA VIEWS
    // User Defined Files
    // Data Types
    // List, array, hashmap, hashset, DS

    private List<MainActivityObject> mainActivityObjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialDataSetup();

    }

    private void initialDataSetup() {

        utilityFile = new UtilityFile(this);

        mainActivityObjectList = new ArrayList<>();
        MainActivityData list = new MainActivityData();
        mainActivityObjectList = list.data;

        initialUISetup();

    }

    private void initialUISetup() {

        showRecycleView();

    }

    private void showRecycleView() {

        rvTopic = findViewById(R.id.rvTopic);
        rvTopic.setHasFixedSize(true);
        rvTopic.setLayoutManager(new GridLayoutManager(this, Constants.SPAN_COUNT_RECYCLER_MAIN_ACTIVITY));

        MainActivityAdapter mainActivityAdapter = new MainActivityAdapter(mainActivityObjectList, getApplication());
        rvTopic.setAdapter(mainActivityAdapter);

    }

}
