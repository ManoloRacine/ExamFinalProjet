package org.cal.examen;

public class DisplayHandlerSOUT implements DisplayHandlerInterface {
    @Override
    public void displayIncorrectAnswer(Game game) {
        System.out.println("Question was incorrectly answered");
        System.out.println(game.currentPlayer.getPlayerName() + " was sent to the penalty box");
    }

    @Override
    public void displayCorrectAnswer(Game game) {
        System.out.println("Answer was correct!!!!");

        System.out.println(game.currentPlayer.getPlayerName()
                + " now has "
                + game.currentPlayer.getPurses()
                + " Gold Coins.");
    }

    @Override
    public void displayBeforeNextQuestion(Game game) {
        System.out.println(game.currentPlayer.getPlayerName()
                + "'s new location is "
                + game.currentPlayer.getPlaces());
        System.out.println("The category is " + game.currentCategory());
    }

    @Override
    public void displayQuestion(String question) {
        System.out.println(question);
    }

    @Override
    public void displayNotGettingOutOfPenaltyBox(Game game) {
        System.out.println(game.currentPlayer.getPlayerName() + " is not getting out of the penalty box");
    }

    @Override
    public void displayGettingOutOfPenaltyBox(Game game) {
        System.out.println(game.currentPlayer.getPlayerName() + " is getting out of the penalty box");
    }

    @Override
    public void displayPlayerRoll(int roll, Game game) {
        System.out.println(game.players.get(game.currentPlayerNumber).getPlayerName() + " is the current player");
        System.out.println("They have rolled a " + roll);
    }

    @Override
    public void displayAddedPlayer(String playerName, Game game) {
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + game.players.size());
    }
}
