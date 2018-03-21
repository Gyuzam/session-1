package ru.sbt.jschool.session1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Написать программу, которая выводит "Hello, World!" количество раз переданное:
 * Если передан параметр вида JSCHOOl1_COUNT=XXX, где XXX число раз, то используется оно.
 * Если передана системная настройка вида JSCHOOl1_COUNT=XXX, где XXX число раз, то используется оно.
 * Если определена переменная окружения вида JSCHOOl1_COUNT=XXX, где XXX число раз, то используется оно.
 * Если определена переменная окружения вида JSCHOOL1_PROPERTIES_FILE=XXX, где XXX это путь к существующему файлу, то загружаем настройки оттуда и пытаемся получить настройку оттуда.
 * Если ничего не задано, выводим сообщение о вариантах исопльзования программы и завершаем.
 */

public class Problem4 {

    public static String count_string = "JSCHOOl1_COUNT";
    public static String properties_file_string = "JSCHOOL1_PROPERTIES_FILE";
    public static String output_string = "Hello, World!";

    public static void main(String[] args) {

        Integer number = 0;

        // В аргументе
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith(count_string)){
                String num = args[i].replaceFirst (count_string + "=", "");
                number = Integer.parseInt(num);
                output(number);
                return;
            }
        }

        // Системная настройка
        String property = System.getProperties().getProperty(count_string);
        if (property != null){
            number = Integer.parseInt(property);
            output(number);
            return;
        }

        // Переменная окружения
        String envvar = System.getenv(count_string);
        if (envvar != null){
            number = Integer.parseInt(envvar);
            output(number);
            return;
        }

        // Переменная окружения - файл
        String fileenv = System.getenv(properties_file_string);
        if (fileenv != null) {
            Properties prop = new Properties();
            try{
                FileInputStream inputStream = new FileInputStream(fileenv);
                prop.load(inputStream);
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            property = prop.getProperty(count_string);
            if (property != null){
                number = Integer.parseInt(property);
                output(number);
                return;
            }
        }

        // Ничего
        System.out.println("Программа выводит \"Hello, World!\" количество раз переданное:");
        System.out.println("Если передан параметр вида JSCHOOl1_COUNT=N, где N - число раз, то используется оно.");
        System.out.println("Если передана системная настройка вида JSCHOOl1_COUNT=N, где N - число раз, то используется оно.");
        System.out.println("Если определена переменная окружения вида JSCHOOl1_COUNT=N, где N - число раз, то используется оно.");
        System.out.println("Если определена переменная окружения вида JSCHOOL1_PROPERTIES_FILE=XXX, где XXX это " +
                "путь к существующему файлу, то настройка JSCHOOl1_COUNT=N загружается оттуда.");
        System.out.println("Если ничего не задано, выводится сообщение о вариантах использования программы.");

        return;
    }

    // Вывод строки num количество раз
    public static void output(Integer num){
        for (int i = 0; i < num; i++) {
            System.out.println(output_string);
        }
        return;
    }
}
