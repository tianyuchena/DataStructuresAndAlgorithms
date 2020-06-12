package com.cty.o_graph.topo;

/**
 * @Auther: cty
 * @Date: 2020/6/11 11:25
 * @Description:
 * @version: 1.0
 */
public class Graph {
    private int maxSize;
    private Vertex[] vertexArray;
    private int nVerts;
    private int[][] adjMat;
    private char[] sortedArray;

    public Graph(int size){
        maxSize = size;
        vertexArray = new Vertex[maxSize];
        nVerts = 0;
        adjMat = new int[maxSize][maxSize];
        sortedArray = new char[maxSize];
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

    public void displayVertex(int v){
        System.out.print(vertexArray[v].label);
    }

    public boolean addVertex(char label){
        if(isFull())
            return false;

        vertexArray[nVerts++] = new Vertex(label);
        return true;
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
    }

    /**
     * 获取第一个没有后继的节点
     * @return
     */
    public int noSuccessors(){
        boolean hasSuccessors;

        for(int row=0; row<nVerts; row++){
            hasSuccessors = false;
            for(int col=0; col<nVerts; col++)
                if(adjMat[row][col] > 0){
                    hasSuccessors = true;
                    break;
                }

            if(!hasSuccessors)
                return row;
        }  // end for(row)

        return -1;
    }  // end noSuccessors()

    /**
     * 删除指定节点
     * @param delVert
     */
    public void deleteVertex(int delVert){
        if(delVert != maxSize-1){
            // vertexArray中删除
            for(int i=delVert; i<nVerts-1; i++)
                vertexArray[i] = vertexArray[i+1];

            // adjMat中删除行
            for(int i=delVert; i<nVerts-1; i++)
                for(int j=0; j<nVerts; j++)
                    adjMat[i][j] = adjMat[i+1][j];

            // adjMat中删除列
            for(int i=0; i<nVerts; i++)
                for(int j=delVert; j<nVerts-1; j++)
                    adjMat[i][j] = adjMat[i][j+1];
        }
        nVerts--;
    }  // end deleteVertex()

    /**
     * 拓扑排序
     */
    public void topo(){  // topological sort
        int orig_nVerts = nVerts;

        while(nVerts > 0){
            int delVert = noSuccessors();
            if(delVert == -1){  // 有节点但无没有后继的节点，说明图存在环
                System.out.println("ERRORS: Graph has cycle");
                return;
            }

            sortedArray[nVerts-1] = vertexArray[delVert].label;  // 将无后继节点存入排序数组
            deleteVertex(delVert);  // 删除节点
        }  // end while

        System.out.println("topological sort: ");  // 显示拓扑排序结果
        for(int i=0; i<orig_nVerts; i++)
            System.out.print(sortedArray[i] + " ");
        System.out.println();

    }  // end topo()

}  // end Graph{}
