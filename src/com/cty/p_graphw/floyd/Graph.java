package com.cty.p_graphw.floyd;

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

    public void displayAdjMat(){
        for(int y=0; y<nVerts; y++){
            for(int x=0; x<nVerts; x++)
                System.out.print(((adjMat[y][x]==INFINITY)?"--":adjMat[y][x]) + "\t");
            System.out.println();
        }
    }  // end displayAdjMat()

    public boolean addVertex(char label){
        if(isFull())
            return false;

        vertexArray[nVerts++] = new Vertex(label);
        return true;
    }

    public void addEdge(int start, int end, int weight){
        adjMat[start][end] = weight;
    }

    public void floyd(){
        for(int y=0; y<nVerts; y++)
            for(int x=0; x<nVerts; x++)
                if(adjMat[y][x] != INFINITY)
                    for(int z=0; z<nVerts; z++)
                        if(z!=x && adjMat[z][y]!=INFINITY && (adjMat[z][y]+adjMat[y][x])<adjMat[z][x])
                            adjMat[z][x] = adjMat[z][y] + adjMat[y][x];
    }  // end floyd
}  // end Graph{}
