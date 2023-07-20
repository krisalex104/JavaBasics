package string;

import java.util.Arrays;

public class Anagrams {

    public static void main(String[] args) {
        String str1 = "Bored";
        String str2 = "Robed";

        //Convert strings to lowercase
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        // Check to see if the lengths are the same
        if (str1.length() == str2.length()) {
            // convert strings into char array
            char[] str1charArray = str1.toCharArray();
            char[] str2charArray = str2.toCharArray();
            // sort the char array
            Arrays.sort(str1charArray);
            Arrays.sort(str2charArray);
            // if the sorted char arrays are same or identical
            // then the strings are anagram
            boolean result = Arrays.equals(str1charArray, str2charArray);
            if (result) {
                System.out.println(str1 + " and " + str2 + " are anagrams of each other.");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
            }
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
        }
    }
}

