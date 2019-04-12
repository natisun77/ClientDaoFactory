package com.nikitina.factory;

import com.nikitina.daohuman.FileDaoHuman;
import com.nikitina.service.PropertyLoader;
import com.nikitina.daoclient.DaoClient;
import com.nikitina.daoclient.FileDaoClient;
import com.nikitina.daoclient.InMemoryDaoClient;
import com.nikitina.daohuman.DaoHuman;
import com.nikitina.daohuman.InMemoryDaoHuman;

import java.io.IOException;

public class DaoFactory {

    private static final DaoClient IN_MEMORY_DAO_CLIENT = new InMemoryDaoClient();
    private static final DaoClient FILE_DAO_CLIENT = new FileDaoClient();
    private static final DaoHuman IN_MEMORY_DAO_HUMAN = new InMemoryDaoHuman();
    private static final DaoHuman FILE_DAO_HUMAN = new FileDaoHuman();

    public static DaoClient getClientDao(boolean isFileDao, boolean isInMemoryDao) {
        try {
            String dbName = PropertyLoader.getProperty("db.name");
            if (dbName.equals("memory") && isInMemoryDao) {
                return IN_MEMORY_DAO_CLIENT;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isFileDao) {
            return FILE_DAO_CLIENT;
        } else {
            throw new ComponentNotFoundException();
        }
    }

    public static DaoHuman getHumanDao(boolean isFileDao, boolean isInMemoryDao) {
        try {
            String dbName = PropertyLoader.getProperty("db.name");
            if (dbName.equals("memory") && isInMemoryDao) {
                return IN_MEMORY_DAO_HUMAN;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isFileDao) {
            return FILE_DAO_HUMAN;
        } else {
            throw new ComponentNotFoundException();
        }
    }
}
