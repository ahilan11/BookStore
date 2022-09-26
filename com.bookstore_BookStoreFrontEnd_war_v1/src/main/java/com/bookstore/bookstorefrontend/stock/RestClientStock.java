/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorefrontend.stock;

import com.bookstore.bookstorefrontend.employee.Employee;
import com.bookstore.bookstorefrontend.employee.RestClientEmployee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vijay
 */
public class RestClientStock implements StockServiceInt {
      private Client client;
    private WebTarget webTarget;
    private ObjectMapper objectMapper;

    public RestClientStock() {
        client = ClientBuilder.newClient();
        objectMapper = new ObjectMapper();
    }

    private String stringJson(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }

    @Override
    public String createStock(Stock stock) {
        String url = "http://localhost:8080/BookStoreBackEnd/shop/stock/createStock";
        client = ClientBuilder.newClient();
        webTarget = client.target(url);
        Response response = null;
        try {
            response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(stringJson(stock)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestClientEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response.readEntity(String.class);
    }

    @Override
    public String checkStock(String bookId, Integer quantity) {
        Map map = new HashMap();
        map.put("bookid", bookId);
        map.put("quantity", quantity);
        String url = "http://localhost:8080/BookStoreBackEnd/shop/stock/checkStock/{bookid}/{quantity}";
        webTarget = client.target(url).resolveTemplates(map);
        String message = "";

        try {
            message = objectMapper.readValue(webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class),
                    String.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return message;
    }

    @Override
    public String decreaseStock(Stock stock) {
  String url = "http://localhost:8080/BookStoreBackEnd/shop/stock/decreaseStock";
        client = ClientBuilder.newClient();
        webTarget = client.target(url);
        Response response = null;
        try {
            response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(stringJson(stock)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestClientEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response.readEntity(String.class);    }

    @Override
    public String increaseStock(Stock stock) {
  String url = "http://localhost:8080/BookStoreBackEnd/shop/stock/increaseStock";
        client = ClientBuilder.newClient();
        webTarget = client.target(url);
        Response response = null;
        try {
            response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(stringJson(stock)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestClientEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response.readEntity(String.class);    }
}
