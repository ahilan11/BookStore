/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorefrontend.client;

import com.bookstore.bookstorefrontend.book.Book;
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
public class RestClient_Client implements ClientServiceInt {

    private Client client;
    private WebTarget webTarget;
    private ObjectMapper objectMapper;

    public RestClient_Client() {
        client = ClientBuilder.newClient();
        objectMapper = new ObjectMapper();
    }

    private String stringJson(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }

    @Override
    public String createClient(com.bookstore.bookstorefrontend.client.Client client) {
        String url = "http://localhost:8080/BookStoreBackEnd/shop/client/createClient";
        this.client = ClientBuilder.newClient();
        webTarget = this.client.target(url);
        Response response = null;
        try {
            response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(stringJson(client)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestClient_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response.readEntity(String.class);
    }

    @Override
    public List<com.bookstore.bookstorefrontend.client.Client> getAllClients() {
 String url = "http://localhost:8080/BookStoreBackEnd/shop/client/getAllClients";
        webTarget = client.target(url);

        List<com.bookstore.bookstorefrontend.client.Client> clients = null;
        try {
            clients = Arrays.asList(objectMapper.readValue(webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class), com.bookstore.bookstorefrontend.client.Client[].class));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return clients;    }
    
       @Override
    public com.bookstore.bookstorefrontend.client.Client getClient(String email) {
        Map map = new HashMap();
        map.put("email",email);
 String url = "http://localhost:8080/BookStoreBackEnd/shop/client/getClient/{email}";
        webTarget = client.target(url).resolveTemplates(map);

        com.bookstore.bookstorefrontend.client.Client client = null;
        try {
            client = (objectMapper.readValue(webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class), com.bookstore.bookstorefrontend.client.Client.class));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return client;    }

}
