/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.resources;

import com.bookstore.bookstorebackend.client.Client;
import com.bookstore.bookstorebackend.client.ClientService;
import com.bookstore.bookstorebackend.client.ClientServiceInt;
import com.bookstore.bookstorebackend.employee.Employee;
import com.bookstore.bookstorebackend.employee.EmployeeService;
import com.bookstore.bookstorebackend.employee.EmployeeServiceInt;
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

@Path("employee")

public class EmployeeResource {

    private EmployeeServiceInt service;

    public EmployeeResource() {
        service = new EmployeeService();
    }

    @Path("createEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createEmployee(Employee employee) {
        return Response.status(Response.Status.OK).entity(service.createEmployee(employee)).build();
    }
    
    @Path("getEmployee/{employeeId}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getEmployee(@PathParam("employeeId")String employee) {
        return Response.status(Response.Status.OK).entity(service.getEmployee(employee)).build();
    }
}