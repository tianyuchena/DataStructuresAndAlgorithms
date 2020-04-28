package com.cty.c_sortbase;

/**
 * @Auther: cty
 * @Date: 2020/4/28 11:05
 * @Description: 冒泡排序  O(N^2)
 * @version: 1.0
 */
class ArrayBubble {
    private long[] a;
    private int nElems;

    public ArrayBubble(int max){
        a = new long[max];
        nElems = 0;
    }  // end ArrayBubble()

    public void display(){
        int i;
        for(i=0; i<nElems; i++){
            System.out.print(a[i] + " ");
        }  // end for
        System.out.println("");
    }  // end display()

    public boolean insert(long value){
        if(nElems == a.length){
            return false;
        }else{
            a[nElems] = value;
            nElems++;
            return true;
        }  // end else
    }  // end insert()

    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * 冒泡排序总结：
     *      交换  s=3  O(1)
     *      冒泡排序  s=N*(N-1)/2 + N*(N-1)/4  O(N^2)
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /**
     * 交换
     * @param one  待交换值1的索引
     * @param two  待交换值2的索引
     * 时间复杂度分析：
     *      s=3  O(1)
     */
    private void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }  // end swap()

    /**
     * 冒泡排序
     * 时间复杂度分析：
     *      s=N*(N-1)/2 + N*(N-1)/4  O(N^2)
     */
    public void BubbleSort(){
        int in, out;
        for(out=nElems-1; out>0; out--)
            for(in=0; in<out; in++)
                if(a[in] > a[in+1])
                    swap(in, in+1);
    }  // end BubbleSort()

}  // end ArrayBubble{}

class BubbleSortApp{
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBubble arr = new ArrayBubble(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        arr.BubbleSort();

        arr.display();
    }  // end main()

}  // end BubbleSortApp{}

/** 2020年4月28日
 77 99 44 55 22 88 11 0 66 33
 0 11 22 33 44 55 66 77 88 99
 */