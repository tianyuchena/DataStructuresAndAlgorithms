package com.cty.array;


/**
 * @Auther: cty
 * @Date: 2020/4/26 8:30
 * @Description: 无序数组
 * @version: 1.0
 */
public class Array {
    private long[] a;  // 定义数组
    private int nElems;  // 当前元素个数


    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * 基本方法总结：
     *      构造器
     *      显示所有数组中的元素
     *      返回数组中元素个数
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /**
     * 构造器
     * @param maxSize  待创建数组的容量
     */
    public Array(int maxSize){
        a = new long[maxSize];
        nElems = 0;
    }  // end Array()

    /**
     * 显示所有数组中的元素
     */
    public void display(){
        for(int i=0; i<nElems; i++){
            System.out.print(a[i]+" ");
        }  // end for
        System.out.println("");
    }  // end display()

    /**
     * 返回数组中元素个数
     * @return nElems  当前元素个数
     */
    public int size(){
        return nElems;
    }  // end size()


    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * 查找方法总结：
     *      根据值查找，返回查找到第一个的索引
     *      根据值查找，返回是否查找到
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /**
     * 根据值查找，返回查找到第一个的索引
     * @param searchKey  查找键（值）
     * @return int
     *          case 1 (i>=0 && i<=nElems-1)-返回查找到第一个的索引
     *          case 2 (i=nElems)-空数组、之间未找到、小于左边界或大于有边界，未查找到
     */
    public int findIndex(long searchKey){
        int i;
        for(i=0; i<nElems; i++){
            if(a[i] == searchKey){
                break;
            }  // end if
        }  // end for
        return i;  // 返回查找到的索引
    }  // end findIndex

    /**
     * 根据值查找，返回是否查找到
     * @param searchKey  查找键
     * @return boolean
     *      case 1 false
     *      case2 true
     */
    public boolean find(long searchKey){
        return findIndex(searchKey)==nElems?false:true;
    }  // end find


    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * 插入总结：
     *      向数组末尾插入一个新值
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /**
     * 向数组末尾插入一个新值
     * @param value  待插入值
     * @return boolean
     *          case 1 false-数组已满
     *          case 2 true
     */
    public boolean insert(long value){
        if(nElems == a.length){
            return false;  // case 1 false-数组已满
        }else{
            a[nElems] = value;
            nElems++;
            return true;  // case 2 true
        }  // end else
    }  // end insert


    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * 删除总结：
     *      通过索引删除
     *      通过值删除第一个
     *      通过值删除所有
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /**
     * 通过索引删除
     * @param i  索引值
     * @return boolean
     *         case 1 false-索引超出数组范围
     *         case 2 false-索引位置为空值
     *         case 3 true-删除成功
     *
     * 注意：
     *      是否索引超出数组范围
     *      是否索引位置为空值
     *      是否数组已满（高位下移时分析）
     */
    public boolean deleteByIndex(int i){
        if((i>=a.length) || (i<0)){
            System.out.println("删除失败-索引超出数组范围");
            return false;  // case 1 false-索引超出数组范围
        }else if(i >= nElems){
            System.out.println("删除失败-索引位置为空值");
            return false;  // case 2 false-索引位置为空值
        }else{
            if(nElems == a.length){  // 数组已满
                int j;
                for(j=i; j<nElems-1; j++){  // 高位下移，填充空位
                    a[j] = a[j+1];
                }
                a[j] = 0;  // long类型默认值为0
                nElems--;
            }else{
                int j;
                for(j=i; j<nElems; j++){  // 高位下移，填充空位
                    a[j] = a[j+1];
                }  // end for
                nElems--;
            }  // end else
            return true;  // case 3 true-删除成功
        }  // end else
    }  // end deleteByIndex()

    /**
     * 通过值删除第一个
     * @param value  待删除值
     * @return boolean
     */
    public boolean delete(long value){
        int i = findIndex(value);
        return deleteByIndex(i);
    }  // end delete()

    /**
     * 通过值删除所有
     * @param value  待删除值
     * @return boolean
     */
    public void deleteAll(long value){
        int i;
        for(i=0; i<nElems; i++){
            if(a[i] == value){
                deleteByIndex(i);
                i--;  // 删除后，后面数据又填充进来，因此还要再判断
            }  // end if
        }  // end for
    }  // end deleteAll()


    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * 最大值操作总结：
     *      获取最大值
     *      获取并删除最大值
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /**  P50-T2.1
     * 获取最大值
     * @return long
     *          case 1 -1-数组为空
     *          case 2 curMax-返回最大值
     */
    public long getMax(){
        if(nElems == 0){
            return -1;  // case 1 -1-数组为空
        } else{
            int i;
            long curMax = a[0];  // 遍历选出最大值
            for(i=1; i<nElems; i++){
                if(a[i] > curMax){
                    curMax = a[i];
                }  // end if
            }  // end for
            return curMax;  // case 2 curMax-返回最大值
        }  // end else
    }  // end getMax()

    /** P50-T2.2
     * 获取和删除最大值
     * @return long
     *          case 1 -1-获取和删除最大值失败，数组为空
     *          case 2 curMax-获取和删除成功，返回最大值
     */
    public long removeMax(){
        // 可拆分为：
        long max = getMax();  // 查找最大关键字的值
        if(-1 == max){
            System.out.println("获取和删除最大值失败，数组为空");
            return -1;  // case 1 -1-获取和删除最大值失败，数组为空
        }else{
            // delete(max);  // 根据值删除查找到的第一个值
            deleteAll(max);  // 根据值删除查找到的所有值
            return max;  // case 2 curMax-获取和删除成功，返回最大值
        }  // end else
    }  // end removeMax()

    /** P50-T2.6
     * 将所有的值都只保留一个，即删除多个的重复值
     */
    public void noDup(){
        int i;
        for(i=0; i<nElems; i++){  // s1-将重复位设置为-1
            if(-1 != a[i]){
                int j;
                for(j=i+1; j<nElems; j++){
                    if(a[j] == a[i]){
                        a[j] = -1;
                    }  // end if
                }  // end for
            }  // end if
        }  // end for

        int k;
        for(k=1; k<nElems; k++){  // s2-将值为-1的位置删除
            if(-1 == a[k]){
                deleteByIndex(k);
                k--;
            }  // end if
        }  // end for
    }  // end noDup()

}  // end Array{}
