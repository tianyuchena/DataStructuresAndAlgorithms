package com.cty.e_queuearray;

/**
 * @Auther: cty
 * @Date: 2020/4/29 20:27
 * @Description: 长整型数组 循环 队列  有元素个数nElems
 * 时间复杂度分析：
 *      队列的重要操作insert和remove时间复杂度都是O(1)
 * 队列实现：
 *      数组
 *      链表
 * 队列的应用：
 *      打印等待
 *      键入内容等待处理
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

    /**
     * P129-T4.1
     */
    public void display(){
        if(isEmpty())
            System.out.println("显示失败-队列为空");
        else{
            if(rear >= front) {
                for (int i=front; i<=rear; i++)
                    System.out.print(queueArray[i] + " ");
                System.out.println("");
            } else{
                for(int j=front; j<maxSize; j++)
                    System.out.print(queueArray[j] + " ");
                for(int k=0; k<=rear; k++)
                    System.out.print(queueArray[k] + " ");
                System.out.println("");
            }  //end else
        }  // end else

    }  // end method display

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
//            if(rear == maxSize-1)
//                rear = -1;
//            queueArray[++rear] = value;
            rear = (rear + 1) % maxSize;
            queueArray[rear] = value;
            nElems++;
        }  // end else
    }  //end method insert

    public long remove(){
        if(isEmpty()) {
            System.out.println("删除失败-队列为空");
            return -1;
        }else{
//            long temp = queueArray[front++];
//            if(front == maxSize)
//                front = 0;
            long temp = queueArray[front];
            front = (front + 1) % maxSize;
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

//        while(!queue.isEmpty()){
//            System.out.print(queue.remove()+" ");
//        }  // end while
//        System.out.println("");
        queue.display();

    }  // end method main
}  // end class QueueApp

/** 2020年5月1日
 40 50 60 70 80
 */