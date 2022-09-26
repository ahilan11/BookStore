/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.employee;

/**
 *
 * @author Vijay
 */
public interface EmployeeServiceInt {
    Employee getEmployee(String employeeId);
    String createEmployee(Employee employee);
}
