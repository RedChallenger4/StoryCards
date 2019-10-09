package com.practice.joshua.storycards;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
//    private final int numPages = stories.size();

    private ViewPager mPager;
    private PagerAdapter mAdapter;

    private MenuItem delete_item, edit_item, share_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_story);

        mPager = findViewById(R.id.main_pager);
        //PagerAdapter pagerAdapter
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);

        FloatingActionButton addStoryFabBtn = findViewById(R.id.addstory_fabbtn);
        addStoryFabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createStoryIntent = new Intent(ReadStoryActivity.this, EditStoryActivity.class);
//                startActivity(editStoryIntent);
                startActivityForResult(createStoryIntent, 2000);
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
            case R.id.action_delete:
                removeCurrentItem();
                // TODO: delete story first if it works
                // may have to use below resource
                // https://stackoverflow.com/questions/28108940/dynamically-remove-an-item-from-a-viewpager-with-fragmentstatepageradapter
                break;

            case R.id.action_edit:
                Toast.makeText(this, "Edit Action", Toast.LENGTH_SHORT).show();
                Intent editStoryIntent = new Intent(ReadStoryActivity.this, EditStoryActivity.class);
//                startActivity(editStoryIntent);
                startActivityForResult(editStoryIntent, 2000);
                break;
            case R.id.action_share:
                Toast.makeText(this, "Share Action", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        delete_item = menu.findItem(R.id.action_delete);
        edit_item = menu.findItem(R.id.action_edit);
        share_item = menu.findItem(R.id.action_share);
//        if (stories.size() > 3) {
//            delete_item.setEnabled(true);
//            delete_item.getIcon().setAlpha(130);
//        } else {
//            // disabled
//            delete_item.setEnabled(false);
//            delete_item.getIcon().setAlpha(255);
//        }
        return super.onPrepareOptionsMenu(menu);
    }

    private void removeCurrentItem() {
        if (stories.size() > 0) {
            // TODO: Add 'delete item' to DataProvider
            delete_item.setEnabled(true);
            edit_item.setEnabled(true);
            share_item.setEnabled(true);

            delete_item.getIcon().setAlpha(255);
            edit_item.getIcon().setAlpha(255);
            share_item.getIcon().setAlpha(255);

            int position = mPager.getCurrentItem();
            stories.remove(position);
            mAdapter.notifyDataSetChanged();

        } else if (stories.size() == 1) {
            delete_item.setEnabled(false);
            edit_item.setEnabled(false);
            share_item.setEnabled(false);

            delete_item.getIcon().setAlpha(150);
            edit_item.getIcon().setAlpha(150);
            share_item.getIcon().setAlpha(150);
        }
        else {
            // disabled
            Toast.makeText(this, "Cannot remove... Size is : " + stories.size(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if( requestCode == 1000 && resultCode == Activity.RESULT_OK ) {
            // create story
        } else if( requestCode == 2000 && resultCode == Activity.RESULT_OK ) {
            // edit story
        } else if ( requestCode == 3000 && resultCode == Activity.RESULT_OK ) {
            // delete story
        } else {
            // cancel action
        }
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

        @Override
        public int getItemPosition(@NonNull Object object) {
            //return super.getItemPosition(object);
            return PagerAdapter.POSITION_NONE;
        }


        /*
            Determine how many pages to create
         */
        @Override
        public int getCount() {
//            return numPages;
            return stories.size();
        }
    }
}
