package org.cal.strategyexercice;

public class Sad implements MoodType{
    @Override
    public String whatYouNeed() {
        return "Je fais parti des gens qui n'auront jamais de MacBook Pro";
    }

    @Override
    public String moodString() {
        return "Triste";
    }


}
