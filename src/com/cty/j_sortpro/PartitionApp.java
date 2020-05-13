package com.cty.j_sortpro;

/**
 * @Auther: cty
 * @Date: 2020/5/11 21:00
 * @Description: 划分
 * @version: 1.0
 */
public class PartitionApp {
    public static void main(String[] args) {
        int maxSize = 10;
        ListPartition list = new ListPartition(maxSize);

        for(int i=0; i<maxSize; i++)
            list.insert((long)(Math.random()*99));
        list.display();

        int pivot = 50;
        int partDex = list.partition(0, list.size()-1, pivot);
        System.out.println("Pivot is " + pivot + ", Partition is at index " + partDex);
        list.display();

    }  // end method main

    /**
     * 22 28 63 29 62 60 67 50 7 26
     * Pivot is 50, Partition is at index 6
     * 22 28 26 29 7 50 67 60 62 63 
     */

}  // end class PartitionApp

class ListPartition
{
    private long[] arr;
    private int nElems;

    public ListPartition(int maxSize)
    {
        arr = new long[maxSize];
        nElems = 0;
    }

    public int size()
    {
        return nElems;
    }

    public boolean isEmpty()
    {
        return (nElems == 0);
    }

    public boolean isFull()
    {
        return (nElems == arr.length);
    }

    public void display()
    {
        for(int i=0; i<nElems; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    public boolean insert(long value)
    {
        if(isFull())
            return false;
        else
        {
            arr[nElems] = value;
            nElems++;
            return true;
        }
    }

    /**
     * 交换数组中索引为a和b的值
     * @param a
     * @param b
     */
    public void swap(int a, int b)
    {
        long temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 划分：在数组索引为[left, right]的区间内将小于pivot的值放到左边，大于pivot的值放到右边
     * @param left
     * @param right
     * @param pivot
     * @return 返回第一个大于pivot的值的索引
     * 时间复杂度分析：
     *      比较： N+1 或 N+2次
     *      交换： 小于 N/2
     */
    public int partition(int left, int right, long pivot)
    {
        int leftPtr = left-1;
        int rightPtr = right+1;

        while(true)
        {
            while(leftPtr<right && arr[++leftPtr]<pivot);  // 找到大于pivot的索引

            while(rightPtr>left && arr[--rightPtr]>pivot);  // 找到小于pivot的索引

            if(leftPtr >=  rightPtr)  // 索引交叉
                break;
            else
                swap(leftPtr, rightPtr);
        }
        return leftPtr;
    }  // end method partition

}  // end class ListPartition
