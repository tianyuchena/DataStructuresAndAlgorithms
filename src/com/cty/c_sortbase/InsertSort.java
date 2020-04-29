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
    public void insertSort(){
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

    /** P79-T3.5
     * 插入排序 显示比较和复制的次数
     */
    public void insertSortShowNum(){
        int compNum = 0;
        int copyNum = 0;
        int in, out;
        for(out=1; out<nElems; out++){
            long temp = a[out];
            in = out;
            while(in>0 && a[in-1]>=temp){
                a[in] = a[in-1];
                --in;
                copyNum++;  // 发生了复制
                compNum++;  // 每一次循环都有一次比较
            }  // end while
            compNum++;  // 循环结束有一次比较
            a[in] = temp;
            copyNum++;  // 发生了复制
        }  // end for
        System.out.println("共比较了"+compNum+"次");
        System.out.println("共复制了"+copyNum+"次");
    }  // end InsertSort()

    /** P78-T3.2
     * 返回数组的中间值
     * @return long  返回中间值
     * 时间复杂度分析：
     *      同插入排序
     */
    public long median(){
        insertSort();
        if(nElems%2 == 1){
            return a[(nElems-1)/2];  // nElems为奇数，返回最中间值
        }else{
            return (a[nElems/2]+a[nElems/2-1])/2;  // nElems为偶数，返回最中间两个值的平均数
        }  // end else
    }  // end median()

    /** P79-T3.3
     * 清除有序数组的重复值
     * 时间复杂度分析：
     *      s>2N  O(N)
     */
    public void noDups(){
        int i;
        for(i=0; i<nElems-1; i++){  // 找出重复的值并标记为-1
            if(a[i] == a[i+1]){
                a[i] = -1;
            }  // end if
        }  // end for
        int j;
        for(j=0; j<nElems; j++){  // 填充或清零-1
            if(a[j] == -1){  // 遇到值为-1
                int k;
                for(k=j; k<nElems; k++)  // 从右边找到第一个非-1值，交换
                    if(a[k] != -1){
                        a[j] = a[k];
                        a[k] = -1;
                        break;
                    }  // end if
                if(k == nElems)   // 从右边找不到非-1值
                    for(int l=j; a[l]==-1; l++){
                        a[l]=0;
                        nElems--;
                    }  //end for
            }  // end if
        }  // end for
    }  // end noDups()

    /** P79-T3.6
     * 插入排序同时删除重复
     */
    public void insertSortNoDups(){
        int in, rOut;
        int lout = 0;

        for(rOut=1; rOut<nElems; rOut++){
            long temp = a[rOut];
            in = rOut;
            int dupFlag = 0;  // 出现重复标志位 0-否 1-是

            while(in>lout && a[in-1]>=temp){  // = 保证了稳定性
                if(a[in-1] == temp){
                    dupFlag = 1;  // 如果出现重复值，将dupFlag置1并中断循环
                    break;
                }else{
                    a[in] = a[in-1];  // 如果没出现重复值，则正常复制
                    in--;
                }
            }  // end while

            if(1 == dupFlag){  // 若出现重复值
                while(in>lout){  // 将左边的数据都右移一位，腾出左边界处的空位
                    a[in] = a[in-1];
                    in--;
                }
                a[lout] = -1;  // 将-1赋值给左边界的空位
                lout++;
            }else
                a[in] = temp;
        }  // end for

        // 共N步
        for(int i=0; a[i]==-1; i++){  // 找到所有值为-1的位置
            int j;
            for(j=i; j<nElems; j++)  // 找到后面第一个值不为-1的位置与其交换
                if(a[j] != -1){
                    a[i] = a[j];
                    a[j] = -1;
                    break;
                }  //end if
            if(j == nElems){  // 若后面没有不为-1的位置
                for(int k=i; a[k]==-1; k++){  // 将当前和后面的位置都清零并减小元素个数
                    a[k] = 0;
                    nElems--;
                }
                break;
            }
        }  // end for

    }  // end InsertSort()

}  // end ArrayInsert{}

class InsertSortApp{
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayInsert arr = new ArrayInsert(maxSize);

//        arr.insert(77);
//        arr.insert(99);
//        arr.insert(44);
//        arr.insert(55);
//        arr.insert(22);
//        arr.insert(88);
//        arr.insert(11);
//        arr.insert(00);
//        arr.insert(66);
//        arr.insert(33);

        arr.insert(77);
        arr.insert(99);
        arr.insert(22);
        arr.insert(55);
        arr.insert(22);
        arr.insert(22);
        arr.insert(66);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display();

        // 先排序，再删重
        arr.insertSort();
        arr.display();
        arr.noDups();
        arr.display();

        // 在排序时直接删重
//        arr.insertSortNoDups();
//        arr.display();
    }  // end main()

}  // end ArrayInsert{}

/** 2020年4月28日
 77 99 44 55 22 88 11 0 66 33
 0 11 22 33 44 55 66 77 88 99
 */

/** 测试删除重复值
 77 99 22 55 22 22 66 0 66 33
 0 22 22 22 33 55 66 66 77 99
 0 22 33 55 66 77 99
 */