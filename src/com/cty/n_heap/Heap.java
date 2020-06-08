package com.cty.n_heap;

/**
 * @Auther: cty
 * @Date: 2020/6/8 15:57
 * @Description:
 * @version: 1.0
 */
public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize)
    {
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty()
    {
        return (currentSize == 0);
    }

    /**
     * 插入  O(logN)
     * @param key
     * @return
     */
    public boolean insert(int key)
    {
        if(currentSize == maxSize)
            return false;  // 数组已满

        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    /**
     * 删除  O(logN)
     * @return
     */
    public Node remove()
    {
        if(isEmpty())
            return null;
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    /**
     * 改变关键字
     * @param index
     * @param newValue
     * @return
     */
    public boolean change(int index, int newValue)
    {
        if(index<0 || index>currentSize)
            return false;

        int oldValue = heapArray[index].getKey();
        heapArray[index] = new Node(newValue);

        if(newValue > oldValue)
            trickleUp(index);
        else
            trickleDown(index);
        return true;
    }

    /**
     * 向上筛选
     * @param index
     */
    public void trickleUp(int index)
    {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];

        while(index > 0 && bottom.getKey() > heapArray[parent].getKey())
        {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (index - 1) / 2;
        }  // end while
        heapArray[index] = bottom;
    }  // end trickleUp()

    /**
     * 向下筛选
     * @param index
     */
    public void trickleDown(int index)
    {
        int largeChild;
        Node top = heapArray[index];

        while(index < currentSize/2)  // 至少有一个左节点
        {
            // 找出最大子节点
            int leftChild = 2*index + 1;
            int rightChild = leftChild + 1;
            if(rightChild < currentSize && heapArray[rightChild].getKey() > heapArray[leftChild].getKey())
                largeChild = rightChild;
            else
                largeChild = leftChild;

            // 交换
            if(top.getKey() >= heapArray[largeChild].getKey())
                break;

            heapArray[index] = heapArray[largeChild];
            index = largeChild;
        }  // end while
        heapArray[index] = top;
    }  // end trickleDown()

    public void displayArray()
    {
        System.out.println("heapArray: ");
        for(int m=0; m<maxSize; m++)  // 显示数组全部内容
            if(heapArray[m] != null)
                System.out.print(heapArray[m].getKey() + " ");
            else
                System.out.print("-- ");
        System.out.println();
        String dots = "..............................";
        System.out.println(dots + dots);
    }

    public void displayHeap()
    {
        System.out.println("heap: ");
        String dots = "..............................";

        int nBlanks = 32;
        int itemPerRow = 1;
        int column = 0;
        int j = 0;

        while(currentSize > 0)
        {
            if(column == 0)
                for(int k=0; k<nBlanks; k++)
                    System.out.print(' ');

            System.out.print(heapArray[j].getKey());

            if(++j == currentSize)
                break;

            if(++column == itemPerRow)
            {
                nBlanks /= 2;
                itemPerRow *= 2;
                column = 0;
                System.out.println();
            }else{
                for(int i=0; i<2*nBlanks-2; i++)
                    System.out.print(' ');
            }  // end else
        }  // end while
        System.out.println("\n" + dots + dots);
    }  // end display()

    /**
     * 堆排序使用方法
     */
    public void insertAt(int index, Node newNode){
        heapArray[index] = newNode;
    }

    public void incrementSize(){
        currentSize++;
    }

}  // end Heap{}
