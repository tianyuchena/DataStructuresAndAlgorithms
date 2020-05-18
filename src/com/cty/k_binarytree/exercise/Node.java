package com.cty.k_binarytree.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/17 11:48
 * @Description:
 * @version: 1.0
 */

/**
 * 二叉树节点类
 */
class Node
{
    public Pojo1 data;
    public Node leftChild;
    public Node rightChild;

    public Node() {
    }

    public Node(Pojo1 data) {
        this.data = data;
    }

    public void displayNode()
    {
        System.out.println(data);
    }
}

/**
 * 二叉树数据节点
 */
class Pojo1
{
    char cData;

    public Pojo1(char cData) {
        this.cData = cData;
    }

    public char getcData() {
        return cData;
    }

    public void setcData(char cData) {
        this.cData = cData;
    }

    @Override
    public String toString() {
        return "Pojo1{" +
                "cData=" + cData +
                '}';
    }
}
