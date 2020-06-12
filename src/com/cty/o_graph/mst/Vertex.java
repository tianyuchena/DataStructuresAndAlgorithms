package com.cty.o_graph.mst;

/**
 * @Auther: cty
 * @Date: 2020/6/10 20:52
 * @Description:
 * @version: 1.0
 */
public class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char label){
        this.label = label;
        wasVisited = false;
    }

}  // end Vertex{}
