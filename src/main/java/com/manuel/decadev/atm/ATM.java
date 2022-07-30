package com.manuel.decadev.atm;

public class ATM {
    int initialBalance = 0;
    int newBalance = 0;

    public ATM (){
        this(100);
    }

    public ATM(int holdingBalance){
        initialBalance = holdingBalance;
    }

    public void deposit(int amount){
        initialBalance = initialBalance + amount;
        System.out.println("Successfully Deposited");
        showBalance("Updated Balance is");
    }

    public int withdraw(int amount){
        if (amount <= initialBalance) {
            initialBalance = initialBalance - amount;
            showBalance("Your Balance is");
            return initialBalance;
        }
        System.out.println("Not Enough Balance!");
        return  initialBalance;
    }

    public int checkBalance(){
        showBalance("Your Balance is");
        return initialBalance;
    }

    private void showBalance(String msg){
        System.out.println(msg + ":" + this.initialBalance);
    }

    public void menu(){

        System.out.println("To Withdraw Enter 1: ");
        System.out.println("To Deposit Enter 2: ");
        System.out.println("To Check Balance: 3 ");
        System.out.println("To Exit: 4");
    }
}
