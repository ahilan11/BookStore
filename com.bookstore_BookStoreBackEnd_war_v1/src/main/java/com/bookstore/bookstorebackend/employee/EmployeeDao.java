/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.employee;

import com.bookstore.bookstorebackend.book.BookDao;
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
public class EmployeeDao implements EmployeeDaoInt{
      private DatabaseConfig config;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int rowsAffected;
     public EmployeeDao() {
         config  = new DatabaseConfig();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);        }
        String url = config.readUrl();
        try {
            con = DriverManager.getConnection(url, config.readPropertiesUser(), config.readPropertiesPassword());
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);        }
    }
     
      @Override
     public boolean createEmployee(Employee employee){
          try {
              ps = con.prepareStatement(" insert into employee(employeeId, name, surname, password) values(?,?,?,?)");
                 ps.setString(1,employee.getEmployeeId());
                 ps.setString(2,employee.getName());
                 ps.setString(3,employee.getSurname());
                 ps.setString(4,employee.getPassword());
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
     
      @Override
      public Employee getEmployee(String employeeId) {
         Employee employee = new Employee();
        try {
            ps  = con.prepareStatement("select * from employee where employeeId = ?");
            ps.setString(1, employeeId);
            rs = ps.executeQuery();
            if(rs.next()){
                employee.setEmployeeId(rs.getString("employeeId"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setPassword(rs.getString("password"));
            }
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
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return employee;
    }
}
