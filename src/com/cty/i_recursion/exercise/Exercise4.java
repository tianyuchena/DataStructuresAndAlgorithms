package com.cty.i_recursion.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/11 11:15
 * @Description: P237-T6.4 测试背包问题
 * @version: 1.0
 */
public class Exercise4 {
    public static void main(String[] args) {
        Backpack bag = new Backpack(11, 6, 8, 5, 7);
        System.out.print("Items: ");
        bag.getWeights().displayList();
        System.out.println("\n==============================================");
        bag.doBackpack(0, 20);
    }  // end method main

    /**
     * Items: 11 8 7 6 5
     * ==============================================
     * 11          // Target = 20, 11 is too small
     * 11  8       // Target = 9, 8 is too small
     * 11  8  7    // Target = 1, 7 is too big
     * 11  8  6    // Target = 1, 6 is too big
     * 11  8  5    // Target = 1, 5 is too big. No more items
     * 11  7       // Target = 9, 7 is too small
     * 11  7  6    // Target = 2, 6 is too big
     * 11  7  5    // Target = 2, 5 is too big. No more items
     * 11  6       // Target = 9, 6 is too small
     * 11  6  5    // Target = 3, 5 is too big. No more items
     * 11  5       // Target = 9, 5 is too small. No more items
     *  8          // Target = 20, 8 is too small
     *  8  7       // Target = 12, 7 is too small
     *  8  7  6    // Target = 5, 6 is too big
     *  8  7  5    // Target = 5, 5 is just right. Success!
     */

}  // end class Exercise4
