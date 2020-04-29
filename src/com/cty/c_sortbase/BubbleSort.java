package com.cty.c_sortbase;

/**
 * @Auther: cty
 * @Date: 2020/4/28 11:05
 * @Description: 冒泡排序  O(N^2)
 * 不变性：
 *      算法在执行的过程中存在一些一直成立的条件，可以用来验证算法是否出现错误。
 * 稳定性：
 *      排序时出现相同关键字，排序并不影响这些具有相同关键字的数据的顺序。
 *      三种简单排序都是稳定的。
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
     *        比较         交换
     * 注意：
     *      对于冒泡排序，一般来说交换的次数是比较的一半；
     *      逆序意味着每次比较都要交换，是最坏的情况。
     * 应用场景：
     *      数据量很小
     */
    public void bubbleSort(){
        int in, out;
        for(out=nElems-1; out>0; out--)
            for(in=0; in<out; in++)
                if(a[in] > a[in+1])
                    swap(in, in+1);
    }  // end BubbleSort()


    /** P78-T3.1
     * 双向扫描冒泡排序
     * 时间复杂度分析：
     *      s=N*(N-1)/2 + N*(N-1)/4  O(N^2)
     *        比较         交换
     */
    public void bubbleSort2(){
        int in;
        int outMax = nElems-1;
        int outMin = 0;

        while(outMax > outMin+1){  // 当数据项个数为偶数个时，循环在此结束
            for(in=outMin; in<outMax; in++){
                if(a[in] > a[in+1]){
                    swap(in, in+1);
                }  // end if
            }  // end for
            outMax--;

            if(outMax == outMin+1)  // 当数据项个数为奇数个时，循环在此结束
                break;

            for(in=outMax; in>outMin; in--){
                if(a[in] < a[in-1]){
                    swap(in, in-1);
                }  // end if
            }  // end for
            outMin++;
        }  // end while()
    }  // end BubbleSort2()

    /** P79-T3.4
     * 奇偶排序
     * @return int  奇偶趟扫描的次数
     * 时间复杂的分析： O(N^2)
     *      每趟扫描里，奇数趟和偶数趟都是比较N/2次，平均交换N/4
     *      扫描的次数 <= ⌈N/2⌉，当最大值在最左边或最小值在最右边时等号成立
     */
    public int oddEvenSort(){
        int scanNum = 0;
        while(true){
            int i, j;
            int oddSwapNum = 0;
            int evenSwapNum = 0;

            for(i=1; i<nElems-1; i+=2)  // 奇数趟
                if(a[i] > a[i+1]){
                    swap(i, i+1);
                    oddSwapNum++;
                }

            for(j=0; j<nElems-1; j+=2)  // 偶数趟
                if(a[j] > a[j+1]){
                    swap(j, j+1);
                    evenSwapNum++;
                }

            if(0==oddSwapNum && 0==evenSwapNum)  // 奇数趟和偶数趟都一次没有交换
                return scanNum;

            scanNum++;
        }  // end while
    }  // end oddEvenSort()

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

//        arr.bubbleSort();  // 单向扫描冒泡排序
//        arr.bubbleSort2();  // 双向扫描冒泡排序
        int c = arr.oddEvenSort();
        System.out.println("一共扫描了 "+c+" 次奇偶趟");
        arr.display();
    }  // end main()

}  // end BubbleSortApp{}

/** 2020年4月28日
 77 99 44 55 22 88 11 0 66 33
 0 11 22 33 44 55 66 77 88 99
 */