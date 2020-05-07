package com.cty.h_linklist;

/**
 * @Auther: cty
 * @Date: 2020/5/5 11:25
 * @Description: 通过有序链表对数组进行排序
 * @version: 1.0
 */
public class OrdLinkListSort {
    private Link first;

    public OrdLinkListSort()
    {
        first = null;
    }

    public OrdLinkListSort(Link[] array)
    {
        first = null;
        for(int j=0; j<array.length; j++)
            insert(array[j]);
    }

    public void insert(Link k)
    {
        Link previous = null;
        Link current = first;

        while(current!=null && current.dData<k.dData)
        {
            previous = current;
            current = current.next;
        }

        if(previous == null)
            first = k;
        else
            previous.next = k;
        k.next = current;
    }  // end method insert

    public Link remove()
    {
        Link temp = first;
        first = first.next;
        return temp;
    }
}  // end class OrdLinkListSort

class OrdLinkListSortApp
{
    public static void main(String[] args) {
        // 创建随机数组
        int size = 10;
        Link[] linkArray = new Link[size];
        for(int j=0; j<size; j++)
        {
            int n = (int)(Math.random()*99);
            Link newLink = new Link(n);
            linkArray[j] = newLink;
        }

        // 打印随机数组
        System.out.print("Unsorted array: ");
        for(int j=0; j<size; j++)
            linkArray[j].displayLink();
        System.out.println("");

        // 随机数组排序
        OrdLinkListSort sortList = new OrdLinkListSort(linkArray);
        for(int j=0; j<size; j++)
            linkArray[j] = sortList.remove();

        // 打印排序后的数组
        System.out.print("Sorted array: ");
        for(int j=0; j<size; j++)
            linkArray[j].displayLink();
        System.out.println("");

    }  // end method main
}  // end class OrdLinkListSortApp

/** 2020年5月5日
 * Unsorted array: 68 59 22 36 62 83 91 6 65 18
 * Sorted array: 6 18 22 36 59 62 65 68 83 91
 */