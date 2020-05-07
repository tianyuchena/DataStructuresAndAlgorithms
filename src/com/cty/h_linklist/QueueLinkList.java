package com.cty.h_linklist;

/**
 * @Auther: cty
 * @Date: 2020/5/4 16:37
 * @Description: 双端链表实现队列
 * @version: 1.0
 */
public class QueueLinkList {
    private FirstLastList list;

    public QueueLinkList()
    {
        list = new FirstLastList();
    }

    public void displayQueue()
    {
        System.out.print("Queue (front-->rear) : ");
        list.displayList();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public void insert(long d)
    {
        list.insertLast(d);
    }

    public long remove()
    {
        return list.deleteFirst();
    }
}  // end class QueueLinkList

class QueueLinkListApp
{
    public static void main(String[] args) {
        QueueLinkList queue = new QueueLinkList();

        queue.insert(20);
        queue.insert(40);

        queue.displayQueue();

        queue.insert(60);
        queue.insert(80);

        queue.displayQueue();

        queue.remove();
        queue.remove();

        queue.displayQueue();
    }  // end method main
}  // end QueueLinkListApp

/** 2020年5月4日
 * Queue (front-->rear) : 20 40
 * Queue (front-->rear) : 20 40 60 80
 * Queue (front-->rear) : 60 80
 */