package com.udacity.gradle.builditbigger.backend;

import java.util.ArrayList;

/**
 * Copyright (c) 2019 Eniola Ipoola
 * All rights reserved
 * Created on 27-Nov-2019
 */
public class FetchJokes {

    private ArrayList<String> allJokes;
    private String jokeString;

    public ArrayList<String> getAllJokes() {
        return allJokes;
    }

    public void setAllJokes(ArrayList<String> allJokes) {
        this.allJokes = allJokes;
    }

    public String getJokeString() {
        return jokeString;
    }

    public void setJokeString(String jokeString) {
        this.jokeString = jokeString;
    }
}
