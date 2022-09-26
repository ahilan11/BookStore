/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.stock;

import com.bookstore.bookstorebackend.id.IdGen;

/**
 *
 * @author Vijay
 */
public class StockService implements StockServiceInt {
      private StockDaoInt dao;
      private IdGen idGenerator;
      
      public StockService(){
          dao = new StockDao();
          idGenerator = new IdGen();
      }

    @Override
    public String decreaseStock(int num, String bookId) {
        return dao.decreaseStock(num, bookId)?"success":"failure";
    }

    @Override
    public String increaseStock(int num, String bookId) {
return dao.increaseStock(num, bookId)?"success":"failure";    }

    @Override
    public String createStock(Stock stock) {
        stock.setStockId(idGenerator.genIdLength12());
return dao.createStock(stock)?"success":"failure";
    }

    @Override
    public String checkStock(String bookId, int quantity) {
        return (dao.checkStock(bookId) >= quantity)?"success":"failure";
           
        
    }
}
