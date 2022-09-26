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
public class SaleLineItemService implements SaleLineItemServiceInt{
    private SaleLineItemDaoInt dao;
    private IdGen idGenerator;
    
    public SaleLineItemService(){
        dao = new SaleLineItemDao();
        idGenerator = new IdGen();
    }
    
    public String createItem(SaleLineItem item){
        item.setId(idGenerator.genIdLength12());
        return dao.createItem(item)?"success":"failure";
    }
}
