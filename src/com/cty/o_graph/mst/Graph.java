package com.cty.o_graph.mst;

/**
 * @Auther: cty
 * @Date: 2020/6/10 21:00
 * @Description:
 * @version: 1.0
 */
public class Graph {
    private int maxSize;
    private Vertex[] vertexArray;
    private int nVerts;
    private int[][] adjMat;
    private StackX stack;

    public Graph(int maxSize){
        this.maxSize = maxSize;
        vertexArray = new Vertex[maxSize];
        nVerts = 0;
        adjMat = new int[maxSize][maxSize];
        stack = new StackX(maxSize);
    }

    /**
     * 添加节点
     * @param label
     */
    public void addVertex(char label){
        vertexArray[nVerts++] = new Vertex(label);
    }

    /**
     * 添加边
     * @param start
     * @param end
     */
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    /**
     * 显示当前节点
     * @param v
     */
    public void displayVertex(int v){
        System.out.print(vertexArray[v].label);
    }

    /**
     * 获取当前节点的下一个节点
     * @param v
     * @return
     */
    public int getAdjUnvisitedVertex(int v){
        for(int i=0; i<nVerts; i++)
            if(adjMat[v][i] == 1 && vertexArray[i].wasVisited==false)
                return i;
        return -1;
    }

    /**
     * 深度优先搜索
     */
    public void mst(){
        vertexArray[0].wasVisited = true;
        stack.push(0);

        while(!stack.isEmpty()){
            int cerV = stack.peek();
            int v = getAdjUnvisitedVertex(stack.peek());
            if(v == -1)
                stack.pop();
            else {
                vertexArray[v].wasVisited = true;
                stack.push(v);

                displayVertex(cerV);
                displayVertex(v);
                System.out.print(" ");
            }  // end else
        }  // end while
        System.out.println();

        for(int i=0; i<nVerts; i++)
            vertexArray[i].wasVisited = false;

    }  // end dfs()

}  // end Graph{}
