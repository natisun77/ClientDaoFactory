package com.nikitina.daohuman;

import com.nikitina.model.Human;

public interface DaoHuman {

    void save (Human human);

    Human get ();
}
