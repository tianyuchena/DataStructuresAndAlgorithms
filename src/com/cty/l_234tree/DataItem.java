package com.cty.l_234tree;

/**
 * @Auther: cty
 * @Date: 2020/5/21 16:52
 * @Description: 数据项
 * @version: 1.0
 */
public class DataItem
{
    public long dData;

    public DataItem(long dd)
    {
        dData = dd;
    }

    public void displayItem()
    {
        System.out.print("/" + dData);
    }
}
