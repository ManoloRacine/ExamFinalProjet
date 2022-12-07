package org.cal.examen;

public interface DisplayHandlerInterface {
    void displayIncorrectAnswer(Game game);

    void displayCorrectAnswer(Game game);

    void displayBeforeNextQuestion(Game game);

    void displayQuestion(String question);

    void displayNotGettingOutOfPenaltyBox(Game game);

    void displayGettingOutOfPenaltyBox(Game game);

    void displayPlayerRoll(int roll, Game game);

    void displayAddedPlayer(String playerName, Game game);
}
