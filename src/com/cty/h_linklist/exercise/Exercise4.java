package com.cty.h_linklist.exercise;

import com.cty.d_stackarray.StackLongArray;

/**
 * @Auther: cty
 * @Date: 2020/5/6 16:57
 * @Description: 循环链表实现栈  P187-5.4
 * @version: 1.0
 */
public class Exercise4 {
    public static void main(String[] args) {
        StackByCircleLinkList stack = new StackByCircleLinkList();
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println("");
    }  // end method main

    /**
     * 80 60 40 20
     */
}  // end class Exercise

class StackByCircleLinkList
{
    private CircleLinkList list;

    public StackByCircleLinkList()
    {
        list = new CircleLinkList();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public void push(long value)
    {
        list.insertNext(value);
    }

    public long pop()
    {
        return list.removeNext();
    }

    public long peek()
    {
        return list.peekNext();
    }
}  // end StackByCircleLinkList
