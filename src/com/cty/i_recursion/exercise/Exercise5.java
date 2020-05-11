package com.cty.i_recursion.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/11 11:24
 * @Description: P237-T6.5 测试组合问题
 * @version: 1.0
 */
public class Exercise5 {
    public static void main(String[] args) {
        Combination com = new Combination('A', 'B', 'C', 'D', 'E');
        System.out.print("Member: ");
        com.getAllMember().displayList();
        System.out.println("");

        System.out.println("Combination: ");
        com.showTeams("", 3, 5, 3);
    }  // end method main

    /** result
     * Member: A B C D E
     * Combination:
     * ABC
     * ABD
     * ABE
     * ACD
     * ACE
     * ADE
     * BCD
     * BCE
     * BDE
     * CDE
     */

}  // end class Exercise5
