package com.nikitina.daoclient;

import com.nikitina.di.Component;
import com.nikitina.model.Client;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryDaoClient implements DaoClient {

    private static final List<Client> inMemoryStorage = new ArrayList<>();

    @Override
    public void save(Client client) {
        inMemoryStorage.add(client);
    }

    @Override
    public Client get() {
        return inMemoryStorage.get(0);
    }
}
