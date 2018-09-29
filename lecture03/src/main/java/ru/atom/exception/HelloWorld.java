package ru.atom.exception;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        //System.out.println(getHelloWorld());
        //System.out.println(testException(new FileNotFoundException("some message")));
        System.out.println(tryWithResource("somefile"));

        List<String> stringList;
        stringList = createList();
    }

    private static List createList() {
        return new ArrayList();
    }

    private static String getHelloWorld() {
        throw new NullPointerException("Ой всё");
    }

    private static String testException(Throwable exception) {
        try {
            throw exception;
        } catch (FileNotFoundException e) {
            return "catch: FileNotFoundException";
        } catch (Exception e) {
            return "catch: Exception";
        } finally {
            return "finally";
        }
    }

    private static String tryWithResource(String fileName) {
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.readLine();
        } catch (FileNotFoundException e) {
            return "FileNotFoundException";
        } catch (IOException e) {
            return "IOException";
        }
    }
}