package com.atproj.bullsandcows.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FileUtilTest {

    @Test
    public void testReadFromFile() throws Exception {
        {
            List<String> strings = FileUtil.readFromFile("/somefile");
            Assert.assertNull(strings);
        }

        {
            List<String> strings = FileUtil.readFromFile(
                    this.getClass().getResource("/dictionary.txt").getPath());
            Assert.assertNotNull(strings);
        }
    }
}
