package com.wisel.preschool.learning.allinonekids.adapters.topicViewPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wisel.preschool.learning.allinonekids.data.ImageData.ImageObject;
import com.wisel.preschool.learning.allinonekids.fragment.ImageFragment;

import java.util.ArrayList;
import java.util.List;

public class ImageFragmentAdapter extends FragmentPagerAdapter {

    private List<ImageObject> imageObjectList;

    public ImageFragmentAdapter(FragmentManager fm,ArrayList<ImageObject> imageObjectList) {

        super(fm);
        this.imageObjectList=imageObjectList;
    }

    @Override
    public Fragment getItem(int i) {

        ImageFragment imageFragment= new ImageFragment();

        Bundle bundle = new Bundle();
        bundle.putString("titleText", imageObjectList.get(i).title);
        bundle.putString("image",imageObjectList.get(i).image);
        imageFragment.setArguments(bundle);

        return imageFragment;

    }

    @Override
    public int getCount() {

        return imageObjectList.size();
    }
}
