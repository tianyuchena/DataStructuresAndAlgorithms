package com.cty.o_graph.dfs;

/**
 * @Auther: cty
 * @Date: 2020/6/10 21:27
 * @Description: 无向图 深度优先搜索
 * @version: 1.0
 */
public class DFSApp {
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

        System.out.println("DFS: ");
        graph.dfs();

    }  // end main()

    /**
     * DFS:
     * A B C D E
     */

}  // end DFSApp
