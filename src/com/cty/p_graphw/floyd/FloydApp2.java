package com.cty.p_graphw.floyd;

/**
 * @Auther: cty
 * @Date: 2020/6/12 15:14
 * @Description: 最小路径问题：在有向带权图中找出某个顶点到其他所有顶点的最小路径
 * @version: 1.0
 */
public class FloydApp2 {
    public static void main(String[] args) {
        Graph graph = new Graph(20);
        graph.addVertex('A');  // 0
        graph.addVertex('B');  // 1
        graph.addVertex('C');  // 2
        graph.addVertex('D');  // 3

        graph.addEdge(1, 0, 70);  // BA 70
        graph.addEdge(1, 3, 10);  // BD 10
        graph.addEdge(2, 0, 30);  // CA 30
        graph.addEdge(3, 2, 20);  // BC 20

        System.out.println("邻接矩阵：");
        graph.displayAdjMat();

        System.out.println();

        graph.floyd();
        System.out.println("传递带权闭包：");
        graph.displayAdjMat();

    }  // end main()

    /**
     * 邻接矩阵：
     * --	--	--	--
     * 70	--	--	10
     * 30	--	--	--
     * --	--	20	--
     *
     * 传递带权闭包：
     * --	--	--	--
     * 60	--	30	10
     * 30	--	--	--
     * 50	--	20	--
     */

}  // end PathApp2
