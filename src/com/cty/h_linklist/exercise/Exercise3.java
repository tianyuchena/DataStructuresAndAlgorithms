package com.cty.h_linklist.exercise;

import com.cty.h_linklist.Link;

/**
 * @Auther: cty
 * @Date: 2020/5/6 16:03
 * @Description: 循环链表  P187-5.3
 * @version: 1.0
 */
public class Exercise3
{
    public static void main(String[] args)
    {
        CircleLinkList list = new CircleLinkList();

        list.insertNext(10);
        list.insertNext(30);
        list.insertNext(90);

        list.display();

        list.step();
        list.insertNext(50);
        list.insertNext(70);

        list.display();

        list.removeNext();

        list.display();

        System.out.println("-------------------------------");
        for(int j=0; j<20; j++)
        {
            System.out.print(list.peekNext() + " ");
            list.step();
        }

        /**
         * CircleLinkList (current-->current): 90 30 10
         * CircleLinkList (current-->current): 70 50 30 10 90
         * CircleLinkList (current-->current): 50 30 10 90
         * -------------------------------
         * 50 30 10 90 50 30 10 90 50 30 10 90 50 30 10 90 50 30 10 90
         */

    }  // end method main
}  // end Exercise

class CircleLinkList
{
    private Link current;

    public CircleLinkList()
    {
        current = new Link(-1);
        current.next = current;
    }

    public boolean isEmpty()
    {
        return (current.next == current);
    }

    public void display()
    {
        System.out.print("CircleLinkList (current-->current): ");
        if(!isEmpty())
        {
            Link temp = current;
            System.out.print(peekNext() + " ");
            step();
            while(current != temp)
            {
                System.out.print(peekNext() + " ");
                step();
            }
        }
        System.out.println("");
    }

    public void step()
    {
        current = current.next;
        if(current.next.dData == -1)  // 跳过对-1节点的访问
            current = current.next;
    }

    /**
     * 在当前链节点之后插入一个节点
     * @param value
     */
    public void insertNext(long value)
    {
        Link newLink = new Link(value);
        newLink.next = current.next;
        current.next = newLink;
    }

    /**
     * 删除当前链节点之后的一个节点
     * @return
     */
    public long removeNext()
    {
        if(isEmpty())  // 链表为空时
            return -1;
        else
        {
            long temp = current.next.dData;
            current.next = current.next.next;
            if(current.next.dData == -1)  // 跳过对-1节点的访问
                current = current.next;
            return temp;
        }
    }

    /**
     * 查看下一个链节点的数据
     * @return
     */
    public long peekNext()
    {
        return current.next.dData;
    }
}  // end class CircleLinkList

