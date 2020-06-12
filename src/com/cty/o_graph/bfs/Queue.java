package com.cty.o_graph.bfs;

/**
 * @Auther: cty
 * @Date: 2020/6/10 22:22
 * @Description:
 * @version: 1.0
 */
public class Queue {
    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nElems;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        queArray = new int[this.maxSize];
        front = 0;
        rear = -1;
        nElems = 0;
    }

    public boolean isEmpty(){
        return (nElems == 0);
    }

    public boolean isFull(){
        return (nElems == maxSize);
    }

    public int size()
    {
        return nElems;
    }

    public boolean insert(int j){
        if(isFull())
            return false;

        rear = (rear + 1) % maxSize;
        queArray[rear] = j;
        nElems++;
        return true;
    }

    public int remove(){
        if(isEmpty())
            return -1;

        int temp = queArray[front];
        front = (front + 1) % maxSize;
        nElems--;
        return temp;
    }

}  // end Queue{}
