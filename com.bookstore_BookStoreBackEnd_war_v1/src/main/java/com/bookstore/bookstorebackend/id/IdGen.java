/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.id;

/**
 *
 * @author Vijay
 */
public class IdGen {
    public String genIdLength12(){
        String id = "";
        for (int j = 0; j < 4; j++) {
            char letter = (char) ((int) (Math.random() * (90 - 65) + 65));
            id = id + letter;
        }
        for (int i = 0; i < 8; i++) {
            int num = (int) (Math.random() * 9);
            id = id + num;
        }
        return id;
    }
    
    public String genIdLength6(){
        String id = "";
        for (int j = 0; j <2; j++) {
            char letter = (char) ((int) (Math.random() * (90 - 65) + 65));
            id = id + letter;
        }
        for (int i = 0; i < 4; i++) {
            int num = (int) (Math.random() * 9);
            id = id + num;
        }
        return id;
    }
}
