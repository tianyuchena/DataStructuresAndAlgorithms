package com.cty.d_stackarray;

/**
 * @Auther: cty
 * @Date: 2020/4/29 15:04
 * @Description: 长整型数组栈
 * 时间复杂度分析：
 *      栈的重要操作push和pop时间复杂度都是O(1)
 * 栈的实现：
 *      数组
 *      链表
 * 栈的应用：
 *      单词顺序反转
 *      分隔符匹配（算数计算）
 * 数据结构的分类：
 *      1 记录现实世界的对象和活动数据，如链表、树
 *              操作一般为：查找、插入和删除
 *              生命周期长
 *      2 作为程序员构思算法的辅助工具，如栈、队列、优先级队列
 *              生命周期短，程序操作执行期间创建，完成任务后销毁
 *              受限访问——特定时刻只有一个数据可以被读取或删除
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
    }  // end method main
}  // end class StackApp
