package com.wisel.preschool.learning.allinonekids.data.MainActivityData;

import com.wisel.preschool.learning.allinonekids.utility.UtilityFile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivityData {

    public List<MainActivityObject> data;


    public MainActivityData() {

        super();
        data = new ArrayList<>();

        try {

            String temp = UtilityFile.loadJSONFromAsset();
            JSONObject obj = new JSONObject(temp);
            JSONArray arr = obj.getJSONArray("DATA");

            for (int i = 0; i < arr.length(); i++) {
                JSONObject jo_inside = arr.getJSONObject(i);
                String topic = jo_inside.getString("topic");
                String img = jo_inside.getString("image");
                data.add(new MainActivityObject(topic, img));
            }

        } catch (JSONException e) {

            e.printStackTrace();

        }

    }

}
