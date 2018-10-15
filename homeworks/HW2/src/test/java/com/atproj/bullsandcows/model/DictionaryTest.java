package com.atproj.bullsandcows.model;

import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {

    @Test
    public void testReadFromFile() {
        Dictionary dictionary = new Dictionary("/dictionary.txt");
        Assert.assertTrue(dictionary.getWords().get(4).equals("aaliis"));
    }
}
