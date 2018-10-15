package com.atproj.bullsandcows.utils;

import com.atproj.bullsandcows.exceptions.DifferentLengthException;
import com.atproj.bullsandcows.model.Model;

import java.util.ArrayList;
import java.util.List;

public class GameUtil {

    public static boolean testWord(String srcWord, Model model) throws DifferentLengthException {
        if (srcWord.length() != model.getWord().length())
            throw new DifferentLengthException("Wrong length");

        int bulls = 0;
        int cows = 0;

        if (srcWord.equals(model.getWord())) {
            bulls = model.getWord().length();
            return true;
        }

        List<Integer> cowsIndeces = new ArrayList<>();
        // search bulls
        for (int i = 0; i < model.getWord().length(); i++) {
            if (srcWord.substring(i, i+1).equals(model.getWord().substring(i, i+1)))
                bulls++;
            else
                cowsIndeces.add(i);
        }


        // search cows
        for (int i = 0; i < cowsIndeces.size(); i++) {
            for (int j = 0; j < cowsIndeces.size(); j++) {
                int wordIndex = cowsIndeces.get(i);
                int testWordIndex = cowsIndeces.get(j);
                if (srcWord.substring(testWordIndex, testWordIndex+1).equals(model.getWord().substring(wordIndex, wordIndex+1))) {
                    cows++;
                }
            }
        }

        model.setBulls(bulls);
        model.setCows(cows);
        model.increaseAttempts();

        return false;
    }
}
