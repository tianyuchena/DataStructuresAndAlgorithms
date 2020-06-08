package com.cty.n_heap;

/**
 * @Auther: cty
 * @Date: 2020/6/8 15:55
 * @Description:
 * @version: 1.0
 */
class Node {
    private int iData;

    public Node(int key)
    {
        iData = key;
    }

    public int getKey()
    {
        return iData;
    }

    public void setKey(int key)
    {
        iData = key;
    }
}
