package com.cty.m_hashtable.openaddress;

/**
 * @Auther: cty
 * @Date: 2020/5/23 15:22
 * @Description: 数据项
 * @version: 1.0
 */
public class Link
{
    private int key;
    private Object data;

    public Link(int key) {
        this.key = key;
    }

    public Link(int key, Object data) {
        this.key = key;
        this.data = data;
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
}  // end class DataItem
