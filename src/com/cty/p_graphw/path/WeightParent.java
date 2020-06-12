package com.cty.p_graphw.path;

/**
 * @Auther: cty
 * @Date: 2020/6/12 11:55
 * @Description: 权重和父顶点类
 * @version: 1.0
 */
public class WeightParent {
    public int weight;
    public int parent;

    public WeightParent(int weight, int parent){
        this.weight = weight;
        this.parent = parent;
    }
}
