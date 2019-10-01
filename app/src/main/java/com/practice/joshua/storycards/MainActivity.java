package com.practice.joshua.storycards;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String FRAGMENT_TAG = "fragment_tag";

    BlankFragment fragment;
    private boolean mUseFragment;
    private TextView mOut;
    private ViewGroup fragmentContainer;

    private FloatingActionButton mStoryFabBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("START : ", "Start");
        ScreenUtility su = new ScreenUtility(this);
        fragmentContainer = findViewById(R.id.fragment_container);

        Float devHt = su.getDpHeight();
        Float devWth = su.getDpWidth();

        // help determine if fragment is needed depending on device orientation
        if (devWth > devHt) mUseFragment = true;
        else mUseFragment = false;

        Toast.makeText(this,
                String.format("Width: %s, Height: %s", su.getDpWidth(), su.getDpHeight()),
                Toast.LENGTH_SHORT).show();

        mStoryFabBtn = findViewById(R.id.storyFabBtn);
        assert mStoryFabBtn != null;
        mStoryFabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDetailFragment();
            }
        });
    }

    private void viewDetailFragment() {
        if (mUseFragment) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            // TODO: add a fragment in runtime when you change screen orientation
            //  https://www.linkedin.com/learning/building-flexible-android-apps-with-the-fragments-api/choose-layout-at-runtime?u=42740356

            BlankFragment fragment = new BlankFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment, FRAGMENT_TAG)
                    .commit();
        } else {
            Intent intent = new Intent(this, StoryActivity.class);
            startActivity(intent);
        }
    }

    public void generateFragmentBtnClick(View view) {
        fragment = new BlankFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)  // allows you to remove fragment with back button
                .add(R.id.fragment_container, fragment, FRAGMENT_TAG)
                .commit();

//        ScreenUtility su = new ScreenUtility(this);
//        mOut.setText();
    }

    public void removeFragmentBtnClick(View view) {
        Fragment fragment = getSupportFragmentManager()
                 .findFragmentByTag(FRAGMENT_TAG); // so it won't lose reference in orientation changes
                //.findFragmentById(R.id.blankFragment); // so it won't lose reference in orientation changes

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
        }
    }

    @Override
    protected void onStart() {
        Log.i("START : ", "Start");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i("RESUME : ", "Resume");
        super.onResume();
    }

    @Override
    protected void onPause() {

        Log.i("PAUSE: ", "Pause");
        super.onPause();
    }

    @Override
    protected void onStop() {

        Log.i("STOP: ", "Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {


        Log.i("DESTROY: ", "Destroy");
        super.onDestroy();
    }
}
