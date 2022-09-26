/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorefrontend.client;

import com.bookstore.bookstorefrontend.employee.Employee;
import com.bookstore.bookstorefrontend.stock.RestClientStock;
import com.bookstore.bookstorefrontend.stock.Stock;
import com.bookstore.bookstorefrontend.stock.StockServiceInt;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Vijay
 */
@WebServlet(name = "ClientController", urlPatterns = {"/ClientController"})

public class ClientController extends HttpServlet {

    private ClientServiceInt service;

    public ClientController() {
        service = new RestClient_Client();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("submit")) {

            case "ADD CLIENT":
                if(request.getParameter("password").equals(request.getParameter("confirmPassword"))){
                Client client = new Client();
                client.setName(request.getParameter("name"));
                client.setSurname(request.getParameter("surname"));
                client.setEmail((request.getParameter("email")));
                client.setPassword(request.getParameter("password"));
                String clientId = service.createClient(client);
                request.getSession(false).setAttribute("client", clientId);
                RequestDispatcher rd = request.getRequestDispatcher("PhysicalOrPDF.jsp");
                rd.forward(request, response);
                }
                else{
                    RequestDispatcher rd = request.getRequestDispatcher("RegisterClient.jsp");
                    request.setAttribute("id", "Your password did not match your confirm password");
                rd.forward(request, response);
                }
                break;
            case "LOG IN CLIENT":
                     String email = request.getParameter("email");
                Client client = service.getClient(email);
                if(client.getPassword().equals(request.getParameter("password"))){
                                request.getSession(false).setAttribute("client", client.getClientId());

                RequestDispatcher rd = request.getRequestDispatcher("PhysicalOrPDF.jsp");
             
                rd.forward(request, response);
                }
                else{
                RequestDispatcher rd = request.getRequestDispatcher("LoginClient.jsp");
                request.setAttribute("failure", "Your login details were incorrect");
                                rd.forward(request, response);
                }
                break;
        }
    }
}
