package com.practice.joshua.storycards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: https://stackoverflow.com/questions/14782901/android-how-to-handle-button-click
        // Implement clicking functionality
        Button storyBtn = findViewById(R.id.storyBtn);
        storyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent storyIntent = new Intent(v.getContext(), ReadStoryActivity.class);
                startActivity(storyIntent);
            }
        });
    }
}
