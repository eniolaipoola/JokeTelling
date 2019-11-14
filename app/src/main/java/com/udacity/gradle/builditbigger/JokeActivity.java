package com.udacity.gradle.builditbigger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.utils.APPConstant;

import java.util.ArrayList;

public class JokeActivity extends AppCompatActivity {
    ArrayList<String> jokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        //get all Jokes
        Intent intent = getIntent();
        if(intent != null){
           jokes = intent.getStringArrayListExtra("jokes");
            Log.d(APPConstant.DEBUG_TAG, "All joke array list has the following size "
                    + jokes.size());
        }

        //get the recyclerview
        RecyclerView recyclerView = findViewById(R.id.joke_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        RecyclerView.Adapter mAdapter = new JokeAdapter(jokes);
        recyclerView.setAdapter(mAdapter);
    }
}
