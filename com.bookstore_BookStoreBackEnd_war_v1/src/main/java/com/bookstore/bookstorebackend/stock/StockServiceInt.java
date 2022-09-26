/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.stock;

/**
 *
 * @author Vijay
 */
public interface StockServiceInt {
    String decreaseStock(int num, String bookId);
    String increaseStock(int num, String bookId);
    String createStock(Stock stock);
    String checkStock(String bookId, int quantity);
}
