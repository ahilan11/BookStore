/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.resources;

import com.bookstore.bookstorebackend.employee.Employee;
import com.bookstore.bookstorebackend.employee.EmployeeService;
import com.bookstore.bookstorebackend.employee.EmployeeServiceInt;
import com.bookstore.bookstorebackend.stock.Stock;
import com.bookstore.bookstorebackend.stock.StockService;
import com.bookstore.bookstorebackend.stock.StockServiceInt;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vijay
 */
@Path("stock")

public class StockResource {

    private StockServiceInt service;

    public StockResource() {
        service = new StockService();
    }

    @Path("createStock")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createStock(Stock stock) {
        return Response.status(Response.Status.OK).entity(service.createStock(stock)).build();
    }

    @Path("increaseStock")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response increaseStock(Stock stock) {
        int quantity = stock.getQuantity();
        String bookId = stock.getBookId();
        return Response.status(Response.Status.OK).entity(service.increaseStock(quantity, bookId)).build();
    }

    @Path("decreaseStock")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response decreaseStock(Stock stock) {
        return Response.status(Response.Status.OK).entity(service.decreaseStock(stock.getQuantity(), stock.getBookId())).build();
    }

    @Path("checkStock/{bookId}/{quantity}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response checkStock(@PathParam("bookId") String bookId, @PathParam("quantity") String quantity) {
        return Response.status(Response.Status.OK).entity(stringJson(service.checkStock(bookId, Integer.parseInt(quantity)))).build();
    }

    private String stringJson(Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(StockResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
