package com.cty.n_heap;

import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/6/8 19:26
 * @Description:
 * @version: 1.0
 */
public class HeapSortApp {
    public static void main(String[] args) {
        int size, j;

        // 获取初始化数组
        System.out.print("Enter number of items: ");
        size = getInt();
        Heap theHeap = new Heap(size);
        for(j=0; j<size; j++){
            int random = (int)(Math.random()*100);
            Node newNode = new Node(random);
            theHeap.insertAt(j, newNode);
            theHeap.incrementSize();
        }  // end for
        System.out.println("初始化数组");
        theHeap.displayArray();

        System.out.println("将无序数组转化为堆");
        for(j=size/2 -1; j>=0; j--)
            theHeap.trickleDown(j);
        theHeap.displayHeap();

        System.out.println("堆排序");
        for(j=size-1; j>=0; j--){
            Node biggestNode = theHeap.remove();
            theHeap.insertAt(j, biggestNode);
        }
        theHeap.displayArray();
    }  // end main()

    /**
     * Enter number of items: 10
     * 初始化数组
     * heapArray:
     * 57 12 55 35 44 35 80 18 52 42
     * ............................................................
     * 将无序数组转化为堆
     * heap:
     *                                 80
     *                 52                              57
     *         35              44              35              55
     *     18      12      42
     * ............................................................
     * 堆排序
     * heapArray:
     * 12 18 35 35 42 44 52 55 57 80
     * ............................................................
     */

    public static String getString(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static int getInt(){
        String s = getString();
        return Integer.parseInt(s);
    }

    public static char getChar(){
        String s = getString();
        return s.charAt(0);
    }
}  // end HeapSortApp{}
