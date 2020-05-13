package com.cty.j_sortpro.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/13 10:37
 * @Description: P276-T7.2 显示快速排序的比较次数和复制次数
 * @version: 1.0
 */
class QuickSortApp {
    public static void main(String[] args) {
        int maxSize = 10;
        ListQuickSort list = new ListQuickSort(maxSize);

        for(int i=0; i<maxSize; i++)
            list.insert((long)(Math.random()*99));
        list.display();

        list.quickSort();
        list.display();

        System.out.println("复制次数："+ list.getCount().getCopies());
        System.out.println("比较次数："+ list.getCount().getComparisons());

    }  // end method main

    /**
     * * * 1个数据项
     * 9
     * 9
     * 复制次数：0
     * 比较次数：0
     *
     * * * 2个数据项
     * 76 21
     * 21 76
     * 复制次数：3
     * 比较次数：1
     *
     * 23 87
     * 23 87
     * 复制次数：0
     * 比较次数：1
     *
     * * * 3个数据项
     * 69 79 54
     * 54 69 79
     * 复制次数：6
     * 比较次数：3
     *
     * * * 10个数据项
     * 30 97 59 15 67 6 31 21 35 87
     * 6 15 21 30 31 35 59 67 87 97
     * 复制次数：36
     * 比较次数：28
     */

}  // end class QuickSortApp

class ListQuickSort
{
    private long[] arr;
    private int nElems;
    private Count count;

    public ListQuickSort(int maxSize)
    {
        arr = new long[maxSize];
        nElems = 0;
        count = new Count();
    }

    public Count getCount() {
        return count;
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
     * 快速排序
     */
    public void quickSort()
    {
        recQuickSort2(0, nElems-1);
    }

    /**
     * 交换
     * @param inA
     * @param inB
     */
    private void swap(int inA, int inB)
    {
        long temp = arr[inA];
        arr[inA] = arr[inB];
        arr[inB] = temp;
    }

    /**
     * 手动排序-小数据规模
     */
    private void manualSort(int left, int right)
    {
        int size = right - left + 1;
        if(size <= 1)
            return;
        else if(size == 2)
        {
            if(arr[left] > arr[right])
            {
                swap(left, right);
                count.copiesAdd(3);
            }
            count.comparisonsAdd(1);
            return;
        }
        else
        {
            if(arr[left] > arr[right-1])
            {
                swap(left, right-1);
                count.copiesAdd(3);
            }
            if(arr[left] > arr[right])
            {
                swap(left, right);
                count.copiesAdd(3);
            }
            if(arr[right-1] > arr[right])
            {
                swap(right-1, right);
                count.copiesAdd(3);
            }
            count.comparisonsAdd(3);
        }
    }  // end method manualSort()

    /**
     * 划分
     * @param left
     * @param right
     * @return
     */
    private int partition(int left, int right, long pivot)
    {
        int leftPtr = left;
        int rightPtr = right-1;

        while(true)
        {
            while(arr[++leftPtr] < pivot);  // 找到大于等于pivot的值
            while(arr[--rightPtr] > pivot);  // 找到小于等于pivot的值

            if(leftPtr >= rightPtr)  // 指针交叉，停止
            {
                count.comparisonsAdd((leftPtr-left) + (right-1-rightPtr));
                break;
            }
            else
            {
                swap(leftPtr, rightPtr);  // 交换
                count.copiesAdd(3);
            }
        }

        swap(leftPtr, right-1);  // 将枢纽值移到中间
        count.copiesAdd(3);
        return leftPtr;  // 返回枢纽值的索引
    }

    /**
     * 三数据项取中
     * @param left
     * @param right
     * @return
     */
    private long medianOf3(int left, int right)
    {
        int center = (left + right) / 2;

        // 将最小值放到left位置
        if(arr[left] > arr[center])
        {
            swap(left, center);
            count.copiesAdd(3);
        }
        if(arr[left] > arr[right])
        {
            swap(left, right);
            count.copiesAdd(3);
        }
        // 将最大值放到right位置
        if(arr[center] > arr[right])
        {
            swap(center, right);
            count.copiesAdd(3);
        }
        count.comparisonsAdd(3);

        // 将中值放到right-1位置
        swap(center, right-1);
        count.copiesAdd(3);
        // 返回中值
        return arr[right-1];
    }

    /**
     * 递归实现快速排序 2
     *      大划分-快速排序
     *      小划分-手工排序
     *      枢纽值选择-三数据项取中（arr[left]  arr[(left+right)/2]  arr[right]）
     * @param left
     * @param right
     */
    private void recQuickSort2(int left, int right)
    {
        // 手工排序处理小划分
        int cutoff = 3;  // 手动排序处理小划分-切割界限为3
        int size = right - left + 1;
        if(size <= cutoff)
            manualSort(left, right);
        else  // 快速排序处理大划分
        {
            long pivot = medianOf3(left, right);

            int partition = partition(left, right, pivot);  // 划分
            recQuickSort2(left, partition-1);  // 左半边递归快速排序
            recQuickSort2(partition+1, right);  // 右半边递归快速排序
        }
    }  // end method recQuickSort

}  // end class ListQuickSort

class Count
{
    private int copies;
    private int comparisons;

    public Count()
    {
        copies = 0;
        comparisons = 0;
    }

    public void copiesAdd(int n)
    {
        copies += n;
    }

    public void comparisonsAdd(int n)
    {
        comparisons += n;
    }


    public int getCopies() {
        return copies;
    }

    public int getComparisons() {
        return comparisons;
    }
}
