package com.cty.m_hashtable.chainaddress;

/**
 * @Auther: cty
 * @Date: 2020/5/25 11:24
 * @Description: 哈希表
 * @version: 1.0
 */
public class HashTable
{
    private SortedList[] hashArray;
    private int arraySize;

    public HashTable(int arraySize)
    {
        this.arraySize = arraySize;
        hashArray = new SortedList[this.arraySize];
        for(int i=0; i<arraySize; i++)
            hashArray[i] = new SortedList();
    }

    /**
     * 显示哈希表
     */
    public void displayTable()
    {
        for(int i=0; i<arraySize; i++)
        {
            System.out.print(i + ". ");
            hashArray[i].displayList();
        }
    }

    /**
     * 哈希函数
     * @param key
     * @return
     */
    public int hashFunc(int key)
    {
        return key % arraySize;
    }

    /**
     * 插入
     * @param newLink
     */
    public void insert(Link newLink)
    {
        int key = newLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(newLink);
    }

    /**
     * 删除
     * @param key
     * @return
     */
    public Link delete(int key)
    {
        int hashVal = hashFunc(key);
        return hashArray[hashVal].delete(key);
    }

    /**
     * 查找
     * @param key
     * @return
     */
    public Link find(int key)
    {
        int hashVal = hashFunc(key);
        return  hashArray[hashVal].find(key);
    }


}  // end class HashTable
