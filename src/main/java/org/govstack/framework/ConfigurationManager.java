package org.govstack.framework;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationManager {

    public static String getPropertyValue(String key){
        Properties prop=new Properties();
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//ConfigProperty.properties");
            prop.load(file);
            return prop.getProperty(key);
        }catch (Exception e){
            System.out.println("Unable to read property file");
            return null;
        }
    }

}
