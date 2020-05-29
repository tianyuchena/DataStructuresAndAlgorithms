package com.cty.m_hashtable.chainaddress;

/**
 * @Auther: cty
 * @Date: 2020/5/25 8:59
 * @Description:
 * @version: 1.0
 */
public class Link {
    private int key;
    private Object data;
    public Link next;

    public Link() {
    }

    public Link(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void displayLink()
    {
        System.out.print(key + " ");
    }
}
