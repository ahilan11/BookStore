/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.bookstorebackend.client;

import com.bookstore.bookstorebackend.id.IdGen;
import java.util.List;

/**
 *
 * @author Vijay
 */
public class ClientService implements ClientServiceInt {

    private ClientDao dao;
    private IdGen idGenerator;

    public ClientService() {
        dao = new ClientDao();
        idGenerator = new IdGen();
    }

    @Override
    public String createClient(Client client) {

        client.setClientId(idGenerator.genIdLength12());
        return dao.createClient(client) ? client.getClientId() : "failure";
    }
    
    @Override
    public List<Client> getAllClients(){
        return dao.getAllClients();
    }

    @Override
    public Client getClient(String email) {
return dao.getClient(email);
    }

}
