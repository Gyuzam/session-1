package ru.sbt.jschool.session1;

import java.util.Arrays;

import static java.lang.Integer.min;
import static java.lang.Long.parseLong;

public class Dop {

    public static long binaryToDec(String binary){
        long t = 0;
        try {
            t = parseLong(binary, 2);
        }
        catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
    }

    public static long sumOfBinary(String b1, String b2){
        long t1 = binaryToDec(b1);
        long t2 = binaryToDec(b2);
        return t1 + t2;
    }

    public static long[] intersection(long[] arr1, long[] arr2){
        int size = min(arr1.length, arr2.length);
        long[] res = new long[size];
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] == arr2[j]){
                res[k] = arr1[i];
                i++;
                j++;
                k++;
                continue;
            }
            if (arr1[i] < arr2[j]){
                i++;
                continue;
            }
            if (arr1[i] > arr2[j]){
                j++;
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String s1 = "110010100101";
        String s2 = "10111101";
        System.out.println(binaryToDec(s1));
        System.out.println(binaryToDec(s2));
        System.out.println(sumOfBinary(s1, s2));

        System.out.println("--------");
        long[] m1 = {110, 130, 44560, 43, 56780, 23000, 4500, 1290, 23, 1};
        long[] m2 = {450, 22330, 110, 44560, 4500, 1290, 67, 76780, 13000};
        long[] m = intersection(m1, m2);
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i]);
        }
    }
}
