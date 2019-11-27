package com.eniola.jokelibrary;

import java.util.ArrayList;

public class Joke {
    public String tellAFunnyJoke() {
        String jokesInString = "There’s no menu You get what you deserve, Sleep is a weak substitute for coffee, What do you get a hunter for his birthday? A birthday pheasant";
        return jokesInString;
    }

    public ArrayList<String> getJokes(){
        ArrayList<String> allJokes = new ArrayList<String>();
        allJokes.add("There’s no menu: You get what you deserve." );
        allJokes.add("Whoever said that the definition of insanity is doing the same thing over " +
                "and over again and expecting different results has obviously never " +
                "had to reboot a computer.");
        allJokes.add("If you sit down to enjoy a hot cup of coffee, then your boss will ask you to " +
                "do something that will last until the coffee is cold.");
        allJokes.add("Sleep is a weak substitute for coffee.");
        allJokes.add("Did you hear about the monkeys who shared an Amazon account? They were Prime mates.");
        allJokes.add("What do you get a hunter for his birthday?\n" +
                "\n" + "A birthday pheasant.");
        allJokes.add("I tell people I’m on a low-carb diet, but in reality, " +
                "I just eat pasta while lying on the floor.");

        return allJokes;
    }
}
