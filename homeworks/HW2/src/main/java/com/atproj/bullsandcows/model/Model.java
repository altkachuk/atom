package com.atproj.bullsandcows.model;

public class Model {

    private String word;
    private int bulls;
    private int cows;
    private int maxAttempts;
    private int numAttempts;

    public Model(String word, int maxAttepts) {
        this.word = word;
        this.maxAttempts = maxAttepts;
        numAttempts = 0;
    }

    public String getWord() {
        return word;
    }

    public int getBulls() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    public int getCows() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public int getNumAttempts() {
        return numAttempts;
    }

    public void increaseAttempts() {
        numAttempts++;
    }
}
