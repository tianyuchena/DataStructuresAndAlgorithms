package com.cty.p_graphw.mstw;

/**
 * @Auther: cty
 * @Date: 2020/6/12 8:23
 * @Description:
 * @version: 1.0
 */
public class Graph {
    private final int INFINITY = 1000000;
    private int maxSize;
    private Vertex[] vertexArray;
    private int nVerts;
    private int currentVertex;
    private int[][] adjMat;
    private PriorityQ PQ;
    private int nTree;

    public Graph(int maxSize){
        this.maxSize = maxSize;
        vertexArray = new Vertex[maxSize];
        nVerts = 0;
        currentVertex = 0;
        adjMat = new int[maxSize][maxSize];
        for(int y=0; y<maxSize; y++)
            for(int x=0; x<maxSize; x++)
                adjMat[y][x] = INFINITY;

        PQ = new PriorityQ(maxSize);
    }

    public boolean isEmpty(){
        return (nVerts == 0);
    }

    public boolean isFull(){
        return (nVerts == maxSize);
    }

    public int size(){
        return nVerts;
    }

    public boolean addVertex(char label){
        if(isFull())
            return false;

        vertexArray[nVerts++] = new Vertex(label);
        return true;
    }

    public void addEdge(int start, int end, int weight){
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }

    /**
     * 将新边放入优先级队列
     * @param destVert
     * @param weight
     */
    private void putInPQ(int destVert, int weight){
        Edge newEdge = new Edge(currentVertex, destVert, weight);
        int queueIndex = PQ.findByDest(destVert);

        if(queueIndex != -1){  // PQ中存在destVert相同的边
            Edge oldEdge = PQ.peekN(queueIndex);
            if(oldEdge.weight > weight){  // 若新边中的权值更小
                PQ.removeN(queueIndex);
                PQ.insert(newEdge);
            }
        }else{  // PQ中不存在destVert相同的边
            PQ.insert(newEdge);
        }
    }  // end putInPQ()

    /**
     * 无向有权图 最小生成树
     */
    public void mstw(){
        currentVertex = 0;

        while(nTree < nVerts-1){  // 当还有顶点没放进树（最后一个节点不用标记放进树，所以nTree最大值为nVerts-2）
            // 当前节点标记放进树
            vertexArray[currentVertex].isInTree = true;
            nTree++;

            // 将新边放进优先级队列
            for(int i=0; i<nVerts; i++){
                if(i == currentVertex)
                    continue;
                if(vertexArray[i].isInTree)
                    continue;
                int weight = adjMat[currentVertex][i];
                if(weight == INFINITY)
                    continue;

                putInPQ(i, weight);
            }

            // 验证优先级队列状态（若还有顶点，但是却找不到边，说明图是非连通的）
            if(PQ.size() == 0)
                return;

            // 从优先级队列中移除最小边，并调整当前顶点
            Edge minEdge = PQ.removeMin();
            int srcVert = minEdge.srcVert;
            currentVertex = minEdge.destVert;

            // 显示新增边
            System.out.print(vertexArray[srcVert].label);
            System.out.print(vertexArray[currentVertex].label);
            System.out.print(" ");
        }  // end while
        System.out.println();

        for(int i=0; i<nVerts; i++)
            vertexArray[i].isInTree = false;
    }  // end mstw()


}  // end Graph{}
