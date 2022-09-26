/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vijay
 */
public class DatabaseConfig {
    private FileReader reader = null;
       private Properties p = null;
     public String readUrl() {
        
        try {
            reader = new FileReader("C:\\Users\\Vijay\\Documents\\NetBeansProjects\\BookStoreBackEnd\\src\\main\\java\\com\\bookstore\\bookstorebackend\\config\\Database.properties");
            p = new Properties();
            p.load(reader);
      
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConfig.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(DatabaseConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p.getProperty("db.protocol")  + ":" + p.getProperty("db.subProtocol") + "://" + p.getProperty("db.ip") + ":" + p.getProperty("db.port") + "/" + p.getProperty("db.resource");
    }
     
     public String readPropertiesUser() {
       
        try {
            reader = new FileReader("C:\\Users\\Vijay\\Documents\\NetBeansProjects\\BookStoreBackEnd\\src\\main\\java\\com\\bookstore\\bookstorebackend\\config\\Database.properties");
            p = new Properties();
            p.load(reader);
      
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConfig.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(DatabaseConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p.getProperty("db.user");
    }

    public String readPropertiesPassword() {
        
        try {
            reader = new FileReader("C:\\Users\\Vijay\\Documents\\NetBeansProjects\\BookStoreBackEnd\\src\\main\\java\\com\\bookstore\\bookstorebackend\\config\\Database.properties");
            p = new Properties();
            p.load(reader);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConfig.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(DatabaseConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p.getProperty("db.password");
    }
}
