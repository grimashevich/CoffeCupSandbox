package ru.bugbuilders.coffecupsandbox.service;

import org.springframework.stereotype.Service;


@Service
public class CoffeeCupService {
    private int id = 0;


    public int getCoffeeCup() throws InterruptedException {
        Thread.sleep(10000);
        return id++;
    }
}
