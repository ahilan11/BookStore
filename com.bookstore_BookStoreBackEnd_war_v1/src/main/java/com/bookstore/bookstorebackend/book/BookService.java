/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.book;

import com.bookstore.bookstorebackend.id.IdGen;
import java.util.List;
import org.w3c.dom.Document;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
/**
 *
 * @author Vijay
 */
public class BookService implements BookServiceInt{

    private BookDaoInt dao;
    private IdGen generateId;

    public BookService() {
        dao = new BookDao();
        generateId = new IdGen();

    }

    @Override
    public String createBook(Book book) {
        book.setBookId(generateId.genIdLength12());
        return dao.createBook(book) ? book.getBookId() : "failure";
    }

    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }
    
    @Override
    public Book getBook(String bookId){
        return dao.getBook(bookId);
    }
    
    @Override
    public String purchasePdf(Book b){
        Book book = dao.getBook(b.getBookId());
        
        try {
            byte[] inFileBytes = Files.readAllBytes(Paths.get(book.getLocation()));
           byte[] encoded = java.util.Base64.getEncoder().encode(inFileBytes);
             byte[] decoded = java.util.Base64.getDecoder().decode(encoded);
            
            FileOutputStream fos = new FileOutputStream(b.getLocation()+ "\\" + book.getTitle() + ".pdf");
            fos.write(decoded);
            fos.flush();
            fos.close();
           
            
        } catch (IOException ex) {
            Logger.getLogger(BookService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book.getBookId();
    }
}
