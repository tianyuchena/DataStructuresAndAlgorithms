package com.cty.p_graphw.mstw;

/**
 * @Auther: cty
 * @Date: 2020/6/11 22:42
 * @Description:
 * @version: 1.0
 */
public class Edge {
    public int srcVert;
    public int destVert;
    public int weight;

    public Edge(int srcVert, int destVert, int weight){
        this.srcVert = srcVert;
        this.destVert = destVert;
        this.weight = weight;
    }

}  // end Edge{}
