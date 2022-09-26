/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorefrontend.book;

/**
 *
 * @author Vijay
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Book {
    private String bookId;
    private String title;
    private String description;
    private String author;
    private Double price;
     private String location;
    
    @Override
     public String toString(){
         return "Book ID: " + bookId + "\n" + "Title: " + title + "\n"
                 + "Description: " + description + "\n" + "Author: " + author + "\n"
                 + "Price: " + price;
     }
}
