package com.cty.e_queuearray;

/**
 * @Auther: cty
 * @Date: 2020/4/30 17:14
 * @Description: 优先级队列
 * @version: 1.0
 */
public class PriorityQLongArray {
    private int maxSize;
    private long[] priorityQArray;
    private int nElems;

    public PriorityQLongArray(int maxSize){
        this.maxSize = maxSize;
        priorityQArray = new long[maxSize];
        nElems = 0;
    }

    public boolean isEmpty(){
        return (nElems == 0);
    }

    public boolean isFull(){
        return (nElems == maxSize);
    }

    public void insert(long value){
        if(isFull())
            System.out.println("插入失败-优先级队列已满");
        else{
            if(isEmpty())
                priorityQArray[nElems++] = value;
            else{
                int i;
                for(i=nElems-1; i>=0; i--){
                    if(value > priorityQArray[i])
                        priorityQArray[i+1] = priorityQArray[i];
                    else
                        break;
                }  // end for
                priorityQArray[i+1] = value;
                nElems++;
            }  // end else
        }  // end else
    }  // end method insert

    public long remove(){
        if(isEmpty()){
            System.out.println("删除失败-优先级队列为空");
            return -1;
        }else
            return priorityQArray[--nElems];
    }  // end method remove

    public long peekMin(){
        if(isEmpty()){
            System.out.println("查看失败-优先级队列为空");
            return -1;
        }else
            return priorityQArray[nElems-1];
    }  // end method peekMin

}  // end class PriorityQArray

class PriorityQApp{
    public static void main(String[] args){
        PriorityQLongArray PQ = new PriorityQLongArray(5);
        PQ.insert(30);
        PQ.insert(50);
        PQ.insert(10);
        PQ.insert(40);
        PQ.insert(20);
        PQ.insert(90);

        while(!PQ.isEmpty()){
            System.out.print(PQ.remove()+" ");
        }  // end while
        System.out.println("");

    }  // end method main

}  // end class PriorityQApp