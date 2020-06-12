package com.cty.o_graph.bfs;

/**
 * @Auther: cty
 * @Date: 2020/6/10 22:49
 * @Description:
 * @version: 1.0
 */
public class Graph {
    private int maxSize;
    private Vertex[] vertexArray;
    private int nVerts;
    private int[][] adjMat;
    private Queue queue;

    public Graph(int maxSize){
        this.maxSize = maxSize;
        vertexArray = new Vertex[maxSize];
        nVerts = 0;
        adjMat = new int[maxSize][maxSize];
        queue = new Queue(maxSize);
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
        System.out.print(vertexArray[v].label + " ");
    }

    public boolean addVertex(char label){
        if(isFull())
            return false;

        vertexArray[nVerts++] = new Vertex(label);
        return true;
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public int getAdjUnvisitedVertex(int v){
        for(int i=0; i<nVerts; i++)
            if(adjMat[v][i] == 1 && vertexArray[i].wasVisited==false)
                return i;
        return -1;
    }

    /**
     * 广度优先搜索
     */
    public void bfs(){
        vertexArray[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);
        int v;

        while(!queue.isEmpty()){
            int curV = queue.remove();
            while((v = getAdjUnvisitedVertex(curV)) != -1){
                vertexArray[v].wasVisited = true;
                displayVertex(v);
                queue.insert(v);
            }  // end while(queue not null)
        }  // end while

        for(int i=0; i<nVerts; i++)
            vertexArray[i].wasVisited = false;

    }  // end bfs()

}  // end Graph{}
