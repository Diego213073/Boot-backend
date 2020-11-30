package com.spring.app.bootbackend.service;

import com.spring.app.bootbackend.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    void createClient(Client client);

    Client findById(String id);

    void deleteClient(String id);

    void deleteAll();


}
