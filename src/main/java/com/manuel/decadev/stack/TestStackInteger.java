package com.manuel.decadev.stack;

import java.util.ArrayList;
import java.util.Scanner;

public class TestStackInteger {
    private String name = "";

    public static void main(String[] args) {
        StackInteger stack = new StackInteger();
        stack.fill();
//        System.out.println(stack.getSize());
//        System.out.println(stack.peek(4));
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());


//        System.out.println(Double.valueOf("23.5").intValue());
//        System.out.println(Integer.valueOf("34", 8));

        numberFactor();
    }

    public static void numberFactor() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> box = new ArrayList<Integer>();
        System.out.println("Input ur no");
        int num = input.nextInt();
        int factor = 2;
        while (!(num <= 1)) {

            if (num % factor != 0) {
                factor += 1;
                continue;
            }
            num /= factor;
            box.add(factor);
        }

//        System.out.println();
    }


}
