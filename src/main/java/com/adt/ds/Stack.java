package com.adt.ds;

public class Stack {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new long[maxSize];
        this.top = -1;
    }

    public void push(long j) {
        System.out.println("top : " + top + " : maxSize : " + maxSize);
        if (!isFull()) {
            top++;
            stackArray[top] = j;
        } else {
            System.out.println("OOPS max limit reached");
        }
    }

    public long pop() {
        if (!isEmpty()) {
            int oldTop = top;
            top--;
            return stackArray[oldTop];
        } else {
            System.out.println("The Stack is already Empty");
            return -1;
        }
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return maxSize - 1 == top;
    }
}
