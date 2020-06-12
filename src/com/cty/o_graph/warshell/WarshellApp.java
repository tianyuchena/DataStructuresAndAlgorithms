package com.cty.o_graph.warshell;

/**
 * @Auther: cty
 * @Date: 2020/6/11 12:09
 * @Description: 无权图（有向或无向） warshell算法——将邻接矩阵修正成传递闭包（可以快速地 O(1) 找出是否一个顶点可以从其他顶点到达）
 * @version: 1.0
 */
public class WarshellApp {
    public static void main(String[] args) {
        Graph graph = new Graph(20);
        graph.addVertex('A');  // 0
        graph.addVertex('B');  // 1
        graph.addVertex('C');  // 2
        graph.addVertex('D');  // 3
        graph.addVertex('E');  // 4

        graph.addEdge(0, 2);  // AC
        graph.addEdge(1, 0);  // BA
        graph.addEdge(1, 4);  // BE
        graph.addEdge(3, 4);  // DE
        graph.addEdge(4, 2);  // EC

        System.out.println("邻接矩阵：");
        graph.displayAdjMat();

        System.out.println();

        graph.warshell();
        System.out.println("传递闭包：");
        graph.displayAdjMat();

    }  // end main()

    /**
     * 邻接矩阵：
     * 0 0 1 0 0
     * 1 0 0 0 1
     * 0 0 0 0 0
     * 0 0 0 0 1
     * 0 0 1 0 0
     *
     * 传递闭包：
     * 0 0 1 0 0
     * 1 0 1 0 1
     * 0 0 0 0 0
     * 0 0 1 0 1
     * 0 0 1 0 0
     */

}  // end TopoApp
