/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorefrontend.stock;

import com.bookstore.bookstorefrontend.employee.*;
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
@WebServlet(name = "StockController", urlPatterns = {"/StockController"})

public class StockController extends HttpServlet {

    private StockServiceInt service;

    public StockController() {
        service = new RestClientStock();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("submit")) {

            case "ADD STOCK":
                Stock stock = new Stock();
                stock.setBookId(request.getParameter("bookId"));
                stock.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                service.increaseStock(stock);
                RequestDispatcher rd = request.getRequestDispatcher("MainMenu.jsp");
                rd.forward(request, response);
                break;

        }
    }
}
