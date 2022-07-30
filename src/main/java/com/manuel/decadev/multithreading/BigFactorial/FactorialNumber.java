package com.manuel.decadev.multithreading.BigFactorial;

import java.math.BigInteger;

public class FactorialNumber extends Thread {
    public long factorialNum;
    boolean isFinished = false;
    private BigInteger result;

    public FactorialNumber(long number){
        this.factorialNum = number;
    }

    public BigInteger calcFactorial(long number){
        BigInteger initResult = BigInteger.ONE;
        for(long i = number; i > 0; i -= 1){
            initResult = initResult.multiply( new BigInteger (Long.toString(i)));
        }
        return initResult;
    }

    public boolean isFinished(){
        return isFinished;
    }

    public BigInteger getResult(){
        return result;
    }

    @Override
    public void run(){
        System.out.println("Running In thread.. "+ currentThread().getName());
        this.result = calcFactorial(factorialNum);
        this.isFinished = true;


    }

}
