package com.nikitina.dao;

import com.nikitina.di.Component;
import com.nikitina.model.Client;

import java.io.*;

@Component
public class FileClientDao implements ClientDao {

    public void save(Client client) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("storage.dat"))) {
            objectOutputStream.writeObject(client);
        } catch (IOException e) {
            System.out.println("Не удалось записать клиента в базу");
        }
    }

    public Client get() {
        try (ObjectInputStream inputObjectStream = new ObjectInputStream(new FileInputStream("storage.dat"))) {
            return (Client) inputObjectStream.readObject();
        } catch (Exception e) {
            System.out.println("Клиент не найден в системе");
            return null;
        }
    }
}
