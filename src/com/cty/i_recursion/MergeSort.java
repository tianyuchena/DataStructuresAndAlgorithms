package com.cty.i_recursion;

/**
 * @Auther: cty
 * @Date: 2020/5/8 16:50
 * @Description: 归并排序
 * 时间复杂度分析：
 *      假设复制和比较是最费时的操作，递归的调用和返回不增加额外的开销。
 *      复制次数：N*log2(N)
 *      比较次数：N*log2(N)/2 ~ N*log2(N)
 *      大O表示法：O(N*logN)
 * @version: 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int maxSize = 100;
        Array arr = new Array(maxSize);

        arr.insert(64);
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(108);
        arr.insert(36);

        arr.display();

        arr.mergeSort();

        arr.display();
    }  // end method main

    /**
     * 64 21 33 70 12 85 44 3 99 0 108 36
     * 0 3 12 21 33 36 44 64 70 85 99 108
     */

}  // end class MergeSort

class Array
{
    private long[] a;
    private int nElems;

    public Array(int maxSize)
    {
        a = new long[maxSize];
        nElems = 0;
    }

    public boolean isEmpty()
    {
        return (nElems == 0);
    }

    public boolean isFull()
    {
        return (nElems == a.length);
    }

    public void insert(long value)
    {
        if(!isFull())
            a[nElems++] = value;
    }

    public void display()
    {
        for(int i=0; i<nElems; i++)
            System.out.print(a[i] + " ");
        System.out.println("");
    }

    /**
     * 归并排序 用户接口
     */
    public void mergeSort()
    {
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems-1);
    }

    /**
     * 归并排序 递归实现
     * @param workSpace
     * @param lowerBound
     * @param upperBound
     */
    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound)
    {
        if(lowerBound == upperBound)
            return;
        else
        {
            int mid = (lowerBound + upperBound) / 2;

            recMergeSort(workSpace, lowerBound, mid);

            recMergeSort(workSpace, mid+1, upperBound);

            merge(workSpace, lowerBound, mid+1, upperBound);
        }
    }

    /**
     * 将两个有序数组合并
     * @param workSpace
     * @param lowerBound
     * @param highPtr
     * @param upperBound
     */
    private void merge(long[] workSpace, int lowerBound, int highPtr, int upperBound)
    {
        int lowPtr = lowerBound;
        int mid = highPtr-1;
        int n = upperBound - lowerBound + 1;
        int j = 0;

        while(lowPtr<=mid && highPtr<=upperBound)
            if(a[lowPtr] < a[highPtr])
                workSpace[j++]  = a[lowPtr++];
            else
                workSpace[j++] = a[highPtr++];

        while(lowPtr <= mid)
            workSpace[j++] = a[lowPtr++];

        while(highPtr <= upperBound)
            workSpace[j++] = a[highPtr++];

        for(j=0; j<n; j++)
            a[lowerBound+j] = workSpace[j];
    }

}  // end class Array
