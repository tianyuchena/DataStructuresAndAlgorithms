package com.cty.j_sortpro;

/**
 * @Auther: cty
 * @Date: 2020/5/13 10:37
 * @Description: 快速排序
 * @version: 1.0
 */
public class QuickSortApp {
    public static void main(String[] args) {
        int maxSize = 16;
        ListQuickSort list = new ListQuickSort(maxSize);

        for(int i=0; i<maxSize; i++)
            list.insert((long)(Math.random()*99));
        list.display();

        list.quickSort();
        list.display();

    }  // end method main

    /**
     * 71 80 82 81 22 74 84 18 81 8 40 46 83 11 96 9
     * 8 9 11 18 22 40 46 71 74 80 81 81 82 83 84 96
     */

}  // end class QuickSortApp

class ListQuickSort
{
    private long[] arr;
    private int nElems;

    public ListQuickSort(int maxSize)
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
     * 快速排序
     * 时间复杂度分析：
     *      O(N*logN)
     */
    public void quickSort()
    {
//        recQuickSort1(0, nElems-1);
//        recQuickSort2(0, nElems-1);
        recQuickSort(0, nElems-1);
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
                swap(left, right);
            return;
        }
        else
        {
            if(arr[left] > arr[right-1])
                swap(left, right-1);
            if(arr[left] > arr[right])
                swap(left, right);
            if(arr[right-1] > arr[right])
                swap(right-1, right);
        }
    }  // end method manualSort()

    /**
     * 插入排序-小数据规模
     */
    private void insertSort(int left, int right)
    {
        int out, in;
        long temp;

        for(out=left+1; out<=right; out++)
        {
            temp = arr[out];
            in = out;
            while(in>left && arr[in-1] >= temp)
            {
                arr[in] = arr[in-1];
                in--;
            }
            arr[in] = temp;
        }  // end for
    }  // end method insertSort

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
     * 划分 1
     * @param left
     * @param right
     * @return
     */
    private int partition1(int left, int right, long pivot)
    {
        int leftPtr = left-1;
        int rightPtr = right;

        while(true)
        {
            while(arr[++leftPtr] < pivot);  // 找到大于等于pivot的值
            while(rightPtr>left && arr[--rightPtr] > pivot);  // 找到小于等于pivot的值

            if(leftPtr >= rightPtr)  // 指针交叉，停止
                break;
            else
                swap(leftPtr, rightPtr);  // 交换
        }

        swap(leftPtr, right);  // 将枢纽值移到中间
        return leftPtr;  // 返回枢纽值的索引
    }

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
                break;
            else
                swap(leftPtr, rightPtr);  // 交换
        }

        swap(leftPtr, right-1);  // 将枢纽值移到中间
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
            swap(left, center);
        if(arr[left] > arr[right])
            swap(left, right);

        // 将最大值放到right位置
        if(arr[center] > arr[right])
            swap(center, right);

        // 将中值放到right-1位置
        swap(center, right-1);
        // 返回中值
        return arr[right-1];
    }

    /**
     * 递归实现快速排序 1
     *      所有划分-快速排序
     *      枢纽值选择-arr[right]
     * @param left
     * @param right
     */
    private void recQuickSort1(int left, int right)
    {
        if(right-left <= 0)
            return;
        else  // 快速排序处理大划分
        {
            long pivot = arr[right];

            int partition = partition1(left, right, pivot);  // 划分
            recQuickSort1(left, partition-1);  // 左半边递归快速排序
            recQuickSort1(partition+1, right);  // 右半边递归快速排序
        }
    }  // end method recQuickSort

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

    /**
     * 递归实现快速排序 3
     *      大划分-快速排序
     *      小划分-插入排序
     *      枢纽值选择-三数据项取中（arr[left]  arr[(left+right)/2]  arr[right]）
     * @param left
     * @param right
     */
    private void recQuickSort(int left, int right)
    {
        // 插入排序处理小划分
        int cutoff = 9;  // 插入排序处理小划分-切割界限建议为9，随机器、操作系统和编译器而变动
        int size = right - left + 1;
        if(size <= cutoff)
            insertSort(left, right);
        else  // 快速排序处理大划分
        {
            long median = medianOf3(left, right);
            int partition = partition(left, right, median);
            recQuickSort(left, partition-1);
            recQuickSort(partition+1, right);
        }
    }  // end method recQuickSort


}  // end class ListQuickSort
