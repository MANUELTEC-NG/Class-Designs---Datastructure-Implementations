package com.manuel.decadev.stack;

public  class TestStackInteger {

    public static void main(String[] args) {
        StackInteger stack = new StackInteger();
        stack.fill();
//        System.out.println(stack.getSize());
//        System.out.println(stack.peek(4));
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        System.out.println(stack.getSize());

        stack.push(873);
        System.out.println(stack.get(10));
        System.out.println(stack.getSize());
    }


}
