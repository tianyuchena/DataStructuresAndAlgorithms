package com.cty.h_linklist.exercise;

import com.cty.f_dequearray.DequeLongArray;
import com.cty.h_linklist.DoublyLinkList;

/**
 * @Auther: cty
 * @Date: 2020/5/6 15:37
 * @Description: 实现一个基于双向列表的双端队列  P187-5.2
 * @version: 1.0
 */
public class Exercise2
{
    public static void main(String[] args) {
        DequeByDoublyLinkList deque = new DequeByDoublyLinkList();

        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);

        deque.insertRight(4);
        deque.insertRight(5);
        deque.insertRight(6);

        deque.display();

        deque.removeLeft();
        deque.removeRight();

        deque.display();
    }  // end method main

    /**
     * List (first-->last): 3 2 1 4 5 6
     * List (first-->last): 2 1 4 5
     */
}  // end Exercise

class DequeByDoublyLinkList
{
    private DoublyLinkList doublyLinkList;

    public DequeByDoublyLinkList()
    {
        doublyLinkList = new DoublyLinkList();
    }

    public boolean isEmpty()
    {
        return doublyLinkList.isEmpty();
    }

    public void display()
    {
        doublyLinkList.displayForward();
    }

    public void insertLeft(long value)
    {
        doublyLinkList.insertFirst(value);
    }

    public long removeLeft()
    {
        return doublyLinkList.deleteFirst().dData;
    }

    public long peekLeft()
    {
        return doublyLinkList.getFirst().dData;
    }

    public void insertRight(long value)
    {
        doublyLinkList.insertLast(value);
    }

    public long removeRight()
    {
        return doublyLinkList.deleteLast().dData;
    }

    public long peekRight()
    {
        return doublyLinkList.getLast().dData;
    }
}  // end DequeByDoublyLinkList
