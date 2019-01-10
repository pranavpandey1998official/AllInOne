package com.wisel.preschool.learning.allinonekids.data.ImageData;

import com.wisel.preschool.learning.allinonekids.utility.UtilityFile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ImageData {

    public String sTitle;
    public ArrayList<ImageObject> data;

    public ImageData(String sTitle) throws JSONException {

        super();

        this.data = new ArrayList<>();
        this.sTitle = sTitle;

        String temp = UtilityFile.loadJSONFromAsset();
        JSONObject obj = new JSONObject(temp);
        JSONArray arr = obj.getJSONArray("DATA");
        JSONObject jo_inside = null;

        for (int i = 0; i < arr.length(); i++) {

            jo_inside = arr.getJSONObject(i);
            if (jo_inside.getString("topic").equals(sTitle)) break;

        }

        arr = jo_inside.getJSONArray("data");

        for (int i = 0; i < arr.length(); i++) {

            jo_inside = arr.getJSONObject(i);
            String string = jo_inside.getString("example");
            String sImage = jo_inside.getString("image");
            String sAudio = jo_inside.getString("audio");
            data.add(new ImageObject(string, sImage, sAudio));

        }
    }

}
