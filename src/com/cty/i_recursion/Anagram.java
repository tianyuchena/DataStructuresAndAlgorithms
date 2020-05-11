package com.cty.i_recursion;

import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/5/8 9:20
 * @Description: 列出一个指定单词的 所有变位字（即全排列）
 * @version: 1.0
 */
public class Anagram {
    static int size;
    static int count;
    static char[] arrChar = new char[100];

    /**
     * [size-newSize, size-1]轮转（全部左移一位，最左端到最右端）
     * @param newSize
     */
    public static void rotate(int newSize)
    {
        int position = size - newSize;
        char temp = arrChar[position];

        int j;
        for(j=position+1; j<size; j++)
            arrChar[j-1] = arrChar[j];
        arrChar[j-1] = temp;
    }

    /**
     * 打印当前单词排列（前面显示打印了第一个的编号）
     */
    public static void displayWord()
    {
        if(count < 99)
            System.out.print(" ");
        if(count < 9)
            System.out.print(" ");
        System.out.print(++count + " ");
        for(int j=0; j<size; j++)
            System.out.print(arrChar[j]);
        System.out.print("   ");
        if(count%6 == 0)
            System.out.println("");
    }

    /**
     * 打印长度为newSize的单词的全排列
     * @param newSize
     */
    public static void doAnagram(int newSize)
    {
        if(1 == newSize)
            return;
        for(int j=0; j<newSize; j++)
        {
            doAnagram(newSize-1);

            if(2 == newSize)
                displayWord();

            rotate(newSize);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入一个单词：");
        String word = scan.nextLine();
        size = word.length();
        for(int j=0; j<size; j++)
            arrChar[j] = word.charAt(j);

        doAnagram(size);
    }  // end method main
    /**
     * 请输入一个单词：cats
     *   1 cats     2 cast     3 ctsa     4 ctas     5 csat     6 csta
     *   7 atsc     8 atcs     9 asct    10 astc    11 acts    12 acst
     *  13 tsca    14 tsac    15 tcas    16 tcsa    17 tasc    18 tacs
     *  19 scat    20 scta    21 satc    22 sact    23 stca    24 stac
     */

}  // end class Anagram
