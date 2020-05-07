package com.cty.h_linklist;

/**
 * @Auther: cty
 * @Date: 2020/5/4 11:44
 * @Description: 链表实现栈
 * @version: 1.0
 */
public class StackLinkList {
    private LinkList list;

    public StackLinkList()
    {
        list = new LinkList();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public void displayStack()
    {
        System.out.print("Stack (top-->bottom) : ");
        list.displayList();
    }

    public void push(long d)
    {
        list.insertFirst(d);
    }

    public long pop()
    {
        return list.deleteFirst();
    }
}  // end class StackLinkList

class StackLinkListApp
{
    public static void main(String[] args) {
        StackLinkList stack = new StackLinkList();

        stack.push(20);
        stack.push(40);

        stack.displayStack();

        stack.push(60);
        stack.push(80);

        stack.displayStack();

        stack.pop();
        stack.pop();

        stack.displayStack();
    }  // end method main
}  // end StackLinkListApp

/** 2020年5月4日
 * Stack (top-->bottom) : 40 20
 * Stack (top-->bottom) : 80 60 40 20
 * Stack (top-->bottom) : 40 20
 */