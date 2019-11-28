package com.udacity.gradle.builditbigger;

import android.text.TextUtils;

import androidx.test.runner.AndroidJUnit4;

import com.eniola.jokelibrary.Joke;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Copyright (c) 2019 Eniola Ipoola
 * All rights reserved
 * Created on 27-Nov-2019
 */
@RunWith(AndroidJUnit4.class)
public class GoogleCloudEndpointAsyncTaskTest {

    private String jokeItem = null;
    JokeListener jokeListener;
    GoogleCloudEndpointAsyncTask asyncTask;

    @Test
    public void testGoogleCloudEndpointAsyncTask(){
        jokeListener = new JokeListener() {
            @Override
            public void OnJokeRetrieved(String jokes) {
                jokeItem = jokes;
            }
        };

        asyncTask = new GoogleCloudEndpointAsyncTask(jokeListener);

        try {

            asyncTask.execute().get();
            assertNotNull(asyncTask.getAsyncTaskResult());

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}