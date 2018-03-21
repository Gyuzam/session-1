package ru.sbt.jschool.session1;

import java.util.Map;

/**
 * Написать программу, которая выводит все системные переменные.
 */
public class Problem2 {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
    }
}
