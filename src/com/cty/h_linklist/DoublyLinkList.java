package com.cty.h_linklist;

/**
 * @Auther: cty
 * @Date: 2020/5/5 14:08
 * @Description: 双向链表
 * @version: 1.0
 */
public class DoublyLinkList
{
    private Link first;
    private Link last;

    public DoublyLinkList()
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public void displayForward()
    {
        System.out.print("List (first-->last): ");
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void displayBackWard()
    {
        System.out.print("List (last-->first): ");
        Link current = last;
        while(last != null)
        {
            last.displayLink();
            last = last.previous;
        }
    }

    public void insertFirst(long d)
    {
        Link newLink = new Link(d);
        if(isEmpty())
            last = newLink;
        else
            first.previous = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long d)
    {
        Link newLink = new Link(d);
        if(isEmpty())
            first = newLink;
        else
            last.next = newLink;
        newLink.previous = last;
        last = newLink;
    }

    public Link deleteFirst()
    {
        Link temp = first;
        if(!isEmpty())
        {
            if(first.next == null)  // 只有一个节点
                last = null;
            else
                first.next.previous = null;
            first = first.next;
        }
        return temp;
    }  // end method deleteFirst

    public Link deleteLast()
    {
        Link temp = last;
        if(!isEmpty())
        {
            if(last.previous == null)
                first = null;
            else
                last.previous.next = null;
            last = last.previous;
        }
        return temp;
    }  // end method deleteLast

    public boolean insertAfter(long key, long d)
    {
        if(isEmpty())
            return false;  // 空链表，key不存在，插入失败
        else
        {
            // 找到数据为key的节点
            Link current = first;
            while(current.dData != key)
            {
                current = current.next;
                if(current == null)
                    return false;  // key不存在，插入失败
            }

            // 插入dd
            Link newLink = new Link(d);
            if(current == last)  // 如果是最后一个节点（包含只有一个节点的情况）
            {
                newLink.next = null;
                last = newLink;
            }
            else
            {
                current.next.previous = newLink;
                newLink.next = current.next;
            }
            current.next = newLink;
            newLink.previous = current;
            return true;

        }  // end else
    }  // end method insertAfter

    public Link deleteKey(long key)
    {
        if(isEmpty())
            return null;  // 链表为空，key不存在，删除失败
        else
        {
            // 查找数据为key的节点
            Link current = first;
            while(current.dData != key)
            {
                current = current.next;
                if(current == null)
                    return null;  // key不存在，删除失败
            }

            // 左端处理
            if(current == first)
                first = first.next;
            else
                current.previous.next = current.next;

            // 右端处理
            if(current == last)
                last = last.previous;
            else
                current.next.previous = current.previous;

            return current;
        }  // end else
    }  // end method deleteKey

    /********************************************************************/
    // 为实现双端队列添加方法

    public Link getFirst() {
        return first;
    }

    public Link getLast() {
        return last;
    }

}  // end class DoublyLinkedList

class DoublyLinkedListApp
{
    public static void main(String[] args) {
        DoublyLinkList list = new DoublyLinkList();

        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);

        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);

        list.displayForward();

        list.deleteFirst();
        list.deleteLast();
        list.deleteKey(11);

        list.displayForward();

        list.insertAfter(22, 77);
        list.insertAfter(33, 88);

        list.displayForward();
    }  // end method main

}  // end DoublyLinkedListApp

/** 2020年5月5日
 * List (first-->last): 66 44 22 11 33 55
 * List (first-->last): 44 22 33
 * List (first-->last): 44 22 77 33 88
 */