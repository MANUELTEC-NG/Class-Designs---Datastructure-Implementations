package com.manuel.decadev.atm;

import java.util.ArrayList;
import java.util.Scanner;

public class TestATMClass {

    /*(Display the prime factors) Write a program that prompts
    the user to enter a positive integer and
    displays all its smallest factors in decreasing order.
    For example, if the integer is 120, the smallest factors are
    displayed as 5, 3, 2, 2, 2. Use the StackOfIntegers
    class to store the factors (e.g., 2, 2, 2, 3, 5) and
    retrieve and display them in reverse order.

     */


    static ArrayList<ATM> atms = new ArrayList<ATM>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int i = 0;
        int money = 100;

        while (i != 10){
            atms.add(new ATM(money));
            money += 50;
            i += 1;
        }

        System.out.println("Choose an id (Number): 0 - 9");
        int id = input.nextInt();
        while (Character.isLetter(id)) {
            show("Please input a number");
            id = input.nextInt();
        }
        ATM atm = atms.get(id);
        atm.menu();

        show("_____________________________________");

        int option;
        while (true) {
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter Withdrawing Amount");
                    int witdrawalAmount = input.nextInt();
                    atm.withdraw(witdrawalAmount);
                    break;
                case 2:
                    show("Enter the amount");
                    int depositAmount = input.nextInt();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.exit(0);
            }
            show("-------------------------------------------");
            atm.menu();
        }



    }

    private static void show(String msg){
        System.out.println(msg);
    }

}
