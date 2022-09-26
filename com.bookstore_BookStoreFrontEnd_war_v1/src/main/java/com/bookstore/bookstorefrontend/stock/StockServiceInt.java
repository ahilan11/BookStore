/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorefrontend.stock;

/**
 *
 * @author Vijay
 */
public interface StockServiceInt {
    String decreaseStock(Stock stock);
    String increaseStock(Stock stock);
    String createStock(Stock stock);
    String checkStock(String bookId, Integer quantity);
}
