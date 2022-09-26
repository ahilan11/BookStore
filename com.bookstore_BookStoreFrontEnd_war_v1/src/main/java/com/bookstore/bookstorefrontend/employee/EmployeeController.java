/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorefrontend.employee;

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
@WebServlet(name = "EmployeeController", urlPatterns = {"/EmployeeController"})

public class EmployeeController extends HttpServlet {

    private EmployeeServiceInt service;

    public EmployeeController() {
        service = new RestClientEmployee();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("submit")) {

            case "LOG IN":
                String empID = request.getParameter("employeeId");
                Employee emp = service.getEmployee(empID);
                if (emp.getPassword().equals(request.getParameter("password"))) {

                    RequestDispatcher rd = request.getRequestDispatcher("MainMenu.jsp");
                    HttpSession session = request.getSession();
                    session.setAttribute("employee", emp);
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                    request.setAttribute("failure", "Your login details were incorrect");
                    rd.forward(request, response);
                }
                break;

            case "REGISTER EMPLOYEE":
                if (request.getParameter("confirmPassword").equals(request.getParameter("password"))) {
                    Employee empl = new Employee();
                    empl.setName(request.getParameter("name"));
                    empl.setSurname(request.getParameter("surname"));
                    empl.setPassword(request.getParameter("password"));
                    String pass = service.createEmployee(empl);
                    if (!pass.equalsIgnoreCase("failure")) {
                        RequestDispatcher rd = request.getRequestDispatcher("RegisterEmployee.jsp");
                        request.setAttribute("id", pass);
                        rd.forward(request, response);
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("RegisterEmployee.jsp");
                        request.setAttribute("id", "You new id is: " + pass);

                        rd.forward(request, response);
                    }
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("RegisterEmployee.jsp");
                    request.setAttribute("id", "Your password does not match the confirm password");

                    rd.forward(request, response);
                }
                break;

        }
    }
}
