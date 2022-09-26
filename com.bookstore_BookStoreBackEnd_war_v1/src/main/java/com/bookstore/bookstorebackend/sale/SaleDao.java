/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.sale;

import com.bookstore.bookstorebackend.config.DatabaseConfig;
import com.bookstore.bookstorebackend.employee.EmployeeDao;
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
public class SaleDao implements SaleDaoInt{
     private DatabaseConfig config;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int rowsAffected;
     public SaleDao(){
         config  = new DatabaseConfig();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaleDao.class.getName()).log(Level.SEVERE, null, ex);        }
        String url = config.readUrl();
        try {
            con = DriverManager.getConnection(url, config.readPropertiesUser(), config.readPropertiesPassword());
        } catch (SQLException ex) {
            Logger.getLogger(SaleDao.class.getName()).log(Level.SEVERE, null, ex);        }
    }
     
      @Override
     public boolean createSale(Sale sale){
          try {
              ps = con.prepareStatement("  insert into sale(saleId, saleDate,employeeId,clientId) values(?,date(now()),?,?)");
                 ps.setString(1,sale.getSaleId());
                 ps.setString(2,sale.getEmployeeId());
                 ps.setString(3,sale.getClientId());
              rowsAffected = ps.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          finally{
              if(ps!= null){
                  try {
                      ps.close();
                  } catch (SQLException ex) {
                      Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          }
          return rowsAffected == 1;
     }
}
