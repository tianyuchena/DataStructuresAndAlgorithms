package com.cty.o_graph.warshell;

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

    public void displayAdjMat(){
        for(int y=0; y<nVerts; y++){
            for(int x=0; x<nVerts; x++)
                System.out.print(adjMat[y][x] + " ");
            System.out.println();
        }
    }  // end displayAdjMat()

    public boolean addVertex(char label){
        if(isFull())
            return false;

        vertexArray[nVerts++] = new Vertex(label);
        return true;
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
    }

    public void warshell(){
        for(int y=0; y<nVerts; y++)  // 行
            for(int x=0; x<nVerts; x++)  // 列
                if(adjMat[y][x] == 1)
                    for(int z=0; z<nVerts; z++)  // 有z的时候，z作为行，y作为列
                        if(z!=x && adjMat[z][y]==1 && adjMat[z][x]!=1)
                            adjMat[z][x] = 1;
    }  // end warshell()

}  // end Graph{}
