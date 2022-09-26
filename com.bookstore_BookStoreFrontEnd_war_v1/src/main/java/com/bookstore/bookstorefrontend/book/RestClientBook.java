/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorefrontend.book;

import com.bookstore.bookstorefrontend.employee.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vijay
 */
public class RestClientBook implements BookServiceInt {

    private Client client;
    private WebTarget webTarget;
    private ObjectMapper objectMapper;

    public RestClientBook() {
        client = ClientBuilder.newClient();
        objectMapper = new ObjectMapper();
    }

    private String stringJson(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }

    @Override
    public String createBook(Book book) {
        String url = "http://localhost:8080/BookStoreBackEnd/shop/book/createBook";
        client = ClientBuilder.newClient();
        webTarget = client.target(url);
        Response response = null;
        try {
            response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(stringJson(book)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestClientBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response.readEntity(String.class);
    }

    @Override
    public Book getBook(String bookID) {
        Map map = new HashMap();
        map.put("bookId", bookID);
        String url = "http://localhost:8080/BookStoreBackEnd/shop/book/getBook/{bookId}";
        webTarget = client.target(url).resolveTemplates(map);
        Book book = null;

        try {
            book = objectMapper.readValue(webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class),
                    Book.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
         String url = "http://localhost:8080/BookStoreBackEnd/shop/book/getAllBooks";
        webTarget = client.target(url);

        List<Book> books = null;
        try {
            books = Arrays.asList(objectMapper.readValue(webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class), Book[].class));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return books;
    }

    @Override
    public String purchasePdf(Book book) {
String url = "http://localhost:8080/BookStoreBackEnd/shop/book/getPdf";
        client = ClientBuilder.newClient();
        webTarget = client.target(url);
        Response response = null;
        try {
            response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(stringJson(book)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestClientBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response.readEntity(String.class);
    }    }
   

    

