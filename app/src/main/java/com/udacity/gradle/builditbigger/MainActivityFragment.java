package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.eniola.jokelibrary.Joke;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.utils.APPConstant;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    ArrayList<String> allJokes;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Joke myJokeLibrary = new Joke();
        String tellJoke = myJokeLibrary.tellAFunnyJoke();
        TextView jokeTextView = root.findViewById(R.id.joke_text_view);
        jokeTextView.setText(tellJoke);
        Log.d(APPConstant.DEBUG_TAG, "The joke string is " + tellJoke);

        //check the array size of jokes
        allJokes = myJokeLibrary.getJokes();
        Log.d(APPConstant.DEBUG_TAG, "All joke arraylist has the following size " + allJokes.size());

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        Log.d(APPConstant.DEBUG_TAG, "Did it get here?" + adRequest);
        mAdView.loadAd(adRequest);
        return root;
    }
}
