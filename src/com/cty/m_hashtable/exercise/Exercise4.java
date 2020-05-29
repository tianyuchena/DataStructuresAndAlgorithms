package com.cty.m_hashtable.exercise;

import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/5/29 10:42
 * @Description: 自动扩展数组的线性探测哈希表  P433-T11.4
 * @version: 1.0
 */

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入数组容量：");
        int arraySize = Integer.parseInt(scan.nextLine());
        HashTable4 hashTable = new HashTable4(arraySize);

        while(true) {
            System.out.print("请输入待插入数字：");
            int key = Integer.parseInt(scan.nextLine());
            hashTable.insert(new Link(key));

            Link res = hashTable.find(key);
            if (res != null)
                System.out.println("找到" + key);
            else
                System.out.println("未找到" + key);

            hashTable.displayTable();
            System.out.println();
        }

    }  // end method main

    /**
     * 请输入数组容量：4
     * 请输入待插入数字：1
     * 找到1
     * {*, *} {key=1, data=null} {*, *} {*, *}
     *
     * 请输入待插入数字：0
     * 找到0
     * {key=0, data=null} {key=1, data=null} {*, *} {*, *} {*, *} {*, *} {*, *} {*, *}
     */

}  // end class Exercise4

/**
 * 自动扩展数组的线性探测哈希表
 */
class HashTable4
{
    private int arraySize;
    private int nElems;
    private Link[] hashArray;
    private Link nonItem;

    public HashTable4(int size)
    {
        arraySize = size;
        hashArray = new Link[arraySize];

        nElems = 0;

        nonItem = new Link(-1);
    }

    public void displayTable()
    {
        for(int i=0; i<arraySize; i++)
        {
            if(hashArray[i] == null || hashArray[i].getKey()==-1)
                System.out.print("{*, *} ");
            else
                System.out.print(hashArray[i].toString()+" ");
        }
        System.out.println();
    }

    private int hashFunc(int key)
    {
        return key % arraySize;
    }

    private void rehash()
    {
        int newArraySize = arraySize*2;
        HashTable4 newHashTable = new HashTable4(newArraySize);

        for(int i=0; i<arraySize; i++)
            if(hashArray[i]!=null && hashArray[i].getKey()!=-1)
                newHashTable.insert(hashArray[i]);

        arraySize = newHashTable.arraySize;
        hashArray = newHashTable.hashArray;
        nElems = newHashTable.nElems;
    }

    public void insert(Link item)
    {
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while(hashArray[hashVal]!=null && hashArray[hashVal].getKey()!=-1)
        {
            hashVal++;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
        nElems++;

        // 若装填因子大于0.5，扩展数组容量为原来的两倍
        if((float)nElems/arraySize >= 0.5)
            rehash();
    }

    public Link find(int key)
    {
        int hashVal = hashFunc(key);
        while(hashArray[hashVal] != null)
        {
            if(hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];

            hashVal++;
            hashVal %= arraySize;
        }
        return null;
    }

    public Link delete(int key)
    {
        int hashVal = hashFunc(key);
        while(hashArray[hashVal] != null)
        {
            if(hashArray[hashVal].getKey() == key)
            {
                Link temp = hashArray[hashVal];
                hashArray[hashVal].setKey(-1);
                nElems--;
                return temp;
            }

            hashVal++;
            hashVal %= arraySize;
        }
        return null;
    }  // end method class

}  // end class HashTable4




