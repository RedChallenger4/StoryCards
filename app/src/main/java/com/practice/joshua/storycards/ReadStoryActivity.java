package com.practice.joshua.storycards;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class ReadStoryActivity extends AppCompatActivity {

    private final List<Story> stories = DataProvider.storyList;
    private final int numPages = stories.size();

    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_story);

        mPager = findViewById(R.id.main_pager);
        PagerAdapter pagerAdapter =
                new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);

        FloatingActionButton addStoryFabBtn = findViewById(R.id.addstory_fabbtn);
        addStoryFabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReadStoryActivity.this, "Create a new story...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) super.onBackPressed();
        else mPager.setCurrentItem(mPager.getCurrentItem() - 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_readstory, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(this, "Edit Action", Toast.LENGTH_SHORT).show();
                Intent editStoryIntent = new Intent(this, EditStoryActivity.class);
                startActivity(editStoryIntent);
                break;
            case R.id.action_share:
                Toast.makeText(this, "Share Action", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
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
