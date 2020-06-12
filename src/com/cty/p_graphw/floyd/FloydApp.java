package com.cty.p_graphw.floyd;

/**
 * @Auther: cty
 * @Date: 2020/6/12 15:14
 * @Description: 最小路径问题：在带权图（有向或无向）中找出某个顶点到其他所有顶点的最小路径
 * @version: 1.0
 */
public class FloydApp {
    public static void main(String[] args) {
        Graph graph = new Graph(20);
        graph.addVertex('A');  // 0
        graph.addVertex('B');  // 1
        graph.addVertex('C');  // 2
        graph.addVertex('D');  // 3
        graph.addVertex('E');  // 4

        graph.addEdge(0, 1, 50);  // AB 50
        graph.addEdge(0, 3, 80);  // AD 80
        graph.addEdge(1, 2, 60);  // BC 60
        graph.addEdge(1, 3, 90);  // BD 90
        graph.addEdge(2, 4, 40);  // CE 40
        graph.addEdge(3, 2, 20);  // DC 20
        graph.addEdge(3, 4, 70);  // DE 70
        graph.addEdge(4, 1, 50);  // EB 50

        System.out.println("邻接矩阵：");
        graph.displayAdjMat();

        System.out.println();

        graph.floyd();
        System.out.println("传递带权闭包：");
        graph.displayAdjMat();

    }  // end main()

    /**
     * 邻接矩阵：
     * --	50	--	80	--
     * --	--	60	90	--
     * --	--	--	--	40
     * --	--	20	--	70
     * --	50	--	--	--
     *
     * 传递带权闭包：
     * --	50	100	80	140
     * --	--	60	90	100
     * --	90	--	180	40
     * --	110	20	--	60
     * --	50	110	140	--
     */

}  // end PathApp
