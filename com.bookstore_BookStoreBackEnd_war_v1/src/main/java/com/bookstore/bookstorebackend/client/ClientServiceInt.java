/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.client;

import java.util.List;

/**
 *
 * @author Vijay
 */
public interface ClientServiceInt {
        String createClient(Client client);
List<Client> getAllClients();
Client getClient(String email);
}
