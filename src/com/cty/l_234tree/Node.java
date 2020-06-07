package com.cty.l_234tree;

/**
 * @Auther: cty
 * @Date: 2020/5/21 16:55
 * @Description: 234树节点
 * @version: 1.0
 */
public class Node
{
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node[] childArray = new Node[ORDER];
    private DataItem[] itemArray = new DataItem[ORDER-1];

    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * 数据项操作：
     *      1 获取当前节点的数据项个数
     *      2 判断数据数组是否已满
     *      3 判断数据数组是否为空
     *      4 获取指定索引位置上的数据项
     *      5 根据数据关键字值查找，返回索引；若数组为空或数组中不存在返回-1
     *      6 向数据数组中插入一个数据项，返回插入的索引位置，数组已满则返回-1
     *      7 删除数据数组中的最后一个数据项
     *      8 显示节点中的数据项
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     * 获取当前节点的数据项个数
     * @return
     */
    public int getNumItems()
    {
        return numItems;
    }

    /**
     * 判断数据数组是否已满
     * @return
     */
    public boolean isFull()
    {
        return (numItems==ORDER-1)?true:false;
    }

    /**
     * 判断数据数组是否为空
     * @return
     */
    public boolean isEmpty()
    {
        return (numItems == 0);
    }

    /**
     * 获取指定索引位置上的数据项
     * @param index
     * @return
     */
    public DataItem getItem(int index)
    {
        return itemArray[index];
    }

    /**
     * 根据数据关键字值查找，返回索引；若数组为空或数组中不存在返回-1
     * @param key
     * @return
     */
    public int findItem(long key)
    {
        for(int i=0; i<numItems; i++)
            if(itemArray[i] == null)  // 数组为空或遍历完数组
                break;
            else if(itemArray[i].dData == key)
                return i;

        return -1;
    }

    /**
     * 向数据数组中有序插入一个数据项，返回插入的索引位置，数组已满则返回-1
     * @param newItem
     * @return
     */
    public int insertItem(DataItem newItem)
    {
        if(isFull())  // 数据数组已满，插入失败
            return -1;
        else
        {
            long newKey = newItem.dData;
            int i;
            for(i=numItems-1; i>=0; i--)
            {
                long itsKey = itemArray[i].dData;
                if(newKey < itsKey)
                    itemArray[i+1] = itemArray[i];
                else
                {
                    itemArray[i+1] = newItem;
                    numItems++;
                    return i+1;
                }
            }  // end for
            itemArray[0] = newItem;  // 此时i=0
            numItems++;
            return i+1;
        }  // end else

    }  // end method insertItem

    /**
     * 删除数据数组中的最后一个数据项
     * @return
     */
    public DataItem removeItem()
    {
        if(isEmpty())
            return null;
        else
        {
            DataItem tempItem = itemArray[--numItems];
            itemArray[numItems] = null;
            return tempItem;
        }
    }

    /**
     * 显示节点中的数据项
     */
    public void displayNode()
    {
        for(int i=0; i<numItems; i++)
            itemArray[i].displayItem();
        System.out.println("/");
    }


    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * 父节点操作：
     *      1 获取当前节点的父节点引用
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     * 获取当前节点的父节点引用
     * @return
     */
    public Node getParent()
    {
        return parent;
    }

    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * 子节点操作：
     *      1 将一个节点连接到当前节点的指定索引位置上
     *      2 断开当前节点指定索引位置上的子节点，并返回该子节点的索引
     *      3 获取当前节点指定索引位置上的子节点
     *      4 判断当前节点是否为叶节点
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /**
     * 将一个节点连接到当前节点的指定索引位置上
     * @param childNum
     * @param child
     */
    public void connectChild(int childNum, Node child)
    {
        childArray[childNum] = child;
        if(child != null)
            child.parent = this;
    }

    /**
     * 断开当前节点指定索引位置上的子节点，并返回该子节点的索引
     * @param childNum
     * @return
     */
    public Node disconnectChild(int childNum)
    {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    /**
     * 获取当前节点指定索引位置上的子节点
     * @param childNum
     * @return
     */
    public Node getChild(int childNum)
    {
        return childArray[childNum];
    }

    /**
     * 判断当前节点是否为叶节点
     * @return
     */
    public boolean isLeaf()
    {
        return (childArray[0]==null?true:false);
    }

}  // end class Node
