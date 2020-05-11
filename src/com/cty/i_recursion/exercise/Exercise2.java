package com.cty.i_recursion.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/10 20:42
 * @Description: 画二叉树 P237-6.2
 * @version: 1.0
 */
public class Exercise2 {
    public static void main(String[] args) {
        Tree tree = new Tree(16);
        tree.display();

        System.out.println("=======================================================");

        tree.makeBranches(0,0, 15);
        tree.display();

    }  // end method main

    /**
     * ----------------
     * ----------------
     * ----------------
     * ----------------
     * ----------------
     * =======================================================
     * -------X--------
     * ---X-------X----
     * -X---X---X---X--
     * X-X-X-X-X-X-X-X-
     * XXXXXXXXXXXXXXXX
     */

}  // end class Exercise

class Tree
{
    private char[][] arr;
    private int maxSize;
    private int rows;

    public Tree(int maxSize)
    {
        this.maxSize = maxSize;

        rows = (int)(Math.log(maxSize)/Math.log(2))+1;  // 行数rows和每一行的个数maxSize之间的关系

        arr = new char[rows][];  // 定义二维字符数组

        for(int i=0; i<rows; i++){
            arr[i] = new char[maxSize];
            for(int j=0; j<maxSize; j++)
                arr[i][j] = '-';
        }
    }

    /**
     * 显示二维字符数组
     */
    public void display()
    {
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<maxSize; j++)
                System.out.print(arr[i][j]);
            System.out.println("");
        }
    }

    /**
     * 画二叉树
     * @param curRow 当前所在行数
     * @param left 当前左端
     * @param right 当前右端
     */
    public void makeBranches(int curRow, int left, int right)
    {
        if(curRow == rows)
            return;
        else
        {
            int curIn = (left + right) / 2;
            arr[curRow][curIn] = 'X';
            makeBranches(curRow+1, left, curIn);
            makeBranches(curRow+1, curIn+1, right);
        }
    }  // end method makeBranches
}  // end class tree
