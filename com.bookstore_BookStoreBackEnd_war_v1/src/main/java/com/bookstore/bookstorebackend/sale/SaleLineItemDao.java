/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.sale;

import com.bookstore.bookstorebackend.config.DatabaseConfig;
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
public class SaleLineItemDao implements SaleLineItemDaoInt{
    private DatabaseConfig config;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int rowsAffected;
     public SaleLineItemDao(){
         config  = new DatabaseConfig();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaleLineItemDao.class.getName()).log(Level.SEVERE, null, ex);        }
        String url = config.readUrl();
        try {
            con = DriverManager.getConnection(url, config.readPropertiesUser(), config.readPropertiesPassword());
        } catch (SQLException ex) {
            Logger.getLogger(SaleLineItemDao.class.getName()).log(Level.SEVERE, null, ex);        }
    }
     
     public boolean createItem(SaleLineItem item){
        try {
            ps = con.prepareStatement("insert into salelineitem(id, saleId, quantity,bookId) values(?,?,?,?)");
            ps.setString(1, item.getId());
            ps.setString(2,item.getSaleId());
           ps.setInt(3, item.getQuantity());
           ps.setString(4, item.getBookId());
           rowsAffected = ps.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(SaleLineItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
            if(ps!= null){
                try {
                    ps.close();
                            } catch (SQLException ex) {
                    Logger.getLogger(SaleLineItemDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return rowsAffected == 1;
     }
}
