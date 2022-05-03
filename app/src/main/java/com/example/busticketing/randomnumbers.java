package com.example.busticketing;
import java.util.Random;

public class randomnumbers {

    private  final String letters = "abcdefghijklmnopqrstuvwxyz";
    private  final String numbers = "0123456789";
    private final char[] alphanumeric = (letters+letters.toUpperCase()+numbers).toCharArray();

    public String generatealphanumeric(int length)
    {
        StringBuilder result = new StringBuilder();
        for (int i=0; i<length ; i++)
        {
            result.append(alphanumeric[new Random().nextInt(alphanumeric.length)]);
        }
        return result.toString();
    }

}
