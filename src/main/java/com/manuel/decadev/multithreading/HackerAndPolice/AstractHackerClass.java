package com.manuel.decadev.multithreading.HackerAndPolice;

public abstract class AstractHackerClass extends Thread {
    Vault vault;
    public AstractHackerClass(Vault vault){
        this.vault = vault;
        this.setPriority(Thread.MAX_PRIORITY);
        this.setName(this.getClass().getSimpleName());
    }

    @Override
    public void start(){
        System.out.println("Starting...thread  "+ this.getName());
        super.start();
    }

}
