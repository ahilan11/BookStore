/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.resources;

import com.bookstore.bookstorebackend.book.Book;
import com.bookstore.bookstorebackend.book.BookService;
import com.bookstore.bookstorebackend.book.BookServiceInt;
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
@Path("book")
public class BookResource {

    private BookServiceInt service;

    public BookResource() {
        service = new BookService();
    }

    @Path("createBook")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createBook(Book book) {
        return Response.status(Response.Status.OK).entity(service.createBook(book)).build();
    }

    @Path("getBook/{bookId}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getBook(@PathParam("bookId") String book) {
        return Response.status(Response.Status.OK).entity(service.getBook(book)).build();
    }

    @Path("getAllBooks")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAllBooks() {
        return Response.status(Response.Status.OK).entity(service.getAllBooks()).build();
    }
    @Path("getPdf")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPdf(Book book){
                return Response.status(Response.Status.OK).entity((service.purchasePdf(book))).build();

    }
        private String stringJson(Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(BookResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
