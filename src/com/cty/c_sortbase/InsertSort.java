package com.cty.c_sortbase;

/**
 * @Auther: cty
 * @Date: 2020/4/28 11:05
 * @Description: 插入排序  O(N^2)
 * @version: 1.0
 */
class ArrayInsert {
    private long[] a;
    private int nElems;

    public ArrayInsert(int max){
        a = new long[max];
        nElems = 0;
    }  // end ArrayInsert()

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
     * 插入排序总结：
     *      交换  s=3  O(1)
     *      插入排序  s=N*(N-1)/4 + N*(N-1)/4  O(N^2)
     * 改进：
     *      对于随机数组，相较于冒泡排序，平均上插入排序将比较次数减少了一半。
     *      对于逆序数组，每次比较和移动都会执行，并不比冒泡排序快，是最坏的情况。
     * 应用场景：
     *      数据量很小
     *      数据基本有序
     * 不变性：
     *      说法一：每次将temp位置的项插入后，下标小于等于out的位置的数据项都是局部有序的。
     *      说法二：下标小于out的位置的数据项都是局部有序的。
     *      局部有序：组内的数据项已经排好序，而组外的数据项需要插入到组中来。
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
     * 插入排序
     * 时间复杂度分析：
     *      s=N*(N-1)/4 + N*(N-1)/4  O(N^2)
     *        比较         交换
     */
    public void InsertSort(){
        int in, out;
        for(out=1; out<nElems; out++){
            long temp = a[out];
            in = out;
            while(in>0 && a[in-1]>=temp){  // = 保证了稳定性
                a[in] = a[in-1];
                --in;
            }  // end while
            a[in] = temp;
        }  // end for
    }  // end InsertSort()

}  // end ArrayInsert{}

class InsertSortApp{
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayInsert arr = new ArrayInsert(maxSize);

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

        arr.InsertSort();

        arr.display();
    }  // end main()

}  // end ArrayInsert{}

/** 2020年4月28日
 77 99 44 55 22 88 11 0 66 33
 0 11 22 33 44 55 66 77 88 99
 */