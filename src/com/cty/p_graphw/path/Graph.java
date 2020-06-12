package com.cty.p_graphw.path;

/**
 * @Auther: cty
 * @Date: 2020/6/12 11:59
 * @Description:
 * @version: 1.0
 */
public class Graph {
    private final int INFINITY = 1000000;
    private int maxSize;

    private Vertex[] vertexArray;
    private int nVerts;
    private int nTrees;

    private int[][] adjMat;

    private DistPar[] sPath;  // 存储起始顶点到各个顶点的最短距离

    private int currentVertex;
    private int startToCurrent;

    public Graph(int maxSize){
        this.maxSize = maxSize;

        vertexArray = new Vertex[maxSize];
        nVerts = 0;
        nTrees = 0;

        adjMat = new int[maxSize][maxSize];
        for(int y=0; y<maxSize; y++)
            for(int x=0; x<maxSize; x++)
                adjMat[y][x] = INFINITY;
        sPath = new DistPar[maxSize];
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
    }

    /**
     * 从sPath中获取拥有到达新顶点最短路径的顶点索引
     * @return
     */
    public int getMin(){
        int minDist = INFINITY;
        int indexMin = 0;

        for(int i=0; i<nVerts; i++)
            if(!vertexArray[i].isInTree && sPath[i].distance <minDist){
                minDist = sPath[i].distance;
                indexMin = i;
            }
        return indexMin;
    }

    /**
     * 到达新顶点后，修正起始点到其他顶点的最短距离
     */
    public void adjust_sPath(){
        for(int col=0; col<nVerts; col++){
            if(vertexArray[col].isInTree)  // 已经在树中的顶点不用考虑
                continue;

            int currentToFringe = adjMat[currentVertex][col];
            int startToFringe = startToCurrent + currentToFringe;  // 当前从顶点到索引为col的顶点的距离
            int sPathDist = sPath[col].distance;  // sPath中记录的从顶点到索引为col的顶点的距离

            if(startToFringe < sPathDist){
                sPath[col].distance = startToFringe;
                sPath[col].parent = currentVertex;
            }
        }  // end for
    }  // end adjust_sPath

    public void displayPaths(){
        for(int i=0; i<nVerts; i++){
            char cur = vertexArray[i].label;
            char par = vertexArray[sPath[i].parent].label;
            int dist = sPath[i].distance;

            System.out.print(cur + "=" + ((dist==INFINITY)?"inf":dist) + "(" + par + ") ");
        }
        System.out.println();
    }

    public void path(int startVertex){
        // 选择起始顶点
        int startTree = startVertex;
        vertexArray[startTree].isInTree = true;
        nTrees = 1;

        // 将邻接矩阵的第一行数据信息放入sPath
        for(int i=0; i<nVerts; i++){
            int distance = adjMat[startTree][i];
            sPath[i] = new DistPar(distance, startTree);
        }

        // 依次计算起始顶点到各顶点的最短距离
        while(nTrees < nVerts){  // 最后一个顶点也要计算，所以nTrees最大值为nVerts-1
            int indexMin = getMin();  // 从sPath中获取拥有到达新顶点最短路径的顶点索引 【1】
            int minDistance = sPath[indexMin].distance;

            // 检验当前节点的是否连通，一个连通的节点至少有一条到达其他顶点的边是有限值
            if(minDistance == INFINITY){
                System.out.println("遇到非连通顶点");
                break;
            }else{
                currentVertex = indexMin;  // 到达新顶点
                startToCurrent = sPath[indexMin].distance;  // 记录起始点到新顶点的距离
            }

            vertexArray[currentVertex].isInTree = true;
            nTrees++;
            adjust_sPath();  // 到达新顶点后，更新sPath 【2】
        }  // end while

        displayPaths();  // 显示sPath中信息 【3】

        nTrees = 0;
        for(int i=0; i<nVerts; i++)
            vertexArray[i].isInTree = false;
    }  // end path()


}  // end Graph
