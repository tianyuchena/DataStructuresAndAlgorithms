package com.cty.o_graph.dfs;

/**
 * @Auther: cty
 * @Date: 2020/6/10 20:44
 * @Description:
 * @version: 1.0
 */
public class StackX {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackX(int maxSize)
    {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public int peek()
    {
        if(isEmpty())
            return -1;
        return stackArray[top];
    }

    public void push(int j) {
        stackArray[++top] = j;
    }

    public int pop(){
        if(isEmpty())
            return -1;
        return (stackArray[top--]);
    }

}  // end StackX
