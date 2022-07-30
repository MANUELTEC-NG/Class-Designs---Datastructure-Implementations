package com.manuel.decadev.multithreading.BigFactorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactMain {

    public static void main(String[] args) throws InterruptedException {

       List<Long> longs = Arrays.asList(2428L, 44352L, 0L, 100000L, 9982L);
       List<FactorialNumber> threadsOfFactorials = new  ArrayList<>();

       for (long lNum : longs){
           threadsOfFactorials.add(new FactorialNumber(lNum));

       }

       for (FactorialNumber factInstance : threadsOfFactorials){
          factInstance.setDaemon(true);
           factInstance.start();
          // factInstance.interrupt();
          // Thread.sleep(500);
           factInstance.join(500);

       }
       for(FactorialNumber factorialInstance: threadsOfFactorials){

           try {
               factorialInstance.join();
           } catch (InterruptedException ie){
               System.out.println("Interrupted Exception thrown");
           }


       }

       for (int i = 0; i < longs.size(); i += 1){
          FactorialNumber factObjectInstance = threadsOfFactorials.get(i);
          if (factObjectInstance.isFinished()){
              System.out.println("Factorial of " + longs.get(i) + " "+ "is " +
                      factObjectInstance.getResult());
          } else {
              System.out.println("Calculation for... " + longs.get(i) + " "+
                      " is still in progress");
          }
       }

    }
}
