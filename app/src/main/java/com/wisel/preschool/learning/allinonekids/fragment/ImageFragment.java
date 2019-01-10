package com.wisel.preschool.learning.allinonekids.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wisel.preschool.learning.allinonekids.R;
import com.wisel.preschool.learning.allinonekids.utility.UtilityFile;


public class ImageFragment extends Fragment {

    public ImageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String sTitle = getArguments().getString("titleText");
        Drawable drawable = UtilityFile.loadImageFromAssets(getArguments().getString("image"));


        View view = inflater.inflate(R.layout.fragment_image, container, false);

        TextView tvImageFragment = view.findViewById(R.id.tvImageFragment);
        ImageView ivImageFragment = view.findViewById(R.id.ivImageFragment);
        ivImageFragment.setScaleType(ImageView.ScaleType.FIT_XY);

        tvImageFragment.setText(sTitle);
        ivImageFragment.setImageDrawable(drawable);

        return view;

    }

}
