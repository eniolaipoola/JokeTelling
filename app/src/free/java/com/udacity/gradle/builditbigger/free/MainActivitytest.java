package com.udacity.gradle.builditbigger.free;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.udacity.gradle.builditbigger.JokeActivity;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.utils.APPConstant;
import java.util.ArrayList;

public class MainActivitytest extends AppCompatActivity {
    ArrayList<String> allJokes;
    Button getJokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getJokes = findViewById(R.id.getJokeButton);
        Log.d(APPConstant.DEBUG_TAG, "All joke array list has the following size in jokeactivity " + allJokes.size());
        getJokes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivitytest.this, JokeActivity.class);
                intent.putExtra("jokes", allJokes);
                startActivity(intent);
            }
        });
    }
}
