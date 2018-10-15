package com.atproj.bullsandcows.utils;

import com.atproj.bullsandcows.exceptions.DifferentLengthException;
import com.atproj.bullsandcows.model.Model;
import org.junit.Assert;
import org.junit.Test;

public class GameUtilTest {

    @Test
    public void testDifferentSizeOfWords() throws Exception {
        Model model = new Model("test",10);
        try {
            GameUtil.testWord("src", model);
        } catch (DifferentLengthException e) {
            Assert.assertEquals("DifferentLengthException: Wrong length", e.getMessage());
        }
    }

    @Test
    public void testBullsAndCows() throws Exception {
        Model model = new Model("test",10);
        GameUtil.testWord("ttsa", model);
        Assert.assertTrue(model.getBulls() == 2 && model.getCows() == 1);
    }

    @Test
    public void testBullsAndCows2() throws Exception {
        Model model = new Model("creasy",10);
        GameUtil.testWord("creast", model);
        Assert.assertTrue(model.getBulls() == 5 && model.getCows() == 0);
    }

    @Test
    public void testAttempts() throws Exception {
        Model model = new Model("test", 10);

        GameUtil.testWord("ttsa", model);
        GameUtil.testWord("ttsa", model);
        GameUtil.testWord("ttsa", model);
        GameUtil.testWord("ttsa", model);

        Assert.assertTrue(model.getNumAttempts() == 4);

    }
}
