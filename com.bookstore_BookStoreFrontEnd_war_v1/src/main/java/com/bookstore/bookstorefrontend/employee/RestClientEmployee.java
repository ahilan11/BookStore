/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorefrontend.employee;

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
public class RestClientEmployee implements EmployeeServiceInt {

    private Client client;
    private WebTarget webTarget;
    private ObjectMapper objectMapper;

    public RestClientEmployee() {
        client = ClientBuilder.newClient();
        objectMapper = new ObjectMapper();
    }

    private String stringJson(Object o) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(o);
    }

    @Override
    public String createEmployee(Employee employee) {
        String url = "http://localhost:8080/BookStoreBackEnd/shop/employee/createEmployee";
        client = ClientBuilder.newClient();
        webTarget = client.target(url);
        Response response = null;
        try {
            response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(stringJson(employee)));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestClientEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response.readEntity(String.class);
    }

    @Override
    public Employee getEmployee(String employeeID) {
        Map map = new HashMap();
        map.put("employeeID", employeeID);
        String url = "http://localhost:8080/BookStoreBackEnd/shop/employee/getEmployee/{employeeID}";
        webTarget = client.target(url).resolveTemplates(map);
        Employee employee = null;

        try {
            employee = objectMapper.readValue(webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class),
                    Employee.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return employee;
    }
    
}
