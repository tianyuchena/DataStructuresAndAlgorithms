package com.cty.d_stackarray;

/**
 * @Auther: cty
 * @Date: 2020/4/29 16:24
 * @Description: 字符数组栈
 * @version: 1.0
 */
public class StackCharArray {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackCharArray(int size){
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize-1);
    }

    public boolean push(char c){
        if(isFull()){
            return false;
        }else{
            stackArray[++top] = c;
            return true;
        }
    }

    public char pop(){
        if(isEmpty()){
            return '$';
        }else{
            return stackArray[top--];
        }
    }

    public char peek(){
        if(isEmpty()){
            return '$';
        }else{
            return stackArray[top];
        }
    }
}
