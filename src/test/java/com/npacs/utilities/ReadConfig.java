package com.npacs.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig() {
        File src = new File("./Configuration/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (IOException e) {
            System.out.println("Exception is" + e.getMessage());
        }
    }

    //Getter methods for retrieve properties from config.properties file
    public String getBrowser(){return pro.getProperty("browser");}

    public String getApplicationURL(){
        return pro.getProperty("baseURL");
    }

    public String getChromePath(){
        return pro.getProperty("chromepath");
    }

}