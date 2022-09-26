/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.stock;

import com.bookstore.bookstorebackend.config.DatabaseConfig;
import com.bookstore.bookstorebackend.sale.SaleLineItemDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vijay
 */
public class StockDao implements StockDaoInt{
    private DatabaseConfig config;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int rowsAffected;
     public StockDao(){
         config  = new DatabaseConfig();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);        }
        String url = config.readUrl();
        try {
            con = DriverManager.getConnection(url, config.readPropertiesUser(), config.readPropertiesPassword());
        } catch (SQLException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);        }
    }
     
    @Override
     public boolean createStock(Stock stock){
          try {
              ps = con.prepareStatement("insert into stock(stockId, bookId, quantity) values(?,?,?)");
                 ps.setString(1,stock.getStockId());
                 ps.setString(2,stock.getBookId());
                 ps.setInt(3,stock.getQuantity());
              rowsAffected = ps.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          finally{
              if(ps!= null){
                  try {
                      ps.close();
                  } catch (SQLException ex) {
                      Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          }
          return rowsAffected == 1;
     }
     
    @Override
      public boolean increaseStock(int num, String bookId){
          
          try {
              ps = con.prepareStatement("update stock set quantity = quantity+? where bookId = ?");
                 ps.setInt(1,num);
                 ps.setString(2,bookId);
              rowsAffected = ps.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          finally{
              if(ps!= null){
                  try {
                      ps.close();
                  } catch (SQLException ex) {
                      Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          }
          return rowsAffected == 1;
     }
      
    @Override
       public boolean decreaseStock(int num, String bookId){
          
          try {
              ps = con.prepareStatement("update stock set quantity = quantity-? where bookId = ?");
                 ps.setInt(1,num);
                 ps.setString(2,bookId);
              rowsAffected = ps.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          finally{
              if(ps!= null){
                  try {
                      ps.close();
                  } catch (SQLException ex) {
                      Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          }
          return rowsAffected == 1;
     }
       
       public int checkStock(String bookId){
           int quantity = 0;
        try {
            ps = con.prepareStatement(" select * from stock where bookId = ?");
            ps.setString(1,bookId);
            rs = ps.executeQuery();
            if(rs.next()){
                quantity = rs.getInt("quantity");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(ps!= null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!= null){
                try {
                    rs.close();
                            } catch (SQLException ex) {
                    Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
                return quantity;

       }
}
