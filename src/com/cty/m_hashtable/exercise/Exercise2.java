package com.cty.m_hashtable.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/27 18:21
 * @Description: 线性探测哈希表存储字符串  P433-T11.2
 * @version: 1.0
 */

import java.util.Scanner;

/**
 * 测试哈希表
 */
public class Exercise2
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入数组容量：");
        int arraySize = Integer.parseInt(scan.nextLine());
        HashTable2 hashTable = new HashTable2(arraySize);

        while(true)
        {
            System.out.print("请输入一串小写字符串：");
            String key = scan.nextLine();

            hashTable.insert(key);

            Link res = hashTable.find(key);
            if(res != null)
                System.out.println("找到"+key);
            else
                System.out.println("未找到"+key);

            hashTable.displayTable();
            System.out.println();
        }
    }  // end method main

    /**
     * 请输入数组容量：10
     * 请输入一串小写字符串：a
     * 找到a
     * HashTable: {*, *} {key=1, data=a} {*, *} {*, *} {*, *} {*, *} {*, *} {*, *} {*, *} {*, *}
     *
     * 请输入一串小写字符串：ab
     * 找到ab
     * HashTable: {*, *} {key=1, data=a} {*, *} {*, *} {*, *} {*, *} {*, *} {*, *} {key=8, data=ab} {*, *}
     */

}  // end class Exercise1


/**
 * 存储小写字符串的线性探测哈希表
 */
class HashTable2
{
    private Link[] hashArray;
    private int arraySize;

    public HashTable2(int arraySize)
    {
        this.arraySize = arraySize;
        hashArray = new Link[this.arraySize];
    }

    public void displayTable()
    {
        System.out.print("HashTable: ");
        for(int i=0; i<arraySize; i++)
        {
            if(hashArray[i] != null)
                System.out.print(hashArray[i].toString() + " ");
            else
                System.out.print("{*, *} ");
        }
        System.out.println();
    }

    /**
     * 哈希函数，将关键字映射为数组下标
     * @param key
     * @return
     */
    private int hashFunc(String key)
    {
        int hashVal = 0;
        for(int i=0; i<key.length(); i++)
        {
            int letter = key.charAt(i) - 96;
            hashVal = (hashVal * 26 + letter) % arraySize;
        }
        return hashVal;
    }

    /**
     * 查找
     * @param key
     * @return
     */
    public Link find(String key)
    {
        int hashVal = hashFunc(key);
        while(hashArray[hashVal] != null)
        {
            if(hashArray[hashVal].getKey()==hashVal &&  hashArray[hashVal].getData().equals(key))
                return hashArray[hashVal];

            hashVal++;
            hashVal %= arraySize;
        }
        return null;
    }

    /**
     * 插入
     * @param key
     */
    public void insert(String key)
    {
        int hashVal = hashFunc(key);
        Link newLink = new Link(hashVal, key);
        while(hashArray[hashVal]!=null && hashArray[hashVal].getKey()!=-1)
        {
            hashVal++;
            hashVal %= arraySize;
        }
        hashArray[hashVal] =  newLink;
    }

}  // end class HashTable1



