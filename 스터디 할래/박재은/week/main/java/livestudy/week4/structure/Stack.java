package com.livestudy.week4.structure;

public class Stack {
    private final int[] store;
    private final int maxSize;
    private int size;
    private int DEFAULT_SIZE = 10;

    public Stack() {
        this.store = new int[DEFAULT_SIZE];
        this.maxSize = DEFAULT_SIZE;
        this.size = 0;
    }

    public Stack(int maxSize) {
        this.store = new int[maxSize];
        this.maxSize = maxSize;
        this.size = 0;
    }

    public int pop() {
        if(isEmpty()) throw new RuntimeException("stack is empty");
        return this.store[--this.size];
    }

    public void push(int data) {
        if(isFull()) throw new RuntimeException("stack is full");
        this.store[this.size++] = data;
    }

    public boolean isEmpty() {
        if(this.size == 0 ) return true;
        else return false;
    }

    public boolean isFull() {
        if(maxSize - size < 0 ) return true;
        else return false;
    }
}
