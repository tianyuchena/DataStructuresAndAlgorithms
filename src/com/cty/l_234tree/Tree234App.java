package com.cty.l_234tree;

import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/5/21 21:31
 * @Description: 测试234树
 * @version: 1.0
 */
public class Tree234App
{
    public static void main(String[] args) {
        long value;
        Tree234 tree = new Tree234();

        tree.insert(50);
        tree.insert(40);
        tree.insert(60);
        tree.insert(30);
        tree.insert(70);

        while(true)
        {
            System.out.print("Enter first letter of show, insert or find: ");
            char choice = getChar();
            switch(choice)
            {
                case 's':
                    tree.displaytree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    tree.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    int found = tree.find(value);
                    if(found != -1)
                        System.out.println("Found "+value);
                    else
                        System.out.println("Could not find "+value);
                    break;
                default:
                    System.out.println("Invalid entry");

            }  // end switch
        }  // end while
    }  // end method main

    /**
     * Enter first letter of show, insert or find: s
     * level=0 child=0 /50/
     * level=1 child=0 /30/40/
     * level=1 child=1 /60/70/
     * Enter first letter of show, insert or find: f
     * Enter value to find: 40
     * Found 40
     * Enter first letter of show, insert or find: f
     * Enter value to find: 80
     * Could not find 80
     * Enter first letter of show, insert or find: i
     * Enter value to insert: 20
     * Enter first letter of show, insert or find: s
     * level=0 child=0 /50/
     * level=1 child=0 /20/30/40/
     * level=1 child=1 /60/70/
     * Enter first letter of show, insert or find: i
     * Enter value to insert: 10
     * Enter first letter of show, insert or find: s
     * level=0 child=0 /30/50/
     * level=1 child=0 /10/20/
     * level=1 child=1 /40/
     * level=1 child=2 /60/70/
     * Enter first letter of show, insert or find: h
     * Invalid entry
     */


    public static String getString()
    {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static char getChar()
    {
        String str = getString();
        return str.charAt(0);
    }

    public static int getInt()
    {
        String str = getString();
        return Integer.parseInt(str);
    }

}  // end class Tree234App
