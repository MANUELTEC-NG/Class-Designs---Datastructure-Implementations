package com.manuel.decadev.multithreading.HackerAndPolice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultiThread {
    static int MAX_PASSWD = 9999;
    public static void main(String[] args) throws InterruptedException {
        // thread can be start by instantiating the thread object
        // and passing in Runnable object
        Random rand = new Random();
        Vault vault = new Vault(rand.nextInt(MAX_PASSWD));
        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHack(vault));
        threads.add(new DescendingHacker(vault));
        threads.add(new PoliceThread());

        for (Thread thread : threads){
            thread.start();
        }

    }
}
