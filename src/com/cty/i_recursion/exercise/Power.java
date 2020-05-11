package com.cty.i_recursion.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/9 10:11
 * @Description: 递归求一个数的乘方
 * @version: 1.0
 */
public class Power {
    /**
     * 计算一个数的乘方（打印每一步的信息）
     * @param x
     * @param y
     * @return
     */
    public static long doPower2(long x, long y)
    {
        System.out.println("x="+x+", y="+y);
        if(y == 1)
        {
            System.out.println("Returning "+x+", x="+x+", y="+y);
            return x;
        }
        else
        {
            long res;
            if(y%2 == 1)
                res = x*(doPower2(x*x, (y-1)/2));
            else
                res = doPower2(x*x, y/2);
            System.out.println("Returning "+res+", x="+x+", y="+y);
            return res;
        }
    }

    /**
     * 计算一个数的乘方（精简版）
     * @param x
     * @param y
     * @return
     */
    public static long doPower(long x, long y)
    {
        if(y == 1)
            return x;
        else
            if(y%2 == 1)
                return x*(doPower(x*x, (y-1)/2));
            else
                return doPower(x*x, y/2);
    }

}  // end end Power
