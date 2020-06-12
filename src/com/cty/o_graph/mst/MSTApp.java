package com.cty.o_graph.mst;

/**
 * @Auther: cty
 * @Date: 2020/6/10 21:27
 * @Description: 无向图 深度优先搜索实现最小生成树
 * @version: 1.0
 */
public class MSTApp {
    public static void main(String[] args){
        Graph graph = new Graph(20);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println("MST: ");
        graph.mst();

    }  // end main()

    /**
     * MST:
     * AB BC CD DE
     */

}  // end DFSApp
