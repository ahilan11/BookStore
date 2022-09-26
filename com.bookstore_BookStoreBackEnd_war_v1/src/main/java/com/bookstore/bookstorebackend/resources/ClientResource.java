/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.resources;

import com.bookstore.bookstorebackend.book.Book;
import com.bookstore.bookstorebackend.book.BookService;
import com.bookstore.bookstorebackend.book.BookServiceInt;
import com.bookstore.bookstorebackend.client.Client;
import com.bookstore.bookstorebackend.client.ClientService;
import com.bookstore.bookstorebackend.client.ClientServiceInt;
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
@Path("client")

public class ClientResource {

    private ClientServiceInt service;

    public ClientResource() {
        service = new ClientService();
    }

    @Path("createClient")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createBook(Client client) {
        return Response.status(Response.Status.OK).entity(service.createClient(client)).build();
    }
    
    @Path("getAllClients")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAllClients() {
        return Response.status(Response.Status.OK).entity(service.getAllClients()).build();
    }
 @Path("getClient/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getClient(@PathParam("email")String email) {
        return Response.status(Response.Status.OK).entity(service.getClient(email)).build();
    }
}
