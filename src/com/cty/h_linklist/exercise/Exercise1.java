package com.cty.h_linklist.exercise;

import com.cty.g_priorityqarray.PriorityQLongArray;
import com.cty.h_linklist.OrdLinkList;

/**
 * @Auther: cty
 * @Date: 2020/5/6 15:18
 * @Description: 实现一个基于有序列表的双端队列  P187-5.1
 * @version: 1.0
 */
public class Exercise1 {
    public static void main(String[] args) {
        PriorityQByOrdLinkList PQ = new PriorityQByOrdLinkList();
        PQ.insert(30);
        PQ.insert(50);
        PQ.insert(10);
        PQ.insert(40);
        PQ.insert(20);
        PQ.insert(90);

        PQ.display();

        PQ.remove();
        PQ.remove();

        PQ.display();
    }

    /**
     * OrdLinkList (first-->last): 10 20 30 40 50 90
     * OrdLinkList (first-->last): 30 40 50 90
     */
}  // end class Exercise1

class PriorityQByOrdLinkList
{
    private OrdLinkList ordLinkList;

    public PriorityQByOrdLinkList()
    {
        ordLinkList = new OrdLinkList();
    }

    public boolean isEmpty()
    {
        return ordLinkList.isEmpty();
    }

    public void display()
    {
        ordLinkList.displayList();
    }

    public void insert(long value)
    {
        ordLinkList.insert(value);
    }

    public long remove()
    {
        return ordLinkList.remove().dData;
    }
}  // end class PriorityQByOrdLinkList



