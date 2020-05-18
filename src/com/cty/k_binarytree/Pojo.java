package com.cty.k_binarytree;

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

    public Pojo(int key, double dData) {
        this.key = key;
        this.dData = dData;
    }

    public long getKey() {
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
        return "Pojo{" +
                "key=" + key +
                ", dData=" + dData +
                '}';
    }
}  // end class Pojo
