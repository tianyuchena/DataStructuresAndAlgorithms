package com.cty.m_hashtable.chainaddress;

/**
 * @Auther: cty
 * @Date: 2020/5/25 9:09
 * @Description:  有序链表
 * @version: 1.0
 */
public class SortedList
{
    private Link first;

    public SortedList()
    {
        first = null;
    }

    /**
     * 显示列表
     */
    public void displayList()
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

    /**
     * 新增
     * @param newLink
     */
    public void insert(Link newLink)
    {
        int key = newLink.getKey();
        Link previous = null;
        Link current = first;

        // 找第一个关键字值大于新增数据项关键字的数据项
        while(current!=null && current.getKey()<key)
        {
            previous = current;
            current = current.next;
        }

        // 插入
        if(previous == null)  // ① 链表为空（在表头）  ② 链表第一个数据项的关键字就大于新增关键字（在表头）
            first = newLink;
        else  // ③ 中间项或末尾项关键字大于新增关键字（在中间或末尾）  ④ 不存在数据项关键字大于新增关键字（在末尾）
            previous.next = newLink;
        newLink.next = current;
    }

    /**
     * 删除
     * @param key
     * @return
     */
    public Link delete(int key) {
        Link previous = null;
        Link current = first;

        // 找第一个关键字值等于新增数据项关键字的数据项
        while (current != null && current.getKey() != key) {
            previous = current;
            current = current.next;
        }

        if (previous == null)
            if (first == null)  // ① 链表为空（在表头）
                return null;
            else  // ② 链表第一个数据项的关键字就等于新增关键字（在表头）
            {
                Link temp = first;
                first = first.next;
                return temp;
            }
        else
        {
            if(current != null)
            {
                previous.next = current.next;  // ③ 中间项或末尾项关键字等于新增关键字（在中间或末尾）
                return current;
            }
            else
                return null;  // ④ 不存在数据项关键字等于新增关键字（在末尾）
        }
    }

    /**
     * 查找
     * @param key
     * @return
     */
    public Link find(int key)
    {
        Link current = first;

        while(current!=null && current.getKey()<=key)
        {
            if(current.getKey() == key)
                return current;
            current = current.next;
        }
        return null;
    }

}  // end class SortedList
