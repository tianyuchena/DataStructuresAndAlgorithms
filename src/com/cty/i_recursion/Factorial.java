package com.cty.i_recursion;

import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/5/7 15:55
 * @Description: 递归计算阶乘
 * @version: 1.0
 */
public class Factorial {

    /**
     * 递归计算阶乘
     * @param num
     * @return
     */
    public static int factorial(int num)
    {
        if(1 == num)
            return 1;
        else
            return num * factorial(num-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入一个数字：");
        int num = Integer.parseInt(scan.nextLine());
        System.out.print(num + " 的阶乘为：" + factorial(num) + "\n");
    }  // end method main

    /**
     * 请输入一个数字：9
     * 9 的阶乘为：362880
     */

}  // end class Factorial
