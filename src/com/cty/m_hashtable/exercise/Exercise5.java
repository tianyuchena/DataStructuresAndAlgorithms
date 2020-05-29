package com.cty.m_hashtable.exercise;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Auther: cty
 * @Date: 2020/5/29 12:11
 * @Description:  P433-T11.5
 * @version: 1.0
 */

public class Exercise5 {
    public static void main(String[] args) {
        int size, n, keysPerCell, aKey;
        Pojo aDataItem;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;  // 设置关键字比率，随机生成的关键字范围为0~keysPerCell*size

        HashTable5 hashTable = new HashTable5(size);
        for(int i=0; i<n; i++)
        {
            int key = (int)(Math.random()*keysPerCell*size);
            hashTable.insert(new Pojo(key));
        }
        hashTable.displayTable();

        while(true)
        {
            System.out.print("Enter first letter of show, insert, delete or find: ");
            char choice = getChar();
            switch (choice)
            {
                case 's':
                    hashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    hashTable.insert(new Pojo(aKey));
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    hashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = hashTable.find(aKey);
                    if(aDataItem != null)
                        System.out.println("Found "+aKey);
                    else
                        System.out.println("Could not find "+aKey);
                    break;
                default:
                    System.out.println("Invalid entry");
            }
            System.out.println();
        }  // end while
    }  // end method main

    /**
     * Enter size of hash table: 5
     * Enter initial number of items: 10
     * hashTable[0]-Inorder traversal: {key=20, dData=0.0}
     * hashTable[1]-Inorder traversal: {key=31, dData=0.0} {key=41, dData=0.0}
     * hashTable[2]-Inorder traversal: {key=2, dData=0.0} {key=7, dData=0.0}
     * hashTable[3]-Inorder traversal: {key=13, dData=0.0} {key=28, dData=0.0}
     * hashTable[4]-Inorder traversal: {key=24, dData=0.0} {key=34, dData=0.0}
     *
     * Enter first letter of show, insert, delete or find: i
     * Enter key value to insert: 26
     *
     * Enter first letter of show, insert, delete or find: s
     * hashTable[0]-Inorder traversal: {key=20, dData=0.0}
     * hashTable[1]-Inorder traversal: {key=26, dData=0.0} {key=31, dData=0.0} {key=41, dData=0.0}
     * hashTable[2]-Inorder traversal: {key=2, dData=0.0} {key=7, dData=0.0}
     * hashTable[3]-Inorder traversal: {key=13, dData=0.0} {key=28, dData=0.0}
     * hashTable[4]-Inorder traversal: {key=24, dData=0.0} {key=34, dData=0.0}
     *
     *
     * Enter first letter of show, insert, delete or find: d
     * Enter key value to delete: 28
     *
     * Enter first letter of show, insert, delete or find: s
     * hashTable[0]-Inorder traversal: {key=20, dData=0.0}
     * hashTable[1]-Inorder traversal: {key=26, dData=0.0} {key=31, dData=0.0} {key=41, dData=0.0}
     * hashTable[2]-Inorder traversal: {key=2, dData=0.0} {key=7, dData=0.0}
     * hashTable[3]-Inorder traversal: {key=13, dData=0.0}
     * hashTable[4]-Inorder traversal: {key=24, dData=0.0} {key=34, dData=0.0}
     *
     *
     * Enter first letter of show, insert, delete or find: f
     * Enter key value to find: 34
     * Found 34
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


}  // end class Exercise5

/**
 * 二叉搜索树实现哈希表
 */
class HashTable5
{
    private int arraySize;
    private BinaryTree[] hashArray;

    public HashTable5(int arraySize)
    {
        this.arraySize = arraySize;
        hashArray = new BinaryTree[arraySize];
        for(int i=0; i<arraySize; i++)
            hashArray[i] = new BinaryTree();
    }

    public void displayTable()
    {
        for(int i=0; i<arraySize; i++)
        {
            System.out.print("hashTable["+i+"]-");
            hashArray[i].traverse(2);  // 中序遍历
            System.out.println();
        }
        System.out.println();
    }

    public long hashFunc(long key)
    {
        return key % arraySize;
    }

    public boolean insert(Pojo data)
    {
        int hashVal = (int)hashFunc(data.getKey());
        return hashArray[hashVal].insert(data);
    }

