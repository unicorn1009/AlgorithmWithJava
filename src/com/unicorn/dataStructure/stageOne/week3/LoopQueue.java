package com.unicorn.dataStructure.stageOne.week3;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        // 队列是否满
        if ((tail+1)%data.length == front){
            // 扩容
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1)&data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity+1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front+i)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("队列空");

        E ret = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("队列空");

        return data[front];
    }
}
