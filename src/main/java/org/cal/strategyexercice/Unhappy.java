package org.cal.strategyexercice;

public class Unhappy implements MoodType{
    @Override
    public String whatYouNeed() {
        return "J'ai besoin d'un MacBook Pro pour être une personne heureuse!";
    }

    @Override
    public String moodString() {
        return "Malheureuse";
    }
}
