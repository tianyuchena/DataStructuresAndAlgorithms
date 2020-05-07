package com.cty.h_linklist;

/**
 * @Auther: cty
 * @Date: 2020/5/4 9:36
 * @Description: 单链表
 * @version: 1.0
 */
//class Link {
//    public int iData;
//    public double dData;
//    public Link next;
//
//    public Link(int id, double dd)
//    {
//        iData = id;
//        dData = dd;
//    }
//
//    public void displayLink()
//    {
//        System.out.print("{" + iData + ", " + dData + "} ");
//    }
//}  // end class Link

public class LinkList
{
    private Link first;

    public LinkList()
    {
        first = null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    /**
     * 在表头插入一个节点  O(1)
     * @param d
     */
    public void insertFirst(long d)
    {
        Link newLink = new Link(d);
        newLink.next = first;
        first = newLink;
    }

    /**
     * 在表头删除节点  O(N)
     * @return
     */
    public long deleteFirst()
    {
        if(isEmpty())
            return -1;
        else
        {
            long temp = first.dData;
            first = first.next;
            return temp;
        }
    }

    /**
     * 根据指定键值查找  s=N/2【比较】  O(N)
     * @param key
     * @return
     */
    public Link find(long key)
    {
        if(isEmpty())
            return null;
        else
        {
            Link current = first;
            while(current.dData != key)
            {
                if(null == current.next)
                    return null;
                else
                    current = current.next;
            }
            return current;
        }  // end else
    }  // end method find

    /**
     * 根据指定键值删除  s=N/2【只有比较，不要移动/复制，优于数组】  O(N)
     * @param key
     * @return
     */
    public long delete(long key)
    {
        if(isEmpty())
            return -1;
        else
        {
            Link previous = first;
            Link current = first;

            while(current.dData != key)
            {
                if(null == current.next)
                    return -1;  // 没找到
                else
                {
                    previous = current;
                    current = current.next;
                }
            }

            if(current == first)
                first = first.next;
            else
                previous.next = current.next;

            return current.dData;
        }  // end else
    }  // end method delete

    /**
     * 遍历显示所有节点
     */
    public void displayList()
    {
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    /*************************************************************************/
    // 为迭代器新增方法
    public Link getFirst()
    {
        return first;
    }

    public void setFirst(Link f)
    {
        first = f;
    }

    public LinkListIterator getIterator()
    {
        return new LinkListIterator(this);
    }

}  // end class LinkList

class LinkListApp
{
    public static void main(String[] args) {
        LinkList list = new LinkList();

        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);
        list.insertFirst(88);

        list.displayList();

        Link f = list.find(44);
        if(null != f)
            System.out.println("查找到键值为" + f.dData + "的节点");
        else
            System.out.println("节点不存在");

        long data = list.delete(66);
        if(-1 != data)
            System.out.println("已删除键值为" + data + "的节点");
        else
            System.out.println("节点不存在");

        while(!list.isEmpty())
        {
            data = list.deleteFirst();
            System.out.print("Deleted " + data);
            System.out.println("");
        }

        list.displayList();
    }  // end method main
}  // end class LinkListApp

/** 2020年5月4日
 * 88 66 44 22
 * 查找到键值为44的节点
 * 已删除键值为66的节点
 * Deleted 88
 * Deleted 44
 * Deleted 22
 */
