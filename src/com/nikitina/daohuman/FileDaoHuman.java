package com.nikitina.daohuman;

import com.nikitina.di.Component;
import com.nikitina.model.Human;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@Component
public class FileDaoHuman implements DaoHuman {

    @Override
    public void save(Human human) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("storageHuman.dat"));) {
            objectOutputStream.writeObject(human);
        } catch (IOException e) {
            System.out.println("Human was not added to file.");
        }
    }

    @Override
    public Human get() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("storageHuman.dat"));) {
            return (Human) objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println("Human was not found in file");
            return null;
        }
    }
}
