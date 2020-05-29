package com.cty.m_hashtable.openaddress;

import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/5/23 16:08
 * @Description: 测试基于线性探测的哈希表
 * @version: 1.0
 */
public class HashTableApp
{
    public static void main(String[] args)
    {
        Link aDataItem;
        int size, n, keysPerCell, aKey;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;  // 设置关键字比率，随机生成的关键字范围为0~keysPerCell*size

        // 创建并初始化哈希表
        HashTable2 theHashTable = new HashTable2(size);
        for(int i=0; i<n; i++)
        {
            aKey = (int)(Math.random()*keysPerCell*size);
            theHashTable.insert(new Link(aKey));
        }

        while(true)
        {
            System.out.print("Enter first letter of show, insert, delete or find: ");
            char choice = getChar();
            switch (choice)
            {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    theHashTable.insert(new Link(aKey));
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if(aDataItem != null)
                        System.out.println("Found "+aKey);
                    else
                        System.out.println("Could not find "+aKey);
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }  // end while

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

}  // end class HashTableApp

/**
 * Enter size of hash table: 12
 * Enter initial number of items: 8
 * Enter first letter of show, insert, delete or find: s
 * Table: 117 85 ** ** 112 65 ** 7 ** 69 22 107
 *
 * Enter first letter of show, insert, delete or find: f
 * Enter key value to find: 65
 * Found 65
 *
 * Enter first letter of show, insert, delete or find: i
 * Enter key value to insert: 100
 *
 * Enter first letter of show, insert, delete or find: s
 * Table: 117 85 ** ** 112 65 100 7 ** 69 22 107
 *
 * Enter first letter of show, insert, delete or find: d
 * Enter key value to delete: 100
 *
 * Enter first letter of show, insert, delete or find: s
 * Table: 117 85 ** ** 112 65 -1 7 ** 69 22 107
 */
