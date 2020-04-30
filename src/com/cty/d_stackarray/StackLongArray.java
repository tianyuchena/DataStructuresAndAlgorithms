package com.cty.d_stackarray;

/**
 * @Auther: cty
 * @Date: 2020/4/29 15:04
 * @Description: 长整型数组栈
 * @version: 1.0
 */
public class StackLongArray {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public StackLongArray(int size){
        maxSize = size;
        stackArray = new long[maxSize];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize-1);
    }

    public boolean push(long value){
        if(isFull()){
            return false;
        }else{
            stackArray[++top] = value;
            return true;
        }
    }

    public long pop(){
        if(isEmpty())
            return -1;
        else
            return stackArray[top--];
    }

    public long peek(){
        if(isEmpty())
            return -1;
        else
            return stackArray[top];
    }

}  // end class StackX

class StackApp{
    public static void main(String[] args) {
        StackLongArray theStack = new StackLongArray(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while(!theStack.isEmpty()){
            System.out.print(theStack.pop()+" ");
        }
        System.out.println("");
    }
}  // end class StackApp
