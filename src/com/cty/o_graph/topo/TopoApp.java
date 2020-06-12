package com.cty.o_graph.topo;

/**
 * @Auther: cty
 * @Date: 2020/6/11 12:09
 * @Description:
 * @version: 1.0
 */
public class TopoApp {
    public static void main(String[] args) {
        Graph graph = new Graph(20);
        graph.addVertex('A');  // 0
        graph.addVertex('B');  // 1
        graph.addVertex('C');  // 2
        graph.addVertex('D');  // 3
        graph.addVertex('E');  // 4
        graph.addVertex('F');  // 5
        graph.addVertex('G');  // 6
        graph.addVertex('H');  // 7

        graph.addEdge(0, 3);  // AD
        graph.addEdge(0, 4);  // AE
        graph.addEdge(1, 4);  // BE
        graph.addEdge(2, 5);  // CF
        graph.addEdge(3, 6);  // DG
        graph.addEdge(4, 6);  // EG
        graph.addEdge(5, 7);  // FH
        graph.addEdge(6, 7);  // GH

        graph.topo();

    }  // end main()

    /**
     * topological sort:
     * B A E D G C F H
     */

}  // end TopoApp
