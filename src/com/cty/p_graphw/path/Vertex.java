package com.cty.p_graphw.path;

/**
 * @Auther: cty
 * @Date: 2020/6/12 11:57
 * @Description: 顶点类
 * @version: 1.0
 */
public class Vertex {
    public char label;
    public boolean isInTree;

    public Vertex(char label){
        this.label = label;
        isInTree = false;
    }

}  // end Vertex{}
