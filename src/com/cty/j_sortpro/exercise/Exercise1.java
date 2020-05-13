package com.cty.j_sortpro.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/13 21:00
 * @Description: P275-T7.1
 * @version: 1.0
 */
class PartitionApp {
    public static void main(String[] args) {
        int maxSize = 1;
        ListPartition list = new ListPartition(maxSize);

        for(int i=0; i<maxSize; i++)
            list.insert((long)(Math.random()*99));
        list.display();

        int partDex = list.partition(0, list.size()-1);
        System.out.println("Partition is at index " + partDex);
        list.display();

    }  // end method main

    /**
     * * * 10个数据项
     * 48 80 67 48 5 3 3 50 51 33
     * Partition is at index 3
     * 3 3 5 33 67 80 48 50 51 48
     *
     * * * 3个数据项
     * 20 75 51
     * Partition is at index 1
     * 20 51 75
     *
     * * * 2个数据项
     * 97 37
     * Partition is at index 0
     * 37 97
     *
     * 38 91
     * Partition is at index 1
     * 38 91
     *
     * * * 1个数据项
     * 85
     * Partition is at index 0
     * 85
     *
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
     * 划分：
     * @param left
     * @param right
     * @return 返回第一个大于pivot的值的索引
     * 时间复杂度分析：
     *      比较： N+1 或 N+2次
     *      交换： 小于 N/2
     */
    public int partition(int left, int right)
    {
        int size = right - left + 1;
        long pivot = arr[right];

        if(size <= 1)
            return right;
        else if(size == 2)
        {
            if(arr[left] > pivot)
            {
                swap(left, right);
                return left;
            }
            return right;
        }
        else
        {
            int leftPtr = left-1;
            int rightPtr = right;

            while(true)
            {
                while(arr[++leftPtr]<pivot);  // 找到大于pivot的索引

                while(rightPtr>left && arr[--rightPtr]>pivot);  // 找到小于pivot的索引

                if(leftPtr >=  rightPtr)  // 索引交叉
                    break;
                else
                    swap(leftPtr, rightPtr);
            }
            swap(leftPtr, right);
            return leftPtr;

        }  // end else
    }  // end method partition

}  // end class ListPartition
