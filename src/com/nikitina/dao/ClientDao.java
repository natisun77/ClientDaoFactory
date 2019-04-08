package com.nikitina.dao;


import com.nikitina.model.Client;

public interface ClientDao {
    void save(Client client);
    Client get();
}
