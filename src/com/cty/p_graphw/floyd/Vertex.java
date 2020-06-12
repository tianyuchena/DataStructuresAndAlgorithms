package com.cty.p_graphw.floyd;

/**
 * @Auther: cty
 * @Date: 2020/6/11 22:46
 * @Description:
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
