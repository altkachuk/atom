package com.atproj.homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeWork2 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
             System.out.print("Please write your name: ");
            String user = br.readLine();
            System.out.println("Your name is: " + user);
        } catch (IOException e) {
            ;
        }
    }
}
