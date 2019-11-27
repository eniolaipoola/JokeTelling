package com.udacity.gradle.builditbigger;

import android.util.Log;

/**
 * Copyright (c) 2019 Eniola Ipoola
 * All rights reserved
 * Created on 27-Nov-2019
 */
public class Echo {

    static <T> T echo(T o){
        return echo(o, false);
    }

    static <T> T echo(T o, boolean log){
        if(log) Log.i(Echo.class.getName(), o.toString());
        return o;
    }
}
