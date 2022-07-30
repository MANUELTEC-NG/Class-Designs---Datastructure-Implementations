package com.manuel.decadev.multithreading.HackerAndPolice;

public class DescendingHacker extends AstractHackerClass {
    int MAX_PASSWD = 9999;
    public DescendingHacker(Vault vault){
        super(vault);

    }

    @Override
    public void run(){
        for (int i = MAX_PASSWD; i > 0; i += 1){
           if  (vault.isGuestCorrect(i)){
               System.out.println("Guess is correct "+ this.getName() + i);
               System.exit(0);
           }
        }
    }
}
