package org.cal.examen;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<>();
    PopQuestions popQuestions = new PopQuestions();
    ScienceQuestions scienceQuestions = new ScienceQuestions();
    SportsQuestions sportsQuestions = new SportsQuestions();
    RockQuestions rockQuestions = new RockQuestions();

    DisplayHandlerSOUT displayHandlerSOUT = new DisplayHandlerSOUT() ;

    int currentPlayerNumber = 0;
    Player currentPlayer ;
    boolean isGettingOutOfPenaltyBox;

    public  Game(){
        for (int i = 0; i < 50; i++) {
            createQuestions(i);
        }
    }

    private void createQuestions(int i) {
        popQuestions.createQuestions(i);
        scienceQuestions.createQuestions(i);
        sportsQuestions.createQuestions(i);
        rockQuestions.createQuestions(i);
    }

    public void addPlayer(String playerName) {

        players.add(new Player(playerName, players.size())) ;

        displayHandlerSOUT.displayAddedPlayer(playerName, this);
    }

    public void roll(int roll) {
        displayHandlerSOUT.displayPlayerRoll(roll, this);

        currentPlayer = players.get(currentPlayerNumber) ;

        if (currentPlayer.isInPenaltyBox()) {
            rollInPenaltyBox(roll);
        } else {
            rollNotInPenaltyBox(roll);
        }

    }
    private void rollInPenaltyBox(int roll) {
        if (roll % 2 != 0) {
            rollEven(roll);
        } else {
            rollOdd();
        }
    }

    private void rollEven(int roll) {
        getOutOfPenaltyBox();

        addRoll(roll);

        displayHandlerSOUT.displayBeforeNextQuestion(this);
        askQuestion();
    }

    private void rollOdd() {
        dontGetOutOfPenaltyBox();
    }

    private void getOutOfPenaltyBox() {
        currentPlayer.setInPenaltyBox(true);

        displayHandlerSOUT.displayGettingOutOfPenaltyBox(this);
    }
    private void dontGetOutOfPenaltyBox() {

        displayHandlerSOUT.displayNotGettingOutOfPenaltyBox(this);
        isGettingOutOfPenaltyBox = false;
    }
    private void addRoll(int roll) {
        currentPlayer.setPlaces(currentPlayer.getPlaces() + roll);

        if (currentPlayer.getPlaces() > 11) {
            currentPlayer.setPlaces(currentPlayer.getPlaces() - 12);
        }
    }

    private void rollNotInPenaltyBox(int roll) {
        addRoll(roll);

        displayHandlerSOUT.displayBeforeNextQuestion(this);
        askQuestion();
    }
    private void askQuestion() {
        if (currentCategory() == QuestionTypes.POP)
            displayHandlerSOUT.displayQuestion(popQuestions.getQuestions().removeFirst());
        if (currentCategory() == QuestionTypes.SCIENCES)
            displayHandlerSOUT.displayQuestion(scienceQuestions.getQuestions().removeFirst());
        if (currentCategory() == QuestionTypes.SPORTS)
            displayHandlerSOUT.displayQuestion(sportsQuestions.getQuestions().removeFirst());
        if (currentCategory() == QuestionTypes.ROCK)
            displayHandlerSOUT.displayQuestion(rockQuestions.getQuestions().removeFirst());
    }

    protected QuestionTypes currentCategory() {
        return switch (currentPlayer.getPlaces()) {
            case 0, 4, 8 -> QuestionTypes.POP;
            case 1, 5, 9 -> QuestionTypes.SCIENCES;
            case 2, 6, 10 -> QuestionTypes.SPORTS;
            default -> QuestionTypes.ROCK;
        };
    }

    public boolean wasCorrectlyAnswered() {
        if (currentPlayer.isInPenaltyBox()){
            return correctlyAnsweredPenaltyBox();
        } else {
            return correctlyAnsweredNotPenaltyBox();
        }
    }

    private boolean correctlyAnsweredPenaltyBox() {
        if (isGettingOutOfPenaltyBox) {
            return correctlyAnsweredNotPenaltyBox();
        }
        else {
            goToNextPlayer();
            return true;
        }
    }

    private boolean correctlyAnsweredNotPenaltyBox() {
        currentPlayer.addToPurse(1);

        displayHandlerSOUT.displayCorrectAnswer(this);

        goToNextPlayer();

        return didPlayerWin();
    }

    private void goToNextPlayer() {
        currentPlayerNumber++;
        if (currentPlayerNumber == players.size()) currentPlayerNumber = 0;
    }

    public boolean wrongAnswer(){
        displayHandlerSOUT.displayIncorrectAnswer(this);

        currentPlayer.setInPenaltyBox(true);

        goToNextPlayer();
        return true;
    }


    private boolean didPlayerWin() {
        return !(currentPlayer.getPurses() == 6);
    }
}
