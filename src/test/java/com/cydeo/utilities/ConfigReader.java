package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties PROPERTIES = new Properties();

    static{
        try{
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            PROPERTIES.load(file);
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static String getProperty(String key){
        return PROPERTIES.getProperty(key);
    }
}
