package com.wisel.preschool.learning.allinonekids.adapters.topicViewPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wisel.preschool.learning.allinonekids.data.ColorData.ColorObject;
import com.wisel.preschool.learning.allinonekids.fragment.ColorFragment;

import java.util.ArrayList;
import java.util.List;

public class ColorFragmentAdapter extends FragmentPagerAdapter {

    private List<ColorObject> colorObjectList;

    public ColorFragmentAdapter(FragmentManager fm, ArrayList<ColorObject> data) {

        super(fm);
        this.colorObjectList = data;

    }

    @Override
    public Fragment getItem(int i) {

        ColorFragment colorFragment = new ColorFragment();

        Bundle bundle = new Bundle();
        bundle.putString("title", colorObjectList.get(i).title);
        bundle.putString("color", colorObjectList.get(i).color);

        colorFragment.setArguments(bundle);
        return colorFragment;

    }

    @Override
    public int getCount() {

        return colorObjectList.size();

    }
}
