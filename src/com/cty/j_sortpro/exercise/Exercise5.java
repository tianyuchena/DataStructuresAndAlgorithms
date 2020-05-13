package com.cty.j_sortpro.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/13 21:42
 * @Description: P276-T7.5 基数排序
 * @version: 1.0
 */
class RadixSortApp
{
    public static void main(String[] args) {
        int maxSize = 10;
        ListRadixSort list = new ListRadixSort(maxSize);

        for(int i=0; i<maxSize; i++)
            list.insert((long)(Math.random()*999));
        list.display();

        list.radixSort(3);
        list.display();

    }  // end method main

    /** 测试结果：
     * * * 10个数据项，数据项的关键字值最大为5位数
     * 21236 70001 69350 48147 64115 96264 20310 54096 61229 91984
     * 20310 21236 48147 54096 61229 64115 69350 70001 91984 96264
     *
     * * * 10个数据项，数据项的关键字值最大为3位数
     * 305 936 390 533 602 411 900 608 919 55
     * 55 305 390 411 533 602 608 900 919 936
     *
     * * * 10个数据项，数据项的关键字值最大为1位数
     * 0 7 2 6 7 3 4 3 8 2
     * 0 2 2 3 3 4 6 7 7 8
     *
     * * * 3个数据项，数据项的关键字值最大为3位数
     * 986 810 487
     * 487 810 986
     *
     * * * 3个数据项，数据项的关键字值最大为1位数
     * 6 7 4
     * 4 6 7
     *
     * * * 2个数据项，数据项的关键字值最大为2位数
     * 42 36
     * 36 42
     *
     * * * 1个数据项，数据项的关键字值最大为2位数
     * 18
     * 18
     */

}  // end class RadixSortApp

/**
 * 链节点
 * @param <E>
 */
class Link<E>
{
    public Object data;
    public Link next;

    public Link()
    {
    }

    public Link(E data)
    {
        this.data = data;
    }

    public void displayLink()
    {
        System.out.print(data + " ");
    }
}  // end class Link

/**
 * 双端链表
 * @param <E>
 */
class FirstLastList<E>
{
    private Link<E> first;
    private Link<E> last;

    public FirstLastList()
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public void display()
    {
        Link current = first;
        while(null != current)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void insertFirst(E data)
    {
        Link newLink = new Link(data);

        if(isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    public E deleteFirst()
    {
        if(isEmpty())
            return null;
        else
        {
            E data = (E)first.data;
            first = first.next;
            if(null == first)
                last = null;
            return data;
        }
    }

    public void insertLast(E data)
    {
        Link newLink = new Link(data);

        if(isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

}  // end class FirstLastList

class Queue<E>
{
    private FirstLastList<E> list;

    public Queue()
    {
        list = new FirstLastList();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public void displayQueue()
    {
        list.display();
    }

    public void insert(E data)
    {
        list.insertLast(data);
    }

    public E remove()
    {
        return list.deleteFirst();
    }
}

class ListRadixSort
{
    private long[] arr;
    private int nElems;
    private Queue<Long>[] queues;

    public ListRadixSort(int maxSize)
    {
        arr = new long[maxSize];
        nElems = 0;
        queues = new Queue[10];
        for(int i=0; i<10; i++)
            queues[i] = new Queue<>();
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
            arr[nElems++] = value;
            return true;
        }
    }

    public void radixSort(int figure)
    {
        int temp = figure;

        while(temp > 0)
        {
            int curFigure = figure-temp+1;  // 1代表个位，2代表十位，3代表百位，...

            // 将数据从数组移到队列
            for(int i=0; i<nElems; i++)
            {
                String currentStr = arr[i] + "";  // 将数值转化为字符串
                int size = currentStr.length();  // 获取字符串长度

                if(curFigure > size)  // 若arr[i]不存在该位
                    queues[0].insert(arr[i]);  // 将arr[i]放入0队列中
                else
                {
                    int curFigureVal = currentStr.charAt(size-curFigure)-'0';  // 获取当前位的值
                    queues[curFigureVal].insert(arr[i]);  // 将arr[i]放入对应的队列中
                }
            }  // end for

            // 将数据从队列移回数组
            int j = 0;
            for(int i=0; i<10; i++)
                while(!queues[i].isEmpty())
                    arr[j++] = queues[i].remove();

            temp--;
        }  // end while

    }  // end method radixSort

}  // end class ListRadixSort
