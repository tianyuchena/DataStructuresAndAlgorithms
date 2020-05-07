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
        matrix.displayMatrix();

    }  // end method main

    /**
     * 1 3 0 0
     * 3 4 0 0
     * 0 0 0 0 
     */
}  // end Exercise6

class Matrix
{
    private LinkList list;
    private LinkListIterator iter;

    /**
     * 构造器：生成rows行、columns列的零矩阵
     * @param rows
     * @param columns
     */
    public Matrix(int rows, int columns)
    {
        list = new LinkList();
        iter = list.getIterator();

        for(int i=1; i<=rows; i++)  // 创建矩阵第一列
            iter.insertAfter(0);
        iter.reset();
        iter.resetRight();

        while(iter.getCurrent() != null)  // 延长矩阵的每一行
        {
            for(int i=2; i<=columns; i++)
                iter.insertRightAfter(0);
            iter.nextLink();
            iter.resetRight();
        }
    }  // end constructor Matrix

    /**
     * 向矩阵第row行、第column列插入value值
     * @param row
     * @param column
     * @param value
     */
    public void insert(int row, int column, long value)
    {
        iter.reset();
        iter.resetRight();

        for(int i=1; i<row; i++)  // 下移row-1位
            iter.nextLink();
        iter.resetRight();
        for(int i=1; i<column; i++)  // 右移column-1位
            iter.nexRightLink();
        iter.getCurrentRight().dData = value;
    }  // end method insert

    /**
     * 显示矩阵
     */
    public void displayMatrix()
    {
        iter.reset();
        iter.resetRight();
        while(iter.getCurrent() != null)
        {
            while(iter.getCurrentRight() != null)
            {
                iter.getCurrentRight().displayLink();
                iter.nexRightLink();
            }
            System.out.println("");  // 换行
            iter.nextLink();
            iter.resetRight();
        }
    }  // end method displayMatrix

}  // end class Matrix
