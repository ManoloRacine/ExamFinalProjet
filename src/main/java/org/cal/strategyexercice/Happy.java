package org.cal.strategyexercice;

public class Happy implements MoodType{
    @Override
    public String whatYouNeed() {
        return "J'ai un MacBook Pro, j'ai tout ce qu'il me faut  pour être une personne heureuse!";
    }

    public String moodString() {
        return "Heureuse" ;
    }
}
