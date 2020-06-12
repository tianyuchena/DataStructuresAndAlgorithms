package com.cty.p_graphw.path;

/**
 * @Auther: cty
 * @Date: 2020/6/12 11:55
 * @Description: 权重和父顶点类
 * @version: 1.0
 */
public class DistPar {
    public int distance;
    public int parent;

    public DistPar(int distance, int parent){
        this.distance = distance;
        this.parent = parent;
    }
}
