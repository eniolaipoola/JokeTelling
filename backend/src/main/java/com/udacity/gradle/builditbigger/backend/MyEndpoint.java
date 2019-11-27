package com.udacity.gradle.builditbigger.backend;

import com.eniola.jokelibrary.Joke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import java.util.ArrayList;
import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);
        return response;
    }


    /** A simple endpoint that creates sends an array of jokes*/
    @ApiMethod(name = "fetchAllJokes")
    public FetchJokes fetchAllJokes(){
        FetchJokes allJokes = new FetchJokes();
        allJokes.setAllJokes(new Joke().getJokes());
        return  allJokes;
    }

    /** A simple endpoint that sends a string of joke*/
    @ApiMethod(name = "fetchJokeString")
    public FetchJokes fetchJokeString(){
        FetchJokes jokeString = new FetchJokes();
        jokeString.setJokeString(new Joke().tellAFunnyJoke());
        return  jokeString;
    }
}
