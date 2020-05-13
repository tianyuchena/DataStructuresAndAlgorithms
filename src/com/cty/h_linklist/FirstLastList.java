package com.cty.h_linklist;

/**
 * @Auther: cty
 * @Date: 2020/5/4 10:33
 * @Description: 双端链表
 * @version: 1.0
 */
public class FirstLastList
{
    private Link first;
    private Link last;

    public FirstLastList()
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    /**
     * 在表头插入一个节点  O(1)
     * @param l
     */
    public void insertFirst(long l)
    {
        Link newLink = new Link(l);
        if(isEmpty())  // isEmpty()和first有关，必须放在 first = newLink 前面
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    /**
     * 在表头删除一个节点  O(1)
     * @return
     */
    public long deleteFirst()
    {
        if(isEmpty())
            return -1;
        else
        {
            long temp = first.dData;
            if(null == first.next)
                last = null;
            first = first.next;
            return temp;
        }
    }

    /**
     * 在表尾插入一个节点  O(1)
     * @param l
     */
    public void insertLast(long l)
    {
        Link newLink = new Link(l);
        if(isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    public void displayList()
    {
//        System.out.print("List (first-->last) : ");
        Link current = first;
        while(null != current)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

}  // end class FirstLastList

class FirstLastListApp{
    public static void main(String[] args) {
        FirstLastList list = new FirstLastList();

        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);

        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);

        list.displayList();

        list.deleteFirst();
        list.deleteFirst();

        list.displayList();
    }  // end method main
}  // end class FirstLastListApp

/** 2020年5月4日
 * List (first-->last) : 66 44 22 11 33 55
 * List (first-->last) : 22 11 33 55
 */