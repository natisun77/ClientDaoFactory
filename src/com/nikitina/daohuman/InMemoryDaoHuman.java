package com.nikitina.daohuman;

import com.nikitina.di.Component;
import com.nikitina.model.Human;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryDaoHuman implements DaoHuman {
    private static final List<Human> IN_MEMORY_STORAGE = new ArrayList<>();

    @Override
    public void save(Human human) {
        IN_MEMORY_STORAGE.add(human);
    }

    @Override
    public Human get() {
        return IN_MEMORY_STORAGE.get(0);
    }
}
