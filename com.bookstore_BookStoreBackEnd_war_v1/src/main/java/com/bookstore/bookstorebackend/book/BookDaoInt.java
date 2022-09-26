/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.book;

import java.util.List;

/**
 *
 * @author Vijay
 */
public interface BookDaoInt {
    boolean createBook(Book book);
    List<Book> getAllBooks();
    Book getBook(String bookId);
    
}
