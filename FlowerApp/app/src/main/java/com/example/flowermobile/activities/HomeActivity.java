package com.example.flowermobile.activities;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.flowermobile.R;
import com.example.flowermobile.fragemnts.CategoryFragment;
import com.example.flowermobile.fragemnts.HomeFragment;
import com.example.flowermobile.fragemnts.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

import eu.long1.spacetablayout.SpaceTabLayout;

public class HomeActivity extends AppCompatActivity {
    private SpaceTabLayout mSpaceTabLayout;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initialView(savedInstanceState);
    }
    private void initialView(Bundle savedInstanceState){
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(HomeFragment.newInstance());
        fragmentList.add(CategoryFragment.newInstance());
        fragmentList.add(ProfileFragment.newInstance());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPagerHome);
        viewPager.setOffscreenPageLimit(2);
        mSpaceTabLayout = (SpaceTabLayout) findViewById(R.id.spaceTabLayout);
        mSpaceTabLayout.initialize(viewPager,getSupportFragmentManager(),
                fragmentList, savedInstanceState);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mSpaceTabLayout.saveState(outState);
    }
}
