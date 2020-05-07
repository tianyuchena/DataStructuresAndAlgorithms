package com.cty.h_linklist.exercise;

import com.cty.h_linklist.Link;
import com.cty.h_linklist.LinkList;
import com.cty.h_linklist.LinkListIterator;

/**
 * @Auther: cty
 * @Date: 2020/5/6 22:04
 * @Description: 二维链表（矩阵）  P187-5.6
 * @version: 1.0
 */
public class Exercise6
{
    public static void main(String[] args) {

        Matrix matrix = new Matrix(3, 4);
        matrix.insert(1, 1, 1);
        matrix.insert(1, 2, 3);
        matrix.insert(2, 1, 3);
        matrix.insert(2, 2, 4);
        matrix.insert(2, 3, 5);
        matrix.insert(3, 4, 7);

        matrix.displayMatrix();

    }  // end method main

    /**
     * 1 3 0 0
     * 3 4 5 0
     * 0 0 0 7
     */
}  // end Exercise6

class Matrix
{
    private Link origin;  // 原点
    private Link current;  // 当前链节点
    private LinkList[] lists;
    private LinkListIterator[] iters;

    /**
     * 构造器：生成rows行、columns列的零矩阵
     * @param rows
     * @param columns
     */
    public Matrix(int rows, int columns) {
        lists = new LinkList[rows];
        iters = new LinkListIterator[rows];

        for (int i = 0; i < rows; i++)  // 创建rows个链表并放在数组中
            lists[i] = new LinkList();
        for (int i = 0; i < rows; i++)  // 获取各个链表的迭代器
        {
            iters[i] = lists[i].getIterator();
            for(int j=0; j<columns; j++)  // 每一个链表都在右方向上插入columns个链节点
                iters[i].insertRightAfter(0);  // 1 每个链节点（除了左侧面的节点）都由它左面的链节点指着
        }

        origin = lists[0].getFirst();  // 将原点引用指向矩阵左上角链节点

        // 2 让每个链节点（除了第一行）都由它上面的链节点指着
        if (rows > 1 && columns > 1)  // 至少是2x2矩阵
            for(int i=0; i<rows-1; i++)
            {
                iters[i].resetRight();  // 上链表当前引用置左
                iters[i+1].resetRight();  // 下链表当前引用置左
                while (!iters[i].atRightEnd())  // 相邻两个链表中链节点一一上下对应，将上链节点的next指向下链节点
                {
                    iters[i].getCurrentRight().next = iters[i+1].getCurrentRight();
                    iters[i].nexRightLink();
                    iters[i+1].nexRightLink();
                }
                iters[i].getCurrentRight().next = iters[i+1].getCurrentRight();  // 不要忘记对结尾处链节点处理！
            }
    }  // end constructor Matrix

    /**
     * 重置current
     */
    public void resetCurrent()
    {
        current = origin;
    }

    /**
     * current下移一步
     */
    public void stepDown()
    {
        current = current.next;
    }

    /**
     * current右移一步
     */
    public void stepRight()
    {
        current = current.nextRight;
    }

    /**
     * 向矩阵第row行、第column列插入value值
     * @param row
     * @param column
     * @param value
     */
    public void insert(int row, int column, long value)
    {
        resetCurrent();
        for(int i=1; i<row; i++)
            stepDown();
        for(int j=1; j<column; j++)
            stepRight();
        current.dData = value;
    }  // end method insert

    /**
     * 显示矩阵
     */
    public void displayMatrix()
    {
        for(int i=0; i<lists.length; i++)
            iters[i].displayRightList();
            //lists[i].displayRightList();
    }  // end method displayMatrix

}  // end class Matrix
