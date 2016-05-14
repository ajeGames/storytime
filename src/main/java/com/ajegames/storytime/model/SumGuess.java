package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SumGuess {

    private int playerNumber;
    private int totalGuess;

    public static SumGuess create(int playerNumber, int totalGuess) {
        SumGuess guess = new SumGuess();
        guess.playerNumber = playerNumber;
        guess.totalGuess = totalGuess;
        return guess;
    }

    @JsonProperty
    public int getPlayerNumber() {
        return playerNumber;
    }

    @JsonProperty
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    @JsonProperty
    public int getTotalGuess() {
        return totalGuess;
    }

    @JsonProperty
    public void setTotalGuess(int totalGuess) {
        this.totalGuess = totalGuess;
    }
}
