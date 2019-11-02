package com.company;

import java.util.Scanner;

//Program will prompt user for a word and check if word is a Java reserved word

public class IsJavaKeyword {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String word;

        //Prompt User for the word
        System.out.println("Please enter a word:");
        word = in.nextLine();

        String[] keywords;
        keywords = new String[]{"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
                "class", "const", "continue", "default", "do", "double", "else", "enum", "extends",
                "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof",
                "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return",
                "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
                "transient", "try", "void", "volatile", "while", "true", "false", "null"};

        boolean go = true;
        int i;
        //Check if word entered by user is a java reserved word, listed in above array.
        while (go == true) {
            for (i = 0; i < keywords.length; i++) {
                if (word.equals(keywords[i])){
                    System.out.print("is a java keyword");
                    i = keywords.length -1;
                    go = false;

                } else if (i >= keywords.length -1) {
                    System.out.print("not a java keyword");
                    go = false;
                    i = keywords.length -1;
                }
            }
        }
    }
}

