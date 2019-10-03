package com.practice.joshua.storycards;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final List<Story> stories = DataProvider.storyList;
    private final int numPages = stories.size();

    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = findViewById(R.id.main_pager);
        PagerAdapter pagerAdapter =
                new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) super.onBackPressed();
        else mPager.setCurrentItem(mPager.getCurrentItem() - 1);
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /*
            Get a fragment and display it
         */
        @Override
        public Fragment getItem(int pos) {
            return ItemFragment.newInstance(stories.get(pos));
        }

        /*
            Determine how many pages to create
         */
        @Override
        public int getCount() {
            return numPages;
        }
    }
}
