package com.cty.c_sortbase;

/**
 * @Auther: cty
 * @Date: 2020/4/28 11:05
 * @Description: 选择排序  O(N^2)
 * @version: 1.0
 */
class ArraySelect {
    private long[] a;
    private int nElems;

    public ArraySelect(int max){
        a = new long[max];
        nElems = 0;
    }  // end ArraySelect()

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
     * 选择排序总结：
     *      交换  s=3  O(1)
     *      选择排序  s=N*(N-1)/2 + N  O(N^2)
     * 改进：
     *      相对于冒泡排序，选择排序将交换的次数改善为N次。
     * 应用场景：
     *      数据量很小
     *      交换数据相对于比较数据更加耗时
     * 不变性：
     *      说法一：每次交换后，下标小于等于out的位置的数据项总是（固定）有序的。
     *      说法二：下标小于out的位置的数据项总是（固定）有序的。
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
     * 选择排序
     * 时间复杂度分析：
     *      s=N*(N-1)/2 + N  O(N^2)
     *        比较       交换
     */
    public void selectSort(){
        int in, out, min;
        for(out=0; out<nElems; out++){
            min = out;
            for(in=out+1; in<nElems; in++)  // 先遍历找到最小值
                if(a[in] < a[min])
                    min = in;
            swap(out, min);  // 再交换
        }  // end for

    }  // end SelectSort()

}  // end ArraySelect{}

class SelectSortApp{
    public static void main(String[] args) {
        int maxSize = 100;
        ArraySelect arr = new ArraySelect(maxSize);

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

        arr.selectSort();

        arr.display();
    }  // end main()

}  // end BubbleSortApp{}

/** 2020年4月28日
 77 99 44 55 22 88 11 0 66 33
 0 11 22 33 44 55 66 77 88 99
 */