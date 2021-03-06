package com.unicorn.common;

public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty () {
        return size == 0;
    }

    /**
     * 插入末尾
     * @param value 插入值
     */
    public void  add (E value) {
        addTo(size, value);
    }

    /**
     * 插入指定位置
     * @param index 插入位置索引
     * @param value 插入值
     */
    public void  addTo (int index, E value) {
        if (size == data.length){
            // 扩容
            resize(size * 2);
        }
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >=0 and index <= size");
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
        size++;
    }

    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public E get (int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("索引越界");
        return data[index];
    }

    public void set (int index, E value) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("索引越界");
        data[index] = value;
    }

    public boolean contains(E value){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value))
                return true;
        }
        return false;
    }

    public int find(E value){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value))
                return i;
        }
        return -1;
    }

    public E remove(int index){
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("索引越界");
        E res = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        return res;

    }

    public E  removeFirst () {
        return remove(0);
    }

    public E  removeLast () {
        return remove(size-1);
    }

    public void  removeElement (E value) {
        int index = find(value);
        if (index != -1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d ", size, data.length));
        res.append("value = [");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size -1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
