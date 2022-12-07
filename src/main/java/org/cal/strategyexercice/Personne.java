package org.cal.strategyexercice;

/**
 * 
 * Remanier le code ci-dessous de façon à ce qu'il utilise le 'State/Strategy Pattern'
 * Vous devrez nommer chacun des remaniements que vous faites ainsi que de faire un commit à chaque remaniement.
 *
 */
public class Personne {

    private MoodType humeur;

    public Personne(MoodType humeur) {
        this.humeur = humeur;
    }

    public String whatYouNeed() {
        return humeur.whatYouNeed() ;
    }
    @Override
    public String toString() {
        return "Personne [humeur=" + humeur.moodString() + "]";
    }

    public void printHumeur() {
        System.out.println(humeur.moodString());
    }

}
