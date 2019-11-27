package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.utils.APPConstant;
import java.io.IOException;

/**
 * Copyright (c) 2019 Eniola Ipoola
 * All rights reserved
 * Created on 21-Nov-2019
 */

public class GoogleCloudEndpointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApi = null;
    private Context mContext;
    private JokeListener jokeListener;

    GoogleCloudEndpointAsyncTask(JokeListener jokeListener){
        this.jokeListener = jokeListener;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {
        if(myApi == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            myApi = builder.build();

        }

        try {
            return myApi.fetchJokeString().execute().getJokeString();
        } catch (IOException ioException){
            return ioException.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d(APPConstant.DEBUG_TAG, "Result from the action is " + result);
        jokeListener.OnJokeRetrieved(result);
    }
}
