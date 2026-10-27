/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konfiguracija;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author Korisnik
 */
public class Konfiguracija {

    private static Konfiguracija instance;
    private Properties konfiguracija;
    private static final String CONFIG_PATH = "config/config.properties";

    private Konfiguracija() {
        konfiguracija = new Properties();
        try {
            konfiguracija.load(new FileInputStream(CONFIG_PATH));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.getLogger(Konfiguracija.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public static Konfiguracija getInstance(){
        if (instance == null) {
            instance = new Konfiguracija();
        }
        return instance;
    }

    public String getProperty(String key){
        return konfiguracija.getProperty(key,"n/a");
    }

    public void setProperty(String key, String value){
        konfiguracija.setProperty(key, value);
    }

    public void sacuvajIzmene(){
        try {
            konfiguracija.store(new FileOutputStream(CONFIG_PATH), null);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.getLogger(Konfiguracija.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

}
