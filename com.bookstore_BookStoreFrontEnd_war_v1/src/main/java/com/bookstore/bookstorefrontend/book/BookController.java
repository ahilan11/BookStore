/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorefrontend.book;

import com.bookstore.bookstorefrontend.stock.RestClientStock;
import com.bookstore.bookstorefrontend.stock.Stock;
import com.bookstore.bookstorefrontend.stock.StockServiceInt;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Vijay
 */
@WebServlet(name = "BookController", urlPatterns = {"/BookController"})

public class BookController extends HttpServlet {

    private BookServiceInt service;
    private StockServiceInt serviceStock;
    public BookController() {
        service = new RestClientBook();
        serviceStock= new RestClientStock();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("submit")) {

            case "ADD BOOK":
                Book book = new Book();
                book.setTitle(request.getParameter("title"));
                book.setPrice(Double.parseDouble(request.getParameter("price")));
                book.setAuthor(request.getParameter("author"));
                book.setDescription(request.getParameter("description"));
               book.setLocation(request.getParameter("location"));
               String id =  service.createBook(book);
               Stock stock = new Stock();
               stock.setBookId(id);
               stock.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                serviceStock.createStock(stock);
                RequestDispatcher rd = request.getRequestDispatcher("MainMenu.jsp");
                rd.forward(request, response);
                break;
                
            case "DISPLAY ALL BOOKS":
                List<Book> books = service.getAllBooks();
                RequestDispatcher rdi = request.getRequestDispatcher("DisplayAllBooks.jsp");
                request.setAttribute("books", books);
                rdi.forward(request, response);
                break;
                
           
        }
    }
}
