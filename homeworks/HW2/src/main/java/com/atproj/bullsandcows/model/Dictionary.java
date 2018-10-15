package com.atproj.bullsandcows.model;

import com.atproj.bullsandcows.utils.FileUtil;

import java.util.List;
import java.util.Random;

public class Dictionary {

    private List<String> words;

    public Dictionary(String resource) {
        words = FileUtil.readFromFile(this.getClass().getResource(resource).getPath());
    }

    public List<String> getWords() {
        return words;
    }

    public String getRandomWord() {
        if (words == null) return null;
        int i = new Random().nextInt(words.size());
        return words.get(i);
    }
}
