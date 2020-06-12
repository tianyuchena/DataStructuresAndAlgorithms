package com.cty.o_graph.bfs;

/**
 * @Auther: cty
 * @Date: 2020/6/10 22:46
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