    public Pojo find(int key)
    {
        int hashVal = (int)hashFunc(key);
        return hashArray[hashVal].find(key);
    }

    public boolean delete(int key)
    {
        int hashVal = (int)hashFunc(key);
        return hashArray[hashVal].delete(key);
    }

}

/**
 * 二叉[搜索]树类
 */
class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    /**
     * 一 查找  O(logN)
     *
     * @param key
     * @return
     */
    public Pojo find(int key) {
        Node current = root;  // 从根节点开始查找
        if(current == null)
            return null;

        while (current.data.getKey() != key)  // 若当前节点关键字值与查找关键字值不相等，则一直循环
        {
            if (key < current.data.getKey())  // 若查找关键字值小于当前节点关键字值
                current = current.leftChild;  // 则前往当前节点的左子节点
            else
                current = current.rightChild;  // 否则前往当前节点的右子节点

            if (null == current)  // 若当前节点为null
                return null;  // 则查找关键字不存在，返回null
        }
        return current.data;  // 当前节点关键字值与查找关键字值相等，则返回当前节点
    }  // end method find


    /**
     * 二 插入  O(logN)
     *
     * @param data
     */
    public boolean insert(Pojo data) {
        Node newNode = new Node(data);

        if(find(data.getKey()) != null)
            return false;  // 关键字已经存在

        if (null == root)
        {
            root = newNode;  // 若为空树，则直接让根节点引用指向新节点
            return true;
        }
        else  // null != root
        {
            Node current = root;  // 从根节点开始查找
            Node parent;

            while (true) {
                parent = current;  // 保留当前节点的引用，插入时用到

                if (newNode.data.getKey() < current.data.getKey())  // 若新节点关键字值小于当前节点关键字值
                {
                    current = current.leftChild;  // 则前往当前节点的左子节点

                    if (null == current)  // 若当前节点的左子节点为null
                    {
                        parent.leftChild = newNode;  // 则将新节点插入当前节点的左子节点
                        return true;  // 并返回
                    }
                }  // end if
                else  // 若新节点的关键字值大于当前节点的关键字值
                {
                    current = current.rightChild;  // 则前往当前节点的右子节点

                    if (null == current)  // 若当前节点的右子节点为null
                    {
                        parent.rightChild = newNode;  // 则将新节点插入当前节点的右子节点右子节点
                        return true;  // 并返回
                    }
                }  // end else
            }  // end while
        }  // end else  // null != root
    }  // end method insert


    /**
     * 三 删除  O(logN)
     *
     * @param key
     * @return
     */
    public boolean delete(int key) {
        /**
         * 查找 -- 三个得到
         *      ① 得到待删除节点的引用 -> current
         *      ② 得到待删除节点的父节点的引用 -> parent
         *      ③ 得到待删除节点为其父节点的左子节点还是右子节点的标记 -> isLeftChild
         */
        Node current = root;  // 从根节点开始查找
        Node parent = root;  // 记录当前节点的父节点引用
        boolean isLeftChild = true;  // 标记当前节点是在父节点的左子节点还是右子节点

        while (current.data.getKey() != key)  // 若当前节点关键字值与删除节点关键字值不相等
        {
            parent = current;  // 记录当前节点引用

            if (key < current.data.getKey())  // 若删除节点关键字值小于当前节点关键字值
            {
                isLeftChild = true;  // 标记进入当前节点的左子节点
                current = current.leftChild;  // 前往当前节点的左子节点
            } else  // 若删除节点关键字值大于当前节点关键字值
            {
                isLeftChild = false;  // 标记进入当前节点的右子节点
                current = current.rightChild;  // 前往当前节点的右子节点
            }

            if (null == current)  // 若子节点为null
                return false;  // 删除节点不存在，返回null
        }  // end while

        /**
         * 删除 -- 四种情况
         *      ① 待删除节点是叶子节点
         *              待删除节点的父节点直接将待删除节点所在的节点位置设置为null
         *      ② 待删除节点只有左子节点
         *              待删除节点的父节点直接将待删除节点所在的节点位置指向待删除节点的左子节点
         *      ③ 待删除节点只有右子节点
         *              待删除节点的父节点直接将待删除节点所在的节点位置指向待删除节点的右子节点
         *      ④ 待删除节点有两个子节点
         *              s1 先查找到待删除节点的后继节点（后继节点的左子节点为null）
         *              s2 然后将后继节点的右子节点设置为后继节点的父节点的左子节点，并将待删除节点的右子节点设置为后继节点的右子节点
         *              s3 接着待删除节点的父节点将待删除节点所在的节点位置指向后继节点
         *              s4 最后将待删除节点的左子节点设置为后继节点的左子节点
         *              注意：若后继节点是待删除节点的右子节点，则s2省略。
         */
        if (current.leftChild == null && current.rightChild == null)  // ① 待删除节点是叶子节点
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        else if (current.rightChild == null)  // ② 待删除节点只有左子节点
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        else if (current.leftChild == null)  // ③ 待删除节点只有右子节点
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        else  // ④ 待删除节点有两个子节点
        {
            Node successor = getSuccessor(current);  // s1 先查找到待删除节点的后继节点（后继节点的左子节点为null）
            // s3 接着待删除节点的父节点将待删除节点所在的节点位置指向后继节点
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            successor.leftChild = current.leftChild;  // s4 最后将待删除节点的左子节点设置为后继节点的左子节点
        }  // end else two child

        return true;  // 删除节点成功
    }  // end method delete

