package org.cal.examen;


public class Player {
    private int places = 0;

    private int purses = 0;

    private int playerNumber ;

    private boolean inPenaltyBox = false ;

    public void addToPurse(int i) {
        purses = purses + i ;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getPurses() {
        return purses;
    }

    public void setPurses(int purses) {
        this.purses = purses;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }

    private String playerName ;

    public Player(String playerName, int playerNumber) {
        this.playerName = playerName ;
        this.playerNumber = playerNumber ;
    }
}
