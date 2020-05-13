package com.cty.j_sortpro.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/13 21:00
 * @Description: P275-T7.3 通过划分查找中间值
 *      当为数据项为偶数个时，返回由小到大排列的第 N/2 个值
 *      当数据项为奇数个时，返回由小到大排列的第 [(N-1)/2]+1 个值
 * @version: 1.0
 */
class FindMedianApp {
    public static void main(String[] args) {
        int maxSize = 1;
        ListFindMedian list = new ListFindMedian(maxSize);

        for(int i=0; i<maxSize; i++)
            list.insert((long)(Math.random()*99));
        list.display();

        long median = list.findMedian();
        System.out.println("Median is " + median);

    }  // end method main

    /**
     * * * 10个数据项
     * 31 10 79 25 38 5 66 4 69 60
     * Median is 31
     *
     * * * 9个数据项
     * 61 14 15 83 82 91 46 60 60
     * Median is 60
     *
     * * * 3个数据项
     * 1 45 59
     * Median is 45
     *
     * * * 2个数据项
     * 22 55
     * Median is 22
     *
     * * * 1个数据项
     * 47
     * Median is 47
     *
     */

}  // end class PartitionApp

class ListFindMedian
{
    private long[] arr;
    private int nElems;

    public ListFindMedian(int maxSize)
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
     * 划分
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

    /**
     * 查找序列的中间值
     * @return
     */
    public long findMedian()
    {
        return recFindMedian((nElems-1)/2, 0, nElems-1);
    }

    /**
     * 递归查找中间值
     * @param medianIn
     * @param left
     * @param right
     * @return
     */
    public long recFindMedian(int medianIn, int left, int right)
    {
        int partitionIn = partition(left, right);
        if(partitionIn == medianIn)
            return arr[medianIn];
        else if(partitionIn > medianIn)
            return recFindMedian(medianIn, left, partitionIn-1);
        else  // partitinIn < medianIn
            return recFindMedian(medianIn, partitionIn+1, right);
    }

}  // end class ListPartition