    /**
     * 获取待删除节点的后继节点
     *
     * @param delNode
     * @return
     */
    private Node getSuccessor(Node delNode) {
        Node successor = delNode;  // 记录后继节点引用
        Node successorParent = delNode;  // 记录后继节点父节点引用
        Node current = delNode.rightChild;  // 记录后继节点的子节点，初始为待删除节点的右子节点
        while (current != null)  // 若子节点不为null，则一直遍历左子节点直至为null
        {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        // 额外操作
        if (successor != delNode.rightChild)  // 若后继节点是待删除节点的右子节点
        {
            successorParent.leftChild = successor.rightChild;  // s2 然后将后继节点的右子节点设置为后继节点的父节点的左子节点
            successor.rightChild = delNode.rightChild;  // 并将待删除节点的右子节点设置为后继节点的右子节点
        }

        return successor;  // 左子节点为null的节点即为待删除节点的后继节点，返回
    }  // end method getSuccessor


    /**
     * 四 遍历
     */

    /**
     * 选择遍历类型
     *
     * @param traverseType 1-前序遍历
     *                     2-中序遍历
     *                     3-后序遍历
     */
    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("Preorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("Inorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("Postorder traversal: ");
                postOrder(root);
                break;
        }
    }

    /**
     * 前序遍历
     *
     * @param localRoot
     */
    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            localRoot.displayNode();
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
        }
    }

    /**
     * 中序遍历
     *
     * @param localRoot
     */
    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            localRoot.displayNode();
            inOrder(localRoot.rightChild);
        }
    }

    /**
     * 后序遍历
     *
     * @param localRoot
     */
    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            localRoot.displayNode();
        }
    }


    /**
     * 五 显示树
     */
    public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("............................................................");

        while(!isRowEmpty)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for(int i=0; i<nBlanks; i++)
                System.out.print(' ');

            while(!globalStack.empty())
            {
                Node temp = (Node)globalStack.pop();
                if(temp != null)
                {
                    System.out.print(temp.data.getKey());
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if(temp.leftChild!=null || temp.rightChild!=null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for(int i=0; i<nBlanks*2-2; i++)
                    System.out.print(' ');
            }  // end while !globalStack.empty()

            System.out.println();
            nBlanks /= 2;
            while(!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }  // end while !isRowEmpty

        System.out.println("............................................................");
    }  // end method displayTree

}  // end class BinaryTree

/**
 * 二叉树节点类
 */
class Node
{
    public Pojo data;
    public Node leftChild;
    public Node rightChild;

    public Node(Pojo data) {
        this.data = data;
    }

    public void displayNode()
    {
        System.out.print(data + " ");
    }
}

/**
 * @Auther: cty
 * @Date: 2020/5/15 20:42
 * @Description: 实体类
 *      测试用
 * @version: 1.0
 */
class Pojo
{
    private int key;
    private double dData;

    public Pojo(int key) {
        this.key = key;
    }

    public Pojo(int key, double dData) {
        this.key = key;
        this.dData = dData;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public double getdData() {
        return dData;
    }

    public void setdData(double dData) {
        this.dData = dData;
    }

    @Override
    public String toString() {
        return "{" +
                "key=" + key +
                ", dData=" + dData +
                '}';
    }
}  // end class Pojo


