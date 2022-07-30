package com.manuel.decadev.multithreading.HackerAndPolice;

public class AscendingHack extends AstractHackerClass {
    int MAX_PASSWD = 9999;

    public AscendingHack(Vault vault) {
        super(vault);
    }

    @Override
    public void run(){
        for (int i = 0; i < MAX_PASSWD; i += 1){
            if (vault.isGuestCorrect(i)){
                System.out.println("Guessed Correctly "+ this.getName() +" " + i);
                System.exit(0);
            }
        }
    }
}
