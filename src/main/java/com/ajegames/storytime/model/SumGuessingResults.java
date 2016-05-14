package com.ajegames.storytime.model;

public class SumGuessingResults {

    private SumGuess playerGuess;
    private SumGuess opponentGuess;

    public static SumGuessingResults create(SumGuess playerGuess, SumGuess opponentGuess) {
        SumGuessingResults results = new SumGuessingResults();
        results.playerGuess = playerGuess;
        results.opponentGuess = opponentGuess;
        return results;
    }

    public SumGuess getPlayerGuess() {
        return playerGuess;
    }

    public SumGuess getOpponentGuess() {
        return opponentGuess;
    }

    public int getTotal() {
        return playerGuess.getPlayerNumber() + opponentGuess.getPlayerNumber();
    }

    public boolean youWin() {
        return Math.abs(playerGuess.getTotalGuess() - getTotal())
                < Math.abs(opponentGuess.getTotalGuess() - getTotal());
    }
}
