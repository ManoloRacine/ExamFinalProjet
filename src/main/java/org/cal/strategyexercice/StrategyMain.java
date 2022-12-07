package org.cal.strategyexercice;

import java.util.ArrayList;
import java.util.List;

public class StrategyMain {
    
    public static void main(String[] args) {

        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne(new Happy()));
        personnes.add(new Personne(new Unhappy()));
        personnes.add(new Personne(new Sad()));

        personnes.forEach(Personne::printHumeur);
        
        for (Personne personne : personnes) {
            System.out.println(personne.whatYouNeed());
        }
    }
}
