package com.cty.o_graph.bfs;


/**
 * @Auther: cty
 * @Date: 2020/6/10 21:27
 * @Description: 无向图 广度优先搜索
 * @version: 1.0
 */
public class BFSApp {
    public static void main(String[] args){
        Graph graph = new Graph(20);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.println("BFS: ");
        graph.bfs();
        System.out.println();

    }  // end main()

    /**
     * BFS:
     * A B D C E
     */

}  // end DFSApp
