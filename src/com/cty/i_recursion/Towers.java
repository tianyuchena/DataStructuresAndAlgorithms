package com.cty.i_recursion;

/**
 * @Auther: cty
 * @Date: 2020/5/8 15:27
 * @Description: 汉诺塔问题
 * @version: 1.0
 */
public class Towers {
    public static void doTowers(int topN, char from, char inner, char to)
    {
        if(1 == topN)
            System.out.println("Disk 1 form " + from + " to " + to);
        else
        {
            doTowers(topN-1, from, to, inner);  // 先将topN-1个盘子从from移动到inner
            System.out.println("Disk " + topN + " from " + from + " to " + to);  // 再将最大的盘子topN从from移动到to
            doTowers(topN-1, inner, from, to);  // 最后将topN个盘子从inner移动到to
        }
    }

    public static void main(String[] args) {
        Towers.doTowers(4, 'A', 'B', 'C');
    }  // end method main

    /**
     * Disk 1 form A to B
     * Disk 2 from A to C
     * Disk 1 form B to C
     * Disk 3 from A to B
     * Disk 1 form C to A
     * Disk 2 from C to B
     * Disk 1 form A to B
     * Disk 4 from A to C
     * Disk 1 form B to C
     * Disk 2 from B to A
     * Disk 1 form C to A
     * Disk 3 from B to C
     * Disk 1 form A to B
     * Disk 2 from A to C
     * Disk 1 form B to C
     */

}  // end class Towers
