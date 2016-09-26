package com.interview.challenges.strings;

public class Strings {
    
    public void evaluate() {
        String str = "You are a mad fuck, in a mad fuck world.";
        String[] words = {"fuck"};
        System.out.println("Ater sensoring words - " + sensoringWords(str, words));
        
        String str1 = "You are a mad       fuck.";
        System.out.println("Ater stripping of white spaces - " + stripOfWhiteSpaces(str1));
        
        String str2 = "aaabbcdddd";
        System.out.println("Compress - " + compress(str2));
        
        
        String str3 = "sum123sum123";
        System.out.println("Sum - " + findSum(str3));
    }
    
    
    public String sensoringWords(String str, String[] words) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            boolean found = false;
            for (String word : words) {
                if (i + word.length() <= str.length() && str.substring(i, i + word.length()).equals(word)) {
                    for (int j = 0; j < word.length(); j++) {
                        builder.append("X");
                    }
                    found = true;
                    i = i + word.length() - 1;
                }
            }
            if (!found)
                builder.append(str.charAt(i));
        }
        return builder.toString();
    }
    
    public String stripOfWhiteSpaces(String str) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i<str.length()) {
            int count = 0;
            while (str.charAt(i) == ' ') {
                count++;
                i++;
            }
            if (count >= 1) {
                builder.append(" ");
            } else {
                builder.append(str.charAt(i));
                i++;
            }   
        }
        return builder.toString();
    }
    
    public String compress(String str) {
        StringBuilder builder = new StringBuilder();
        char ch = str.charAt(0);
        int i = 1;
        while (i < str.length()) {
            int count = 1;
            while (i < str.length() && ch == str.charAt(i)) {
                count ++;
                i++;
            }
            builder.append(ch).append(count);
            if (i<str.length()) {
                ch = str.charAt(i);
                i++;
            }
        }
        return builder.toString();
    }
    
    public int findSum(String str) {
        int sum = 0;
        for (int i=0;i<str.length();i++) {
            if (Character.isDigit(str.charAt(i))) {
                StringBuilder builder = new StringBuilder();
                while (i<str.length() && Character.isDigit(str.charAt(i))) {
                    builder.append(str.charAt(i));
                    i++;
                }
                sum = sum + Integer.parseInt(builder.toString());
            }
        }
        return sum;
    }
}
