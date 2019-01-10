package com.wisel.preschool.learning.allinonekids.utility;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Patterns;

import com.wisel.preschool.learning.allinonekids.R;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class UtilityFile {

    private static final String TAG = UtilityFile.class.getSimpleName();

    private static Context context;

    private static Typeface tfCapsItalic;
    private static Typeface tfCapsRegular;
    private static Typeface tfCursiveRegular;
    private static Typeface tfCursiveDashed;

    public UtilityFile(Context context) {
        this.context = context;

        setFont();

    }

    private void setFont() {

        tfCapsItalic = Typeface.createFromAsset(context.getAssets(), Constants.FONT_TYPE_CAPS_ITALIC);
        tfCapsRegular = Typeface.createFromAsset(context.getAssets(), Constants.FONT_TYPE_CAPS_REGULAR);
        tfCursiveRegular = Typeface.createFromAsset(context.getAssets(), Constants.FONT_TYPE_CURSIVE_REGULAR);
        tfCursiveDashed = Typeface.createFromAsset(context.getAssets(), Constants.FONT_TYPE_CURSIVE_DASHED);

    }

    public static Typeface getTfCapsItalic() {
        return tfCapsItalic;
    }

    public static Typeface getTfCapsRegular() {
        return tfCapsRegular;
    }

    public static Typeface getTfCursiveRegular() {
        return tfCursiveRegular;
    }

    public static Typeface getTfCursiveDashed() {
        return tfCursiveDashed;
    }


    public static String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is =context.getAssets().open(Constants.DATA_FILE_PATH);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    public static Drawable loadImageFromAssets(String img) {
        Drawable d = null;
        try {
            // get input stream
            InputStream ims = context.getAssets().open(img);
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
        } catch (IOException ex) {

        }
        return d;
    }
    public static int getColorByName( String name ) {
        int colorId = 0;

        try {
            Class res = R.color.class;
            Field field = res.getField( name );
            colorId = field.getInt(null);
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return colorId;
    }
}
