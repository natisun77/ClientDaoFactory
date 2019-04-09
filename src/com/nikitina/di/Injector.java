package com.nikitina.di;

import com.nikitina.daohuman.FileDaoHuman;
import com.nikitina.factory.DaoFactory;
import com.nikitina.handler.ConsoleHandler;
import com.nikitina.daoclient.DaoClient;
import com.nikitina.daoclient.FileDaoClient;
import com.nikitina.daoclient.InMemoryDaoClient;
import com.nikitina.daohuman.DaoHuman;
import com.nikitina.daohuman.InMemoryDaoHuman;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class consoleHandlerClass = ConsoleHandler.class;
        Class fileClientDaoClass = FileDaoClient.class;
        Class inMemoryClientDao = InMemoryDaoClient.class;
        Class fileHumanDaoClass = FileDaoHuman.class;
        Class inMemoryHumanDao = InMemoryDaoHuman.class;

        Field[] fields = consoleHandlerClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                if (field.getType() == DaoClient.class) {
                    boolean fileDao = fileClientDaoClass.isAnnotationPresent(Component.class);
                    if (fileDao) {
                        System.out.println("Работа с файлами клиентов разрешена");
                    }
                    boolean inMemoryDao = inMemoryClientDao.isAnnotationPresent(Component.class);
                    if (inMemoryDao) {
                        System.out.println("Работа с ОЗУ клиентов разрешена");
                    }
                    DaoClient clientDao = DaoFactory.getClientDao(fileDao, inMemoryDao);
                    field.set(null, clientDao);
                } else if (field.getType() == DaoHuman.class) {
                    boolean fileDao = fileHumanDaoClass.isAnnotationPresent(Component.class);
                    if (fileDao) {
                        System.out.println("Работа с файлами людей разрешена");
                    }
                    boolean inMemoryDao = inMemoryHumanDao.isAnnotationPresent(Component.class);
                    if (inMemoryDao) {
                        System.out.println("Работа с ОЗУ людей разрешена");
                    }
                    DaoHuman humanDao = DaoFactory.getHumanDao(fileDao, inMemoryDao);
                    field.set(null, humanDao);
                }
            }
        }
    }
}
