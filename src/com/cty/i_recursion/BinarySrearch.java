package com.cty.i_recursion;

/**
 * @Auther: cty
 * @Date: 2020/5/8 10:42
 * @Description: 递归实现二分法查找
 * @version: 1.0
 */
public class BinarySrearch {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr = new OrdArray(maxSize);

        arr.insert(72);
        arr.insert(90);
        arr.insert(45);
        arr.insert(126);
        arr.insert(54);
        arr.insert(99);
        arr.insert(144);
        arr.insert(27);
        arr.insert(135);
        arr.insert(81);
        arr.insert(18);
        arr.insert(108);
        arr.insert(9);
        arr.insert(117);
        arr.insert(63);
        arr.insert(36);

        arr.display();

        int searchKey = 27;
        if(arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.delete(15);
        arr.delete(2);
        arr.display();

    }  // end method main

    /**
     * 9 18 27 36 45 54 63 72 81 90 99 108 117 126 135 144
     * Found 27
     * 9 18 36 45 54 63 72 81 90 99 108 117 126 135
     */

}  // end class BinarySearch

class OrdArray
{
    private int nElems;
    private long[] a;

    public OrdArray(int maxSize)
    {
        a = new long[maxSize];
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
        return (nElems == a.length);
    }

    public void display()
    {
        for(int j=0; j<nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    /**
     * 递归实现二分法查找
     * @param key
     * @param lowerBound
     * @param upperBound
     * @return
     */
    public int recFind(long key, int lowerBound, int upperBound)
    {
        int curIn = (lowerBound + upperBound)/2;
        if(a[curIn] == key)
            return curIn;
        else if(lowerBound > upperBound)
            return nElems;
        else
        {
            if(a[curIn] < key)
                return recFind(key, curIn+1, upperBound);
            else
                return recFind(key, lowerBound, curIn-1);
        }
    }

    /**
     * 查找
     * @param key
     * @return 索引
     */
    public int find(long key)
    {
        return recFind(key, 0, nElems-1);
    }

    /**
     * 有序插入
     * @param value
     * @return
     */
    public boolean insert(long value)
    {
        if(isFull())
            return false;  // 插入失败-数组已满
        else
        {
            int j;
            for(j=0; j<nElems; j++)  // 找到第一个大于value的位置
                if(a[j] > value)
                    break;

            if(j == nElems)  // 若没找到，直接在数组末尾插入
                a[j] = value;
            else  // 若找到，先将高位上移，再插入
            {
                for(int i=nElems; i>j; i--)
                    a[i] = a[i-1];
                a[j] = value;
            }
            nElems++;
            return true;
        }  // end else
    }  // end method insert


    /**
     * 删除-按照索引值
     * @param index
     * @return
     */
    public long delete(int index)
    {
        if(index<0 || index>nElems)
            return -1;  // 删除失败-数组为空、索引对应值为空或索引超出范围
        else
        {
            int i;
            for(i=index; i<nElems-1; i++)
                a[i] = a[i+1];
            a[i] = 0;  // long数据类型的默认值是0
            nElems--;
            return a[index];
        }
    }

}  // end class OrdArray