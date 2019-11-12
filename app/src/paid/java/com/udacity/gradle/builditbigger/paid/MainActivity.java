package com.udacity.gradle.builditbigger.paid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.utils.APPConstant;

public class PaidMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.d(APPConstant.DEBUG_TAG, "Did it come to the paid activity at all?");
    }
}
