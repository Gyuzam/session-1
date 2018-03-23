package ru.sbt.jschool.session1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HomeTask implements PropertyHelper{

    private String[] args;
    private Properties props;

    @Override
    public String stringValue(String name) {

        // В аргументе
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith(name + "=")){
                String val = args[i].replaceFirst (name + "=", "");
                return val;
            }
        }

        // Системная настройка
        String property = System.getProperties().getProperty(name);
        if (property != null){
            return property;
        }

        // Переменная окружения
        String envvar = System.getenv(name);
        if (envvar != null){
            return envvar;
        }

        // Файл
        property = props.getProperty(name);
        if (property != null) {
            return property;
        }

        return null;
    }

    @Override
    public Integer integerValue(String name) {
        String val = stringValue(name);
        try {
            Integer number = Integer.parseInt(val);
            return number;
        }
        catch (NumberFormatException ex) {
            //System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Double doubleValue(String name) {
        String val = stringValue(name);
        try {
            Double number = Double.parseDouble(val);
            return number;
        }
        catch (NumberFormatException ex) {
            //System.out.println(ex.getMessage());
            return null;
        }
    }

    HomeTask(String[] args, String path) {
        this.args = args;
        if (path != null) {
            this.props = new Properties();
            try{
                FileInputStream inputStream = new FileInputStream(path);
                props.load(inputStream);
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        HomeTask ht = new HomeTask(args, "C:/input.properties");

        System.out.println(ht.stringValue("num"));

        Integer intn = ht.integerValue("num");
        if (intn != null) {
            System.out.println(intn);
        }

        Double dobn = ht.doubleValue("num");
        if (dobn != null) {
            System.out.println(dobn);
        }

        return;
    }
}
