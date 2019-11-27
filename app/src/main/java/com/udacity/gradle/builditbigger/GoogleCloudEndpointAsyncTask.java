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

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {
        if(myApi == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.137.193:8080/a_h/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            myApi = builder.build();

        }

        mContext = pairs[0].first;
        String name = pairs[0].second;

        try {
            return  myApi.sayHi(name).execute().getData();
        } catch (IOException ioException){
            return ioException.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String result) {
        Log.d(APPConstant.DEBUG_TAG, "Result from the action is " + result);
        Toast.makeText(mContext, "Hello, this is working i guess" , Toast.LENGTH_LONG).show();
        super.onPostExecute(result);
    }
}
