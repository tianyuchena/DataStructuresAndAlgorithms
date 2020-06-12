package com.cty.p_graphw.mstw;

/**
 * @Auther: cty
 * @Date: 2020/6/11 22:58
 * @Description:
 * @version: 1.0
 */
public class PriorityQ {
    private int maxSize;
    private Edge[] queArray;
    private int nItems;

    public PriorityQ(int maxSize){
        this.maxSize = maxSize;
        queArray = new Edge[maxSize];
        nItems = 0;
    }

    public boolean isEmpty(){
        return (nItems == 0);
    }

    public boolean isFull(){
        return (nItems == maxSize);
    }

    public int size(){
        return nItems;
    }

    public boolean insert(Edge edge){
        if(isFull())
            return false;

        int i;
        for(i=nItems-1; i>=0; i--){
            if(edge.weight > queArray[i].weight)
                queArray[i+1] = queArray[i];
            else
                break;
        }
        queArray[i+1] = edge;
        nItems++;
        return true;
    }

    public Edge removeMin(){
        if(isEmpty())
            return null;

        return queArray[--nItems];
    }

    public Edge removeN(int n){
        if(isEmpty())
            return null;

        Edge temp = queArray[n];
        for(int i=n; i<nItems-1; i++)
            queArray[i] = queArray[i+1];
        nItems--;
        return temp;
    }

    public Edge peekN(int n){
        return queArray[n];
    }

    public int findByDest(int destVert){
        for(int i=0; i<nItems; i++)
            if(queArray[i].destVert == destVert)
                return i;
        return -1;
    }

}  // end PriorityQ{}
