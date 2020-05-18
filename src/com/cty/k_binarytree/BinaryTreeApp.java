package com.cty.k_binarytree;

import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/5/16 21:58
 * @Description:
 * @version: 1.0
 */
public class BinaryTreeApp {
    public static void main(String[] args) {
        int value;
        BinaryTree tree = new BinaryTree();

        tree.insert(new Node(new Pojo(50, 1.5)));
        tree.insert(new Node(new Pojo(25, 1.2)));
        tree.insert(new Node(new Pojo(75, 1.7)));
        tree.insert(new Node(new Pojo(12, 1.5)));
        tree.insert(new Node(new Pojo(37, 1.2)));
        tree.insert(new Node(new Pojo(43, 1.7)));
        tree.insert(new Node(new Pojo(30, 1.5)));
        tree.insert(new Node(new Pojo(33, 1.2)));
        tree.insert(new Node(new Pojo(87, 1.7)));
        tree.insert(new Node(new Pojo(93, 1.5)));
        tree.insert(new Node(new Pojo(50, 1.5)));

        while(true)
        {
            System.out.print("Enter first letter of show, insert, find, delete or traverse: ");
            int choice = getChar();
            switch (choice)
            {
                case 's':
                    tree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    tree.insert(new Node(new Pojo(value, value+0.9)));
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node find = tree.find(value);
                    if(find != null)
                        System.out.println("Found " + find.data);
                    else
                        System.out.println("Could not find " + value);
                    break;
                case 'd':
                    System.out.print("Enter a value to delete: ");
                    value = getInt();
                    boolean isDelete = tree.delete(value);
                    if(isDelete)
                        System.out.println("Deleted " + value);
                    else
                        System.out.println("Could not delete " + value);
                    break;
                case 't':
                    System.out.print("Enter traverse type 1, 2 or 3: ");
                    value = getInt();
                    tree.traverse(value);
                    break;
                default:
                    System.out.println("Invalid entry");
            }  // end switch

        }  // end while true

    }  // end method main

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

}  // end class BinaryApp
