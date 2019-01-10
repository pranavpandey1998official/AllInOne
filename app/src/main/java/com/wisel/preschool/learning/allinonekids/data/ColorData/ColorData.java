package com.wisel.preschool.learning.allinonekids.data.ColorData;

import com.wisel.preschool.learning.allinonekids.utility.UtilityFile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ColorData {

    public ArrayList<ColorObject> data;

    public ColorData() {

        super();
        data = new ArrayList<>();

        try {

            String temp = UtilityFile.loadJSONFromAsset();
            JSONObject obj = new JSONObject(temp);
            JSONArray arr = obj.getJSONArray("DATA");
            JSONObject jo_inside = null;

            for (int i = 0; i < arr.length(); i++) {

                jo_inside = arr.getJSONObject(i);

                if (jo_inside.getString("topic").equals("Colors")) break;


            }
            arr = jo_inside.getJSONArray("data");
            for (int i = 0; i < arr.length(); i++) {

                jo_inside = arr.getJSONObject(i);
                String sTitle = jo_inside.getString("title");
                String sColor = jo_inside.getString("example");
                String sAudio = jo_inside.getString("audio");
                data.add(new ColorObject(sTitle, sColor, sAudio));

            }

        } catch (JSONException e) {

            e.printStackTrace();

        }

    }
}
