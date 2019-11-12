package com.udacity.gradle.builditbigger.paid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.utils.APPConstant;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> allJokes;
    Button jokeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(APPConstant.DEBUG_TAG, "Did it come to the paid activity at all?");

        jokeButton = findViewById(R.id.jokeButton);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(APPConstant.DEBUG_TAG, "Did it come to onClick at all?");
                Intent jokeIntent = new Intent(MainActivity.this, JokeListActivity.class);
                startActivity(jokeIntent);
            }
        });

        //get arraylist of jokes and display in recyclerview
        //Joke jokeLibrary = new Joke();
        //allJokes = jokeLibrary.getJokes();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
