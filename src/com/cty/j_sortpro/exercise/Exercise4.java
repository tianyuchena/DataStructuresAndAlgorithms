package com.cty.j_sortpro.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/13 21:00
 * @Description: P275-T7.4 通过划分查找数组中第 k 小的数据项（k从1开始）
 * @version: 1.0
 */
class FindKInApp {
    public static void main(String[] args) {
        int maxSize = 2;
        ListFindK list = new ListFindK(maxSize);

        for(int i=0; i<maxSize; i++)
            list.insert((long)(Math.random()*99));
        list.display();

        int K = 1;
        long KV = list.findK(K);
        System.out.println("第" + K + "小值为：" + KV);

    }  // end method main

    /**
     * * * 10个数据项
     * 75 35 90 46 82 16 78 0 98 59
     * 第6小值为：75
     *
     * 62 78 76 46 61 21 15 39 90 36
     * 第2小值为：21
     *
     * 18 60 93 65 61 12 56 97 71 53
     * 第1小值为：12
     *
     *
     * * * 3个数据项
     * 20 76 47
     * 第3小值为：76
     *
     * 77 76 2
     * 第2小值为：76
     *
     * 38 16 53
     * 第1小值为：16
     *
     *
     * * * 2个数据项
     * 71 42
     * 第2小值为：71
     *
     * 61 84
     * 第1小值为：61
     *
     *
     * * * 1个数据项
     * 76
     * 第1小值为：76
     *
     */

}  // end class PartitionApp

class ListFindK
{
    private long[] arr;
    private int nElems;

    public ListFindK(int maxSize)
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
     * 查找数组中第 k 小值（k从1开始）
     * @return
     */
    public long findK(int k)
    {
        return recFindKIn(k-1, 0, nElems-1);
    }

    /**
     * 递归查找数组中第 kIn+1 小值
     * @param kIn
     * @param left
     * @param right
     * @return
     */
    public long recFindKIn(int kIn, int left, int right)
    {
        int partitionIn = partition(left, right);
        if(partitionIn == kIn)
            return arr[kIn];
        else if(partitionIn > kIn)
            return recFindKIn(kIn, left, partitionIn-1);
        else  // partitinIn < medianIn
            return recFindKIn(kIn, partitionIn+1, right);
    }

}  // end class ListPartition
