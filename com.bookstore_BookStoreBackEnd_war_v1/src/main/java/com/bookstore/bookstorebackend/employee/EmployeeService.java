/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.employee;

import com.bookstore.bookstorebackend.id.IdGen;

/**
 *
 * @author Vijay
 */
public class EmployeeService implements EmployeeServiceInt{
private EmployeeDaoInt dao;
private IdGen idGenerator;
    public EmployeeService(){
        dao = new EmployeeDao();
        idGenerator = new IdGen();
    }
    @Override
    public Employee getEmployee(String employeeId) {
return dao.getEmployee(employeeId) ;
    }

    @Override
    public String createEmployee(Employee employee) {
         employee.setEmployeeId(idGenerator.genIdLength6());
        return dao.createEmployee(employee)?employee.getEmployeeId():"failure";
    }
    
}
