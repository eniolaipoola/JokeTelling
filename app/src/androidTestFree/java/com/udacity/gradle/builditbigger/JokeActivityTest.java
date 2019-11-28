package com.udacity.gradle.builditbigger;

import android.text.TextUtils;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Copyright (c) 2019 Eniola Ipoola
 * All rights reserved
 * Created on 27-Nov-2019
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class JokeActivityTest {

    @Rule
    public ActivityTestRule<JokeActivity> activityTestRule =
            new ActivityTestRule<>(JokeActivity.class);

    @Test
    public void assertJokeNotEmpty(){
        onView(withId(R.id.jokeDescriptionTextView));
    }

}