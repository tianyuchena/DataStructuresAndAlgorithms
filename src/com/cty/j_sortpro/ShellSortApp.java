package com.cty.j_sortpro;

/**
 * @Auther: cty
 * @Date: 2020/5/11 21:00
 * @Description: 希尔排序
 * @version: 1.0
 */
public class ShellSortApp {
    public static void main(String[] args) {
        int maxSize = 10;
        ListShellSort list = new ListShellSort(maxSize);

        for(int i=0; i<maxSize; i++)
            list.insert((long)(Math.random()*99));
        list.display();

//        list.insertSort();
        list.shellSort();
        list.display();

    }  // end method main

    /** 第一行是随机序列（每次运行都不同），第二行是排序后的序列
     * 80 19 86 95 8 5 91 14 78 4
     * 4 5 8 14 19 78 80 86 91 95
     */

}  // end class ShellSortApp

class ListShellSort
{
    private long[] arr;
    private int nElems;

    public ListShellSort(int maxSize)
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
     * 插入排序
     */
    public void insertSort()
    {
        int out, in;
        long temp;
        for(out=1; out<nElems; out++){
            temp = arr[out];
            in = out;
            while(in>0 && arr[in-1]>temp){
                arr[in] = arr[in-1];
                in--;
            }
            arr[in] = temp;
        }
    }

    /**
     * 希尔排序
     * 时间复杂度分析：
     *      理论上难分析，主要来自于试验评估
     *      N^(7/6) ~ N^(3/2)
     * 起因：
     *      初始时若一个比较小的数靠近序列的尾部，由于是一步一步的比较移动，因此使用插入排序会移动（或复制）很多次。
     *      解决：开始时先使用比较大的步子排序使序列“基本有序”，最后再使用插入排序——希尔排序
     * 间隔（步子）：
     *      选择：间隔序列中的数字互质很重要，可以使每一趟排序更有可能保持前一趟已排好的效果。
     *      常用：h = h*3 + 1
     */
    public void shellSort()
    {
        int out, in, h;
        long temp;

        h = 1;
        while(h <= nElems/3)
            h = h*3+1;

        while(h>0){
            for(out=h; out<nElems; out++)
            {
                temp = arr[out];
                in = out;
                while(in>h-1 && arr[in-h]>=temp){
                    arr[in] = arr[in-h];
                    in -= h;
                }
                arr[in] = temp;
            }
            h = (h-1)/3;
        }
    }



}  // end class ListShellSort
