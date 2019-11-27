package com.udacity.gradle.builditbigger;

import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Copyright (c) 2019 Eniola Ipoola
 * All rights reserved
 * Created on 27-Nov-2019
 */
@RunWith(AndroidJUnit4.class)
public class EchoAndroidTest {

    @Test
    public void verifyEchoResponse(){
        assertEquals("hello", Echo.echo("hello"));
    }

    @Test
    public void testVerifyLoggingEchoResponse(){
        assertEquals("hello", Echo.echo("hello", true));
    }
    

}