package com.cty.g_priorityqarray;

/**
 * @Auther: cty
 * @Date: 2020/5/3 10:57
 * @Description: 优先级队列  无序顶部插入，查找最小删除  P129-T4.4
 * 时间复杂度分析：
 *      insert  O(1)
 *      remove  s = N + N/2  O(N)
 *                 查找 移动
 * 队列实现：
 *      数组
 *      堆
 * 队列的应用：
 * @version: 1.0
 */
public class PriorityQLongArray2 {
    private int maxSize;
    private long[] PQ;
    private int nElems;

    public PriorityQLongArray2(int maxSize)
    {
        this.maxSize = maxSize;
        PQ = new long[maxSize];
        nElems = 0;
    }

    public int size()
    {
        return nElems;
    }

    public void display()
    {
        // 先选择排序
        long[] array = new long[nElems];
        array = PQ;
        int out, in, min;
        for(out=0; out<nElems; out++)
        {
            // 找出每次遍历的最小值
            min = out;
            for(in=out; in<nElems; in++)
                if(array[in] < array[min])
                    min = in;
            // 交换
            long temp = array[out];
            array[out] = array[min];
            array[min] = temp;
        }
        // 显示排序后的数组
        for(int i=0; i<nElems; i++)
            System.out.print(array[i]+" ");
        System.out.println("");
    }  // end method display

    public boolean isEmpty()
    {
        return (nElems==0)?true:false;
    }

    public boolean isFull()
    {
        return (nElems==maxSize)?true:false;
    }

    public boolean insert(long value)
    {
        if(isFull())
            return false;  // 插入失败-队列已满
        else
        {
            PQ[nElems++] = value;
            return true;  // 插入成功
        }
    }

    private int getMinIn()
    {
        if(isEmpty())
            return -1;  // 获取失败-数组为空
        else
        {
            int minIn = 0;
            for(int i=1; i<nElems; i++)
            {
                if(PQ[i] < PQ[minIn])
                    minIn = i;
            }
            return minIn;
        }
    }

    private long removeByIndex(int index)
    {
        if(isEmpty())
            return -1;  // 删除失败-数组为空
        else if(index<0 || index>=nElems)
            return -1; // 删除失败-索引值非法
        else
        {
            int j;
            for(j=index; j<nElems-1; j++)
                PQ[j] = PQ[j+1];
            PQ[j] = 0;  // long类型默认值为0
            nElems--;
            return PQ[index];
        }
    }

    public long remove()
    {
        if(isEmpty())
            return -1;  // 删除失败-队列为空
        else
        {
            if(1 == nElems)
            {
                nElems--;
                return PQ[0];
            }
            else
            {
                int minIn = getMinIn();  // 找到最小值索引
                return removeByIndex(minIn);  // 删除最小值-高位下移
            }  // end else
        }  // end else
    }  // end method remove

    public long peekMin()
    {
        int minIn = getMinIn();  // // 找到最小值索引
        if(-1 == minIn)
            return -1;  // 获取失败-数组为空
        else
            return PQ[minIn];
    }

}  // end class PriorityQLongArray2

class PriorityQApp2{
    public static void main(String[] args){
        PriorityQLongArray2 PQ = new PriorityQLongArray2(5);
        PQ.insert(30);
        PQ.insert(50);
        PQ.insert(10);
        PQ.insert(40);
        PQ.insert(20);
        PQ.insert(90);

        PQ.display();

    }  // end method main

}  // end class PriorityQApp2


