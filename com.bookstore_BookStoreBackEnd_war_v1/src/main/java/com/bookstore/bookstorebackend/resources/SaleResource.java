/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.resources;

import com.bookstore.bookstorebackend.employee.Employee;
import com.bookstore.bookstorebackend.employee.EmployeeService;
import com.bookstore.bookstorebackend.employee.EmployeeServiceInt;
import com.bookstore.bookstorebackend.sale.Sale;
import com.bookstore.bookstorebackend.sale.SaleService;
import com.bookstore.bookstorebackend.sale.SaleServiceInt;
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
@Path("sale")

public class SaleResource {

    private SaleServiceInt service;

    public SaleResource() {
        service = new SaleService();
    }

    @Path("createSale")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createSale(Sale sale) {
        return Response.status(Response.Status.OK).entity(service.createSale(sale)).build();
    }
 
}
