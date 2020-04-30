package com.cty.e_queuearray;

/**
 * @Auther: cty
 * @Date: 2020/4/29 20:27
 * @Description: 长整型数组 循环 队列  有元素个数nElems
 * @version: 1.0
 */
public class QueueLongArray {
    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;
    private int nElems;

    public QueueLongArray(int maxSize){
        this.maxSize = maxSize;
        queueArray = new long[maxSize];
        front = 0;
        rear = -1;
        nElems = 0;
    }

    public int size(){
        return nElems;
    }

    public boolean isEmpty(){
        return (nElems == 0);
    }

    public boolean isFull(){
        return (nElems == maxSize);
    }

    public void insert(long value){
        if(isFull())
            System.out.println("插入失败-队列已满");
        else {
            if(rear == maxSize-1)
                rear = -1;
            queueArray[++rear] = value;
            nElems++;
        }  // end else
    }  //end method insert

    public long remove(){
        if(isEmpty()) {
            System.out.println("删除失败-队列为空");
            return -1;
        }else{
            long temp = queueArray[front++];
            if(front == maxSize)
                front = 0;
            nElems--;
            return temp;
        }  // end else
    }  // end method remove

    public long peek(){
        if(isEmpty()) {
            System.out.println("查看失败-数组为空");
            return -1;
        }else{
            long temp = queueArray[front];
            return temp;
        }  // end else
    }  // end method peek

}  // end class QueueLongArray

class QueueApp{
    public static void main(String[] args){
        QueueLongArray queue = new QueueLongArray(5);

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);

        queue.remove();
        queue.remove();
        queue.remove();

        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);

        while(!queue.isEmpty()){
            System.out.print(queue.remove()+" ");
        }  // end while
        System.out.println("");

    }  // end method main
}  // end class QueueApp
