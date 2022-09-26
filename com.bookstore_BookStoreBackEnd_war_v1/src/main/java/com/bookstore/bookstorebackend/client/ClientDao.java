/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.client;

import com.bookstore.bookstorebackend.book.Book;
import com.bookstore.bookstorebackend.book.BookDao;
import com.bookstore.bookstorebackend.config.DatabaseConfig;
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
public class ClientDao implements ClientDaoInt{
      private DatabaseConfig config;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int rowsAffected;
     public ClientDao(){
         config  = new DatabaseConfig();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);        }
        String url = config.readUrl();
        try {
            con = DriverManager.getConnection(url, config.readPropertiesUser(), config.readPropertiesPassword());
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);        }
    }
     
      @Override
     public boolean createClient(Client client){
          try {
              ps = con.prepareStatement("insert into client(clientId, name, surname, email,password) values(?,?,?,?,?)");
                 ps.setString(1,client.getClientId());
                 ps.setString(2,client.getName());
                 ps.setString(3,client.getSurname());
                 ps.setString(4,client.getEmail());
                 ps.setString(5,client.getPassword());
              rowsAffected = ps.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          finally{
              if(ps!= null){
                  try {
                      ps.close();
                  } catch (SQLException ex) {
                      Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          }
          return rowsAffected == 1;
     }
     
     @Override
    public List<Client> getAllClients() {
        List list = new ArrayList<Client>();
        Client client = new Client();
        try {
            ps  = con.prepareStatement("select * from client");
            rs = ps.executeQuery();
            while(rs.next()){
                client.setClientId(rs.getString("clientId"));
                client.setName(rs.getString("name"));
                client.setSurname(rs.getString("surname"));
                client.setEmail(rs.getString("email"));
                list.add(client);
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
    public Client getClient(String email) {
         Client client = new Client();
        try {
            ps  = con.prepareStatement("select * from client where email = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(rs.next()){
                client.setClientId(rs.getString("clientId"));
                client.setName(rs.getString("name"));
                client.setSurname(rs.getString("surname"));
                client.setPassword(rs.getString("password"));
                client.setEmail(rs.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(ps!= null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return client;
    }
}
