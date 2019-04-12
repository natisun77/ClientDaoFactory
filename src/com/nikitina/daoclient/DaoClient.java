package com.nikitina.daoclient;


import com.nikitina.model.Client;

public interface DaoClient {
    void save(Client client);
    Client get();
}
