/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.sale;

import com.bookstore.bookstorebackend.id.IdGen;

/**
 *
 * @author Vijay
 */
public class SaleService implements SaleServiceInt{
    private SaleDaoInt dao;
    private IdGen idGenerator;
    
    public SaleService(){
        dao = new SaleDao();
        idGenerator = new IdGen();
    }
    
    @Override
       public String createSale(Sale sale){
           sale.setSaleId(idGenerator.genIdLength12());
            return dao.createSale(sale)?sale.getSaleId():"failure";
        }

}
