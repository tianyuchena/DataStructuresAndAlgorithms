package com.cty.m_hashtable.chainaddress;

import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/5/25 12:19
 * @Description:
 * @version: 1.0
 */
public class HashChainApp
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
        HashTable theHashTable = new HashTable(size);
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

    /**
     * Enter size of hash table: 20
     * Enter initial number of items: 20
     * Enter first letter of show, insert, delete or find: s
     * 0. List (first-->last):
     * 1. List (first-->last): 141
     * 2. List (first-->last): 22 102
     * 3. List (first-->last):
     * 4. List (first-->last): 64 64 144 184
     * 5. List (first-->last):
     * 6. List (first-->last):
     * 7. List (first-->last): 27 47
     * 8. List (first-->last):
     * 9. List (first-->last):
     * 10. List (first-->last): 170
     * 11. List (first-->last): 171
     * 12. List (first-->last): 12 132 132
     * 13. List (first-->last):
     * 14. List (first-->last): 14
     * 15. List (first-->last): 35
     * 16. List (first-->last):
     * 17. List (first-->last): 37
     * 18. List (first-->last): 18
     * 19. List (first-->last): 19 199
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

}  // end class HashChainApp
