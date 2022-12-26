package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Day09_C6_ConfigReader {
    /*Bu class configuration.properties file okumak icindir*/

    //Properties object olustur
    private static Properties properties;
    //static block olustur cunku bu kod methodlardan once calismali
    static {
        //path of the properties file
        String path="configuration.properties";
        try {
            //file'i ac
            FileInputStream fileInputStream = new FileInputStream(path);

            // properties object'i aktif et/calistir
            properties=new Properties();
            //file'i yukle
            properties.load(fileInputStream);
            //file'i kapat
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //ending static block
    //methodu olustur
    //String bir key alacak ve String bir value dondurecek
    // getProperty("app_url"); => "http://www.carettahotel.com/"
    public static String getProperty(String key){
        String value = properties.getProperty(key);
        return value;
//veya        return properties.getProperty(key);
    }
}


