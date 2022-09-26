/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.resources;

import com.bookstore.bookstorebackend.employee.Employee;
import com.bookstore.bookstorebackend.employee.EmployeeService;
import com.bookstore.bookstorebackend.employee.EmployeeServiceInt;
import com.bookstore.bookstorebackend.sale.SaleLineItem;
import com.bookstore.bookstorebackend.sale.SaleLineItemService;
import com.bookstore.bookstorebackend.sale.SaleLineItemServiceInt;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author Vijay
 */
@Path("saleLineItem")

public class SaleLineItemResource {

    private SaleLineItemServiceInt service;

    public SaleLineItemResource() {
        service = new SaleLineItemService();
    }

    @Path("createItem")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createItem(SaleLineItem item) {
        return Response.status(Response.Status.OK).entity(service.createItem(item)).build();
    }
    

}
