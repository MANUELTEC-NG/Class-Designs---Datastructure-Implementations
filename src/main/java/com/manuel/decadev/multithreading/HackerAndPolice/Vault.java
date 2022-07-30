package com.manuel.decadev.multithreading.HackerAndPolice;

public class Vault {
    int vault = 0;
    public Vault( int vault){
        this.vault = vault;
    }

    boolean isGuestCorrect(int guess){
        try {
            Thread.sleep(5);
        } catch (InterruptedException i){
            System.out.println("Something went wrong in the 'guessing method' "  +  i.getMessage());

        }
        return this.vault == guess;
    }
}
