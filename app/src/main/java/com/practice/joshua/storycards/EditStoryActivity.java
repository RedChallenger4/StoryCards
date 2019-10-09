package com.practice.joshua.storycards;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class EditStoryActivity extends AppCompatActivity {
    private EditText editNameText;
    private EditText editDescriptionText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_story);


        editNameText = findViewById(R.id.editNameText);
        editDescriptionText = findViewById(R.id.editDescriptionText);
        ImageView imagePreview = findViewById(R.id.imagePreview);
        Button doneBtn = findViewById(R.id.doneBtn);

        editNameText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            Toast.makeText(EditStoryActivity.this, "Done typing...", Toast.LENGTH_SHORT).show();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });

        editDescriptionText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            Toast.makeText(EditStoryActivity.this, "Done typing...", Toast.LENGTH_SHORT).show();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });

        imagePreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditStoryActivity.this, "Change background.", Toast.LENGTH_SHORT).show();
            }
        });

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editNameText.getText().toString().trim().equalsIgnoreCase(""))
                    editNameText.setError("This field cannot be blank");
                else if(editDescriptionText.getText().toString().trim().equalsIgnoreCase(""))
                    editDescriptionText.setError("This field cannot be blank");
                else {
//                    Intent returnIntent = new Intent();
//                    returnIntent.putExtra("result",result);
//                    setResult(Activity.RESULT_OK,returnIntent);
//                    finish();

                    Toast.makeText(EditStoryActivity.this, "Done Button.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_readstory, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
