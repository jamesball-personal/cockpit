package com.jamesball.cockpit.runner;

import org.springframework.boot.CommandLineRunner;

public class CockApplicationRunner implements CommandLineRunner {

    public CockApplicationRunner() {};

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started ..");
    }

}
