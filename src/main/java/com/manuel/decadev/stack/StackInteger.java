package com.manuel.decadev.stack;

public class StackInteger {
    private int[] ints = new int[10];
    private int size = ints.length;
    private int index = 0;

    public StackInteger(){
        //ints = new int[10];
        this(10);
    }

    public StackInteger (int capacity){
        ints = new int[capacity];
    }

    // Return the top element from the stack
    public int peek(){
        return ints[size-1];
    }

    public void fill(){
        // iterate and keep adding int to the int array until capacity reached
        for (int i = 0; i < size; i++) {
            ints[i] = i + 1;
            index += 1;
        }
    }

    public void push(int val){
        int newCapacity = 0;

        if(ints.length == size){
           newCapacity = ints.length * 2;
           index = 0;

           int[] tempArray = new int[ints.length];

           for(int i = 0; i < ints.length; i += 1){
               tempArray[i] = ints[i];
           }
           ints = new int[newCapacity];
           for (int i = 0; i < tempArray.length; i += 1){
               ints[i] = tempArray[i];
               index += 1;
           }
           // System.out.println("Index" + index);
            size = ints.length;
        }

        ints[index] = val;

   // displayRes(ints[size - 1], "Added : ");
    }

    private void displayRes(int v, String msg) {
        System.out.print(msg);
        System.out.println(v);
    }

    public int pop(){
    int popVal =  ints[size - 1];
    ints[size-1] = '\0';
    size -= 1;
    return popVal;
    }

    public int get(int index){
        return ints[index];
    }

    public int getSize(){
        return this.size;
    }

}
