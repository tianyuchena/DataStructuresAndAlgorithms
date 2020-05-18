package com.cty.k_binarytree.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/15 20:41
 * @Description: P322-T8.2
 * @version: 1.0
 */
import java.util.Scanner;
import java.util.Stack;

class Exercise2App
{
    public static void main(String[] args) {
        BinaryCharTree2 tree = new BinaryCharTree2();
        tree.createTree();
        tree.displayTree();
//        tree.traverse(2);
    }  // end method main

    /**
     * Enter a string: ABCDE
     * ............................................................
     *                                 +
     *                 +                               +
     *         A               B               C               D
     *     E       --      --      --      --      --      --      --
     * ............................................................
     *
     * Enter a string: ABCDEF
     * ............................................................
     *                                 +
     *                 +                               +
     *         A               B               C               D
     *     +       --      --      --      --      --      --      --
     *   E   F   --  --  --  --  --  --  --  --  --  --  --  --  --  --
     * ............................................................
     */

}  // end class Exercise1App


/**
 * 二叉[字符]树类
 */
class BinaryCharTree2 {
    private Node root;

    public BinaryCharTree2() {
        root = null;
    }


    public void createTree()
    {
        // 获取用户输入字符串
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scan.nextLine();

        // 为字符串创建节点并存放到数组中
        FirstLastList<Node> nodes = new FirstLastList<>();
        for(int i=0; i<str.length(); i++)
            nodes.insertLast(new Node(new Pojo1(str.charAt(i))));

        // 创建二叉字符树
        while(!nodes.isLeftOne())
        {
            FirstLastList<Node> tempNodes = new FirstLastList<>();
            Node leftNode = null;

            // 两两合并节点
            while(!nodes.isEmpty())
            {
                Node left = nodes.deleteFirst();
                if(nodes.isEmpty())
                {
                    leftNode = left;
                    break;
                }
                Node right = nodes.deleteFirst();
                Node newNode = new Node(new Pojo1('+'));
                newNode.leftChild = left;
                newNode.rightChild = right;
                tempNodes.insertLast(newNode);
            }

            // 如果有剩余节点，放到第一个合并节点的最左子孙节点
            if(leftNode != null)
            {
                Node current = tempNodes.peekFirst();
                while(current.leftChild != null)
                    current = current.leftChild;
                current.leftChild = leftNode;
            }

            // 将临时列表中的节点放回原列表
            while(!tempNodes.isEmpty())
                nodes.insertLast(tempNodes.deleteFirst());
        }



        root = nodes.deleteFirst();
    }


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
                System.out.println("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.println("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.println("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
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
                    System.out.print(temp.data.getcData()+" ");
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

}  // end class BinaryCharTree
