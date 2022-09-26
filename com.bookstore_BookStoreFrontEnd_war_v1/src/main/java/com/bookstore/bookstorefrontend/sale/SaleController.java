/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorefrontend.sale;

import com.bookstore.bookstorefrontend.book.Book;
import com.bookstore.bookstorefrontend.book.BookServiceInt;
import com.bookstore.bookstorefrontend.book.RestClientBook;
import com.bookstore.bookstorefrontend.employee.Employee;
import com.bookstore.bookstorefrontend.employee.EmployeeServiceInt;
import com.bookstore.bookstorefrontend.employee.RestClientEmployee;
import com.bookstore.bookstorefrontend.stock.RestClientStock;
import com.bookstore.bookstorefrontend.stock.Stock;
import com.bookstore.bookstorefrontend.stock.StockServiceInt;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Vijay
 */
@WebServlet(name = "SaleController", urlPatterns = {"/SaleController"})

public class SaleController extends HttpServlet {

    private BookServiceInt serviceBook;
    private SaleServiceInt serviceSale;
    private StockServiceInt serviceStock;
    private SaleLineItemServiceInt serviceSaleLineItem;

    public SaleController() {
        serviceBook = new RestClientBook();
        serviceSale = new RestClientSale();
        serviceStock = new RestClientStock();
        serviceSaleLineItem = new RestClientSaleLineItem();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("submit")) {

            case "ADD TO CART":
                if (request.getSession(false).getAttribute("salelineitem") == null) {
                    Map salelineitem = new HashMap();
                    request.getSession(false).setAttribute("salelineitem", salelineitem);
                }
                String bookID = request.getParameter("bookId");
                Book book = serviceBook.getBook(bookID);
                Map map = (Map) request.getSession(false).getAttribute("salelineitem");
                String quantity = (request.getParameter("quantity"));
                String success = serviceStock.checkStock(bookID, Integer.parseInt(quantity));
                if (success.equals("success")) {
                    Iterator<Map.Entry<Book, String>> itrr = map.entrySet().iterator();
                    int oldQuantity = 0;

                    while (itrr.hasNext()) {
                        Map.Entry<Book, String> entry = itrr.next();
                        if (entry.getKey().getBookId().equals(bookID)) {
                            oldQuantity = Integer.parseInt(entry.getValue());
                            itrr.remove();
                        }

                    }
                    quantity = (Integer.parseInt(quantity) + oldQuantity) + "";
                    map.put(book, quantity);
                    RequestDispatcher rd = request.getRequestDispatcher("NewSale.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("NewSale.jsp");
                    request.setAttribute("failure", "Could not add the amount of stock selected to your cart");
                    rd.forward(request, response);
                }
                break;
            case "MAKE SALE":
                Sale sale = new Sale();
                Employee emp = (Employee) request.getSession(false).getAttribute("employee");
                sale.setClientId((String) request.getSession(false).getAttribute("client"));
                sale.setEmployeeId(emp.getEmployeeId());
                String saleID = serviceSale.createSale(sale);
                Map salelineitems = (Map) request.getSession(false).getAttribute("salelineitem");
                Iterator<Map.Entry<Book, String>> itr = salelineitems.entrySet().iterator();

                while (itr.hasNext()) {
                    Map.Entry<Book, String> entry = itr.next();
                    SaleLineItem c = new SaleLineItem();
                    c.setBookId(entry.getKey().getBookId());
                    c.setQuantity(Integer.parseInt(entry.getValue()));
                    c.setSaleId(saleID);
                    Stock stock = new Stock();
                    stock.setQuantity(Integer.parseInt(entry.getValue()));
                    stock.setBookId(entry.getKey().getBookId());
                    String t = serviceStock.decreaseStock(stock);
                    String v = serviceSaleLineItem.createItem(c);
                    
                }
                RequestDispatcher rda = request.getRequestDispatcher("MainMenu.jsp");
                request.getSession(false).setAttribute("salelineitem", null);
                rda.forward(request, response);
                break;
            case "REMOVE ITEM/S":
                if (request.getSession(false).getAttribute("salelineitem") != null) {

                    Map removeMap = (Map) request.getSession(false).getAttribute("salelineitem");
                    Iterator<Map.Entry<Book, String>> it = removeMap.entrySet().iterator();
                    Book aBook = null;
                    String quan = request.getParameter("quantity");

                    while (it.hasNext()) {
                        Map.Entry<Book, String> entry = it.next();
                        if (entry.getKey().getBookId().equals(request.getParameter("bookId"))) {
                            aBook = entry.getKey();
                            int oldQuantity = Integer.parseInt(entry.getValue());
                            quan = (oldQuantity - Integer.parseInt(quan)) + "";
                        }
                    }

                    removeMap.remove(aBook);
                    if (Integer.parseInt(quan) > 0) {
                        removeMap.put(aBook, quan);
                    }
                    request.getSession(false).setAttribute("salelineitem", removeMap);
                }
                RequestDispatcher rdi = request.getRequestDispatcher("NewSale.jsp");
                rdi.forward(request, response);
                break;
            case "ADD PDF TO CART":
                if (request.getSession(false).getAttribute("salelineitemList") == null) {
                    List salelineitem = new ArrayList<Book>();
                    request.getSession(false).setAttribute("salelineitemList", salelineitem);
                }
                String bookId = request.getParameter("bookId");
                Book bookE = serviceBook.getBook(bookId);
                bookE.setLocation(request.getParameter("location"));
                List list = (List<Book>) request.getSession(false).getAttribute("salelineitemList");
                list.add(bookE);
                request.getSession(false).setAttribute("salelineitemList", list);
                RequestDispatcher rd = request.getRequestDispatcher("NewPurchase.jsp");
                rd.forward(request, response);
                break;

            case "PURCHASE PDF/S":
                if (request.getSession(false).getAttribute("salelineitemList") != null) {
                    Sale newSale = new Sale();
                    Employee empl = (Employee) request.getSession(false).getAttribute("employee");
                    newSale.setClientId((String) request.getSession(false).getAttribute("client"));
                    newSale.setEmployeeId(empl.getEmployeeId());
                    String saleId = serviceSale.createSale(newSale);
                    List<Book> listBooks = (List<Book>) request.getSession(false).getAttribute("salelineitemList");
                    for (Book bk : listBooks) {
                        SaleLineItem c = new SaleLineItem();
                        c.setBookId(bk.getBookId());
                        c.setQuantity(0);
                        c.setSaleId(saleId);
                        serviceBook.purchasePdf(bk);
                        String v = serviceSaleLineItem.createItem(c);

                    }
                }

                RequestDispatcher rdt = request.getRequestDispatcher("MainMenu.jsp");
                request.getSession(false).setAttribute("salelineitemList", null);
                request.getSession(false).setAttribute("clientId", null);

                rdt.forward(request, response);
                break;

            case "REMOVE PDF/S":
                if (request.getSession(false).getAttribute("salelineitemList") != null) {
                    String bookI = request.getParameter("bookId");
                    List<Book> books = (List<Book>) request.getSession(false).getAttribute("salelineitemList");
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).getBookId().equals(bookI)) {
                            books.remove(books.remove(i));
                        }
                    }
                    request.getSession(false).setAttribute("salelineitemList", books);
                }

                RequestDispatcher rdtr = request.getRequestDispatcher("NewPurchase.jsp");
                rdtr.forward(request, response);
                break;
        }
    }
}
