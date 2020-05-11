package com.cty.i_recursion;

import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/5/7 15:38
 * @Description: 递归计算三角数字
 * @version: 1.0
 */
public class Triangle
{
    /**
     * 递归计算三角数字
     * @param num
     * @return
     */
    public static int triangle(int num)
    {
        if(1 == num)
            return 1;
        else
            return num + triangle(num-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入要获取第几个三角数字：");
        int num = Integer.parseInt(scan.nextLine());
        System.out.print("第 " + num + " 个三角数字为：" + triangle(num) + "\n");
    }  // end method main

    /**
     * 请输入要获取第几个三角数字：1000
     * 第 1000 个三角数字为：500500
     */
}  // end class Triangle


