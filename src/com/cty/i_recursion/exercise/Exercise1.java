package com.cty.i_recursion.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/10 20:37
 * @Description: P237-T6.1
 * @version: 1.0
 */
public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(mult(2, 8));

    }  // end method main
    /**
     * 16
     */

    /**
     * 加法递归实现乘法
     * @param x
     * @param y
     * @return
     */
    public static int mult(int x, int y)
    {
        if(y == 0)
            return 0;
        else
            return x+mult(x, y-1);
    }

}  // end class Exercise1
