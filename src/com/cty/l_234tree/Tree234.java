package com.cty.l_234tree;

import javax.xml.crypto.Data;

/**
 * @Auther: cty
 * @Date: 2020/5/21 19:59
 * @Description: 234树
 * @version: 1.0
 */
public class Tree234
{
    protected Node root = new Node();

    /**
     * 根据关键字值获取指定节点相应的子节点
     * @param theNode
     * @param theValue
     * @return
     */
    public Node getNextNode(Node theNode, long theValue)
    {
        // 假设theNode节点非空、非满且不是叶节点
        int i;
        int numItems = theNode.getNumItems();
        for(i=0; i<numItems; i++)
            if(theValue < theNode.getItem(i).dData)
                return theNode.getChild(i);
        return theNode.getChild(i);
    }

    /**
     * 根据关键字查找，返回目标节点的目标数据项的索引；若没查找到，则返回-1
     * @param key
     * @return
     */
    public int find(long key)
    {
        Node curNode = root;
        int childNumber;

        while(true)
        {
            if((childNumber=curNode.findItem(key)) != -1)  // -1代表节点为空或数据不存在，不是-1说明查找成功
                return childNumber;
            else if(curNode.isLeaf())  // 遇到叶子节点，查找失败
                return -1;
            else  // 当前非叶子节点，则走向下一个子节点
                curNode = getNextNode(curNode, key);
        }  // end while
    }  // end method find

    /**
     * 插入
     * @param value
     */
    public void insert(long value)
    {
        DataItem item = new DataItem(value);
        Node curNode = root;

        // 找到待插入节点
        while(true)
        {
            if(curNode.isFull())
            {
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextNode(curNode, value);  // 父节点一定有子节点
            }
            else if(curNode.isLeaf())  // 遇到非满子节点，即为待插入位置
                break;
            else
                curNode = getNextNode(curNode, value);  // 不是叶子节点，即有子节点，继续向下查找
        }

        // 插入
        curNode.insertItem(item);
    }  // end method insert

    /**
     * 将已满节点分裂
     * @param thisNode
     */
    public void split(Node thisNode)
    {
        // 声明或存储待处理节点和数据
        Node parent;
        Node rightNode = new Node();  // 创建右边的兄弟节点
        Node child2 = thisNode.getChild(2);  // 存放第三个子节点
        Node child3 = thisNode.getChild(3);  // 存放第四个子节点
        DataItem itemC = thisNode.removeItem();  // 移除第四个子节点
        DataItem itemB = thisNode.removeItem();  // 移除第三个子节点

        // 获取父节点（两种情况，当前节点是否为root节点）
        if(thisNode == root)
        {
            root = new Node();
            parent = root;
            parent.connectChild(0, thisNode);
        }
        else
            parent = thisNode.getParent();

        // 将itemB放入父节点
        int itemIndex = parent.insertItem(itemB);

        // 将itemC放入右兄弟节点
        rightNode.insertItem(itemC);

        // 将两个子节点连接到右兄弟节点
        rightNode.connectChild(0, child2);
        rightNode.connectChild(1, child3);

        // 将父节点的子节点数组中，索引值大于thisNode子节点索引的子节点上移（给右兄弟节点的连接留出空位）
        int n = parent.getNumItems();
        for(int i=n-1; i>itemIndex; i--)  // n-1是插入前子节点最大的索引，itemIndex是thisNode子节点的索引
        {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i+1, temp);
        }
        // 将右兄弟节点连接到父节点
        parent.connectChild(itemIndex+1, rightNode);
    }

    /**
     * 显示234树
     */
    public void displaytree()
    {
        recDisplayTree(root, 0, 0);
    }

    /**
     * 递归实现显示234树
     * @param thisNode
     * @param level
     * @param childNumber
     */
    public void recDisplayTree(Node thisNode, int level, int childNumber)
    {
        // 显示当前节点
        System.out.print("level="+level+" child="+childNumber+" ");
        thisNode.displayNode();

        // 递归显示所有子节点
        int numItems = thisNode.getNumItems();
        for(int i=0; i<=numItems; i++)
        {
            Node child = thisNode.getChild(i);
            if(child != null)
                recDisplayTree(child, level+1, i);
            else
                return;
        }
    }

}  // end class Tree234
