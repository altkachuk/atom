package com.atproj.bullsandcows;

import com.atproj.bullsandcows.exceptions.DifferentLengthException;
import com.atproj.bullsandcows.model.Dictionary;
import com.atproj.bullsandcows.model.Model;
import com.atproj.bullsandcows.utils.GameUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BullsAndCows {

    public static void main(String[] args) {
        System.out.println("Welcome to the game Bulls and Cows!");
        Dictionary dictionary = new Dictionary("/dictionary.txt");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            startNewGame(dictionary, br);

            boolean theend = false;
            while (!theend) {
                System.out.println("Wanna play again? Y/N");
                String command = br.readLine();
                if (command.toLowerCase().equals("y")) {
                    startNewGame(dictionary, br);
                } else if (command.toLowerCase().equals("n")) {
                    theend = true;
                } else {
                    System.out.println("Wrong command");
                }
            }

        } catch (IOException e) {
            ;
        }
    }

    private static void startNewGame(Dictionary dictionary, BufferedReader br) throws IOException {
        String word = dictionary.getRandomWord();
        System.out.println("I offered a " + word.length() + "-letter word, your guess?");

        int numAttempts = 10;
        Model model = new Model(word, numAttempts);

        for (int i = 0; i < numAttempts; i++) {
            try {
                String testWord = br.readLine();
                if (GameUtil.testWord(testWord, model)) {
                    System.out.println("You won!");
                    break;
                } else {
                    System.out.println("Bulls: " + model.getBulls());
                    System.out.println("Cows: " + model.getCows());
                }
            } catch (DifferentLengthException e) {
                System.out.println("You type wrong size of word!");
            }
        }
    }

}
