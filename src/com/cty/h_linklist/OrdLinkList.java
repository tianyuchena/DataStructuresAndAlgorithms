package com.cty.h_linklist;

/**
 * @Auther: cty
 * @Date: 2020/5/5 10:51
 * @Description: 有序链表
 * @version: 1.0
 */
public class OrdLinkList
{
    private Link first;

    public OrdLinkList()
    {
        first = null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public void displayList()
    {
        System.out.print("OrdLinkList (first-->last): ");
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    /**
     * 将指定键值有序插入链表  s=N/2【比较】  O(N)
     * @param key
     */
    public void insert(long key)
    {
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;

        while(current!=null && key>current.dData)
        {
            previous = current;
            current = current.next;
        }

        if(previous == null)  // 左端
            first = newLink;
        else  // 中间和右端
            previous.next = newLink;
        newLink.next = current;
    }  // end method insert

    /**
     * 删除并返回左端节点  O(1)
     * @return
     */
    public Link remove()
    {
        Link temp = first;
        first = first.next;
        return temp;
    }

}  // end class OrdLinkList

class OrdLinkListApp
{
    public static void main(String[] args)
    {
        OrdLinkList list = new OrdLinkList();
        list.insert(20);
        list.insert(40);

        list.displayList();

        list.insert(10);
        list.insert(30);
        list.insert(50);

        list.displayList();

        list.remove();

        list.displayList();
    }  // end method main
}  // end class OrdLinkListApp

/** 2020年5月5日
 * OrdLinkList (first-->last): 20 40
 * OrdLinkList (first-->last): 10 20 30 40 50
 * OrdLinkList (first-->last): 20 30 40 50
 */