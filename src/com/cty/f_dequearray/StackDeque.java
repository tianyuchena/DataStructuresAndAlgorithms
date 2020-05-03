package com.cty.f_dequearray;

import com.cty.d_stackarray.StackLongArray;

/**
 * @Auther: cty
 * @Date: 2020/5/3 10:36
 * @Description: 双端队列实现栈  P129-T4.3
 * @version: 1.0
 */
public class StackDeque {
    private DequeLongArray stack;

    public StackDeque(int maxSize)
    {
        stack = new DequeLongArray(maxSize);
    }

    public int size()
    {
        return stack.size();
    }

    public void display()
    {
        stack.display();
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public boolean isFull()
    {
        return stack.isFull();
    }

    public boolean push(long value)
    {
        return stack.insertRight(value);
    }

    public long pop()
    {
        return stack.removeRight();
    }

    public long peek()
    {
        return stack.peekRight();
    }
}

class StackDequeApp{
    public static void main(String[] args) {
        StackDeque theStack = new StackDeque(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        theStack.display();
    }
}  // end class StackApp
