package com.cty.m_hashtable.openaddress;

/**
 * @Auther: cty
 * @Date: 2020/5/23 15:26
 * @Description: 哈希表
 *      冲突处理：基于线性探测的开放地址法
 * @version: 1.0
 */
public class HashTable
{
    private Link[] hashArray;
    private int arraySize;
    private Link nonItem;

    public HashTable(int size)
    {
        arraySize = size;
        hashArray = new Link[arraySize];
        nonItem = new Link(-1);
    }

    /**
     * 显示哈希表（的键值）
     */
    public void displayTable()
    {
        System.out.print("Table: ");
        for(int i=0; i<arraySize; i++)
            if(hashArray[i] != null)
                System.out.print(hashArray[i].getKey()+" ");
            else
                System.out.print("** ");
        System.out.println("");
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
     * 查找
     * @param key
     * @return
     */
    public Link find(int key)
    {
        int hashVal = hashFunc(key);

        while(hashArray[hashVal] != null)
        {
            if(hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];

            hashVal++;  // 依次递增查找相同关键字的数据项
            hashVal %= arraySize;  // 探测到数组尾则回到数组头
        }
        return null;  // 探测到空单元，查找失败
    }

    /**
     * 插入
     *      假设哈希表未满
     * @param item
     */
    public void insert(Link item)
    {
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while(hashArray[hashVal]!=null && hashArray[hashVal].getKey()!=-1)
        {
            hashVal++;  // 依次递增，查找“空单元”（包括真正的空单元和被标记删除的单元）
            hashVal %= arraySize;  // 探测到数组尾则回到数组头
        }
        hashArray[hashVal] = item;
    }  // end method insert

    /**
     * 删除
     * @param key
     * @return
     */
    public Link delete(int key)
    {
        int hashVal = hashFunc(key);
        while(hashArray[hashVal] != null)
        {
            if(hashArray[hashVal].getKey() == key)
            {
                Link temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }

            hashVal++;  // 依次递增查找相同关键字的数据项
            hashVal %= arraySize;  // 探测到数组尾则回到数组头
        }
        return null;

    }  // end method delete

}  // end class HashTable
