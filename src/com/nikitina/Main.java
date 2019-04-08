package com.nikitina;

import com.nikitina.di.Injector;
import com.nikitina.handler.ConsoleHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        Injector.injectDependency();
        ConsoleHandler.handle();
    }


}
