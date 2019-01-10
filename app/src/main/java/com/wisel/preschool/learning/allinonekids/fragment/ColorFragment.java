package com.wisel.preschool.learning.allinonekids.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wisel.preschool.learning.allinonekids.R;
import com.wisel.preschool.learning.allinonekids.utility.UtilityFile;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        String title=getArguments().getString("title");
        String color=getArguments().getString("color");

        View view = inflater.inflate(R.layout.fragment_color, container, false);
        TextView textView =view.findViewById(R.id.tvColor);
        textView.setTypeface(UtilityFile.getTfCursiveRegular());

        ImageView imageView=view.findViewById(R.id.ivColor);
        textView.setText(title);
        int colors=UtilityFile.getColorByName(color);
        imageView.setImageResource(colors);

        return view;

    }

}
