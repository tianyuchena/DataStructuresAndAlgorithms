package com.cty.m_hashtable.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/27 18:21
 * @Description: 应用数字折叠的线性探测哈希表  P433-T11.3
 * @version: 1.0
 */

import java.util.Scanner;

/**
 * 测试哈希表
 */
public class Exercise3
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入数组容量：");
        int arraySize = Integer.parseInt(scan.nextLine());
        HashTable3 hashTable = new HashTable3(arraySize);

        while(true)
        {
            System.out.print("请输入待插入数字：");
            int key = Integer.parseInt(scan.nextLine());
            hashTable.insert(new Link(key));

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
     * 请输入数组容量：11
     * 请输入待插入数字：1234
     * 找到1234
     * HashTable: {*, *} {*, *} {key=1234, data=null} {*, *} {*, *} {*, *} {*, *} {*, *} {*, *} {*, *} {*, *}
     *
     * 请输入待插入数字：123
     * 找到123
     * HashTable: {*, *} {*, *} {key=1234, data=null} {*, *} {key=123, data=null} {*, *} {*, *} {*, *} {*, *} {*, *} {*, *}
     */

}  // end class Exercise1


/**
 * 应用数字折叠的线性探测哈希表
 */
class HashTable3
{
    private Link[] hashArray;
    private int arraySize;

    public HashTable3(int arraySize)
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
    public int hashFunc(int key)
    {
        // 预处理：折叠
        Integer k = key;
        int keyLen = k.toString().length();  // 获取原始数据位数
        Integer as = arraySize;
        int arrayLen = as.toString().length();  // 获取数组容量位数

        if(arraySize == (int)Math.pow(10, (arrayLen-1)))  // 如，100虽然长度为3，但也按照2来折叠
            arrayLen -= 1;

        int foldLen = (keyLen%arrayLen==0)?(keyLen/arrayLen):(keyLen/arrayLen+1);  // 折叠成几部分
        int[] folds = new int[foldLen];  // 定义折叠数组

        int i;
        for(i=0; i<foldLen-1; i++)  // 各个折叠部分存放到折叠数组
            folds[i] = Integer.parseInt(k.toString().substring(i*arrayLen, (i+1)*arrayLen));
        folds[i] = Integer.parseInt(k.toString().substring(i*arrayLen));

        int finalKey = 0;
        for(i=0; i<foldLen; i++)  // 计算最终关键字
            finalKey += folds[i];


        // 对数组容量取余
        int hashVal = finalKey % arraySize;
        return hashVal;
    }

    /**
     * 查找
     * @param key
     * @return
     */
    public Link find(int key)
    {
        int hashVal = hashFunc(key);
        while(hashArray[hashVal] != null)
        {
            if(hashArray[hashVal].getKey()==key)
                return hashArray[hashVal];

            hashVal++;
            hashVal %= arraySize;
        }
        return null;
    }

    /**
     * 插入
     * @param item
     */
    public void insert(Link item)
    {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        Link newLink = new Link(key);
        while(hashArray[hashVal]!=null && hashArray[hashVal].getKey()!=-1)
        {
            hashVal++;
            hashVal %= arraySize;
        }
        hashArray[hashVal] =  item;
    }

}  // end class HashTable1


