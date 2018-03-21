package ru.sbt.jschool.session1;

import java.util.Map;

/**
 * Написать программу, которая выводит все переменные окружения.
 */
public class Problem3 {
    public static void main(String[] args) {
        Map<String, String> envs = System.getenv();
        for (String envName : envs.keySet()) {
            System.out.format("%s=%s%n", envName, envs.get(envName));
        }
    }
}
