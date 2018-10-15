package com.atproj.bullsandcows.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> readFromFile(String filename) {
        File file = new File(filename);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            List<String> result = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
            return result;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
