package com.udacity.gradle.builditbigger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.utils.APPConstant;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JokeActivity extends AppCompatActivity implements JokeListener {
    ArrayList<String> jokeArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        /** Allow jokes to be fetched from GCE */
        new GoogleCloudEndpointAsyncTask(JokeActivity.this).execute();
    }

    @Override
    public void OnJokeRetrieved(String jokes) {

        Log.d(APPConstant.DEBUG_TAG, "The array of jokes converted to string is" + jokes);
        List<String> jokeItems = Arrays.asList(jokes.split(","));
        jokeArrayList = new ArrayList<String>();
        for(int i = 0; i < jokeItems.size(); i++){
            jokeArrayList.add(jokeItems.get(i));
        }

        //get the recyclerview
        RecyclerView recyclerView = findViewById(R.id.joke_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        RecyclerView.Adapter mAdapter = new JokeAdapter(jokeArrayList);
        recyclerView.setAdapter(mAdapter);
    }
}
