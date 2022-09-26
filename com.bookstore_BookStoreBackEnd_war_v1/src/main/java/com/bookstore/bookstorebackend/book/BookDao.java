/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.book;

import com.bookstore.bookstorebackend.config.DatabaseConfig;
import com.bookstore.bookstorebackend.id.IdGen;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vijay
 */
public class BookDao implements BookDaoInt{
      private DatabaseConfig config;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int rowsAffected;
     public BookDao(){
         config  = new DatabaseConfig();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);        }
        String url = config.readUrl();
        try {
            con = DriverManager.getConnection(url, config.readPropertiesUser(), config.readPropertiesPassword());
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);        }
    }
     @Override
     public boolean createBook(Book book){
          try {
              ps = con.prepareStatement("insert into book(bookId,title,description,author,price,location) values(?,?,?,?,?,?)");
              ps.setString(1,book.getBookId());
              ps.setString(2,book.getTitle());
              ps.setString(3,book.getDescription());
              ps.setString(4,book.getAuthor());
              ps.setDouble(5,book.getPrice());
              ps.setString(6,book.getLocation());
             rowsAffected =  ps.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          finally{
              if(ps!= null){
                  try {
                      ps.close();
                  } catch (SQLException ex) {
                      Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          }
          return rowsAffected==1;
     }

    @Override
    public List<Book> getAllBooks() {
        List list = new ArrayList<Book>();
        Book book = new Book();
        try {
            ps  = con.prepareStatement("select * from book");
            rs = ps.executeQuery();
            while(rs.next()){
                book.setBookId(rs.getString("bookId"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setLocation(rs.getString("location"));
                list.add(book);
                book = new Book();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(ps!= null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    @Override
    public Book getBook(String bookId) {
         Book book = new Book();
        try {
            ps  = con.prepareStatement("select * from book where bookId = ?");
            ps.setString(1, bookId);
            rs = ps.executeQuery();
            if(rs.next()){
                book.setBookId(rs.getString("bookId"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setLocation(rs.getString("location"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(ps!= null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return book;
    }
}
