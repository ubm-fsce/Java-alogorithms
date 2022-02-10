package com.adt.ds;

public class Queue {
    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;

    private int nItems;


    public Queue(int maxsize) {
        this.maxSize = maxsize;
        this.queueArray = new long[maxsize];
        front = 0;
        rear = -1;
    }

    public void insert(long l) {
        if(rear==maxSize-1){
            rear=-1;
        }
        rear++;
        queueArray[rear] = l;
        nItems++;
    }

    public void view() {
        System.out.print("[ ");

        for (int i = 0; i < queueArray.length; i++) {
            System.out.print(queueArray[i] + ", ");
        }
        System.out.print("]");
    }

    public long remove() {
        long frontElem = queueArray[front];
        front++;
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return frontElem;
    }

    public long peekFront() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

}
