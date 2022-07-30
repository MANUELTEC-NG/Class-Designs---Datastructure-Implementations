package com.manuel.decadev.multithreading.HackerAndPolice;

public class PoliceThread extends  Thread{

 public  PoliceThread(){}

    public void run(){
     for (int i = 10; i > 0; i -= 1){
         try {
             Thread.sleep(1000);
         } catch (InterruptedException ie){
             System.out.println("Exception in Police Thread");
         }
         System.out.println(i);

     }
        System.out.println("Game over to you hackers");
     System.exit(0);

    }
}
