package ru.sbt.jschool.session1;

/**
 * Написать программу, которая выводит все аргументы, которые ей передали.
 */
public class Problem1 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
