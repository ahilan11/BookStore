/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.stock;

/**
 *
 * @author Vijay
 */
public interface StockDaoInt {
    boolean decreaseStock(int num, String bookId);
    boolean increaseStock(int num, String bookId);
    boolean createStock(Stock stock);
    int checkStock(String bookId);
}
