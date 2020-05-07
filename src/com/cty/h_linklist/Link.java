package com.cty.h_linklist;

/**
 * @Auther: cty
 * @Date: 2020/5/4 11:36
 * @Description: 节点类
 * @version: 1.0
 */
public class Link {
    public long dData;
    public Link next;
    public Link previous;
    public Link nextRight;  // 二维链表（矩阵）使用

    public Link()
    {
    }

    public Link(long d)
    {
        dData = d;
    }

    public void displayLink()
    {
        System.out.print(dData + " ");
    }
}  // end class Link
