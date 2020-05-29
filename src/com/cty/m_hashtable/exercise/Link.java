package com.cty.m_hashtable.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/27 18:21
 * @Description: 线性探测哈希表存储字符串  P433-T11.2
 * @version: 1.0
 */


/**
 * 数据项
 */
class Link
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

    @Override
    public String toString() {
        return "{" +
                "key=" + key +
                ", data=" + data +
                '}';
    }
}  // end class Link1


