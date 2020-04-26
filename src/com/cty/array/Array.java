package com.cty.array;

/**
 * @Auther: cty
 * @Date: 2020/4/26 8:30
 * @Description: 无序数组
 * 方法 1 2 3 是基础
 * 方法 4 5 6 构成“允许重复且查找和删除第一个”的数组
 * 方法 4 4和5 6 可组合成“不允许重复”的数组
 * 方法 4 5 7 构成“允许重复且删除所有”的数组
 *
 * @version: 1.0
 */
public class Array {
    private long[] a;  // 定义数组
    private int nElems;  // 当前元素个数

    /**
     * 基本方法
     *      构造器
     *      显示
     */
    /* 构造器 */
    public Array(int maxSize){
        a = new long[maxSize];
        nElems = 0;
    }  // end Array()

    /* 显示 */
    public void display(){
        for(int i=0; i<nElems; i++){
            System.out.print(a[i]+" ");
        }  // end for
        System.out.println("");
    }  // end display()

    /**
     * 查找
     *      根据值查找，返回查找到第一个的索引
     *      根据值查找，返回是否存在给定值
     *
     * 使用的线性查找
     */
    /* 根据值查找，返回查找到第一个的索引 */
    public int findIndex(long searchKey){
        int i;
        for(i=0; i<nElems; i++){
            if(a[i] == searchKey){
                break;
            }  // end if
        }  // end for
        return i;
    }  // end findIndex

    /* 根据值查找，返回是否存在给定值 */
    public boolean find(long searchKey){
        return findIndex(searchKey)==nElems?false:true;
    }  // end find

    /**
     * 插入
     *      向数组末尾插入一个新值，返回是否插入成功
     *
     * 注意：
     *      是否数组已满（决定是否插入成功）
     */
    /* 向数组末尾插入一个新值，返回是否插入成功 */
    public boolean insert(long value){
        if(nElems == a.length){
            return false;  // 插入失败-数组已满
        }else{
            a[nElems] = value;
            nElems++;
            return true;
        }  // end else
    }  // end insert

    /**
     * 删除
     *      通过索引删除，返回是否删除成功
     *      通过值删除第一个，返回是否删除成功
     *      通过值删除所有，返回是否删除成功
     *
     * 注意：
     *      是否查找到（决定是否删除成功）
     *      是否数组已满（高位下移是分析）
     */
    /* 通过索引删除，返回是否删除成功 */
    public boolean deleteByIndex(int i){
        if(i == nElems){
            return false;  // 删除失败-未查找到
        }else{
            if(nElems == a.length){  // 数组已满
                int j;
                for(j=i; j<nElems-1; j++){
                    a[j] = a[j+1];
                }  // end for
                a[j] = 0; // 0是long类型的默认值
                nElems--;
            }else{
                for(int j=i; j<nElems; j++){
                    a[j] = a[j+1];
                }  // end for
                nElems--;
            }  // end else
            return true;
        }  // end esle
    }  // end deleteByIndex()

    /* 通过值删除第一个，返回是否删除成功 */
    public boolean delete(long value){
        int i = findIndex(value);
        return deleteByIndex(i);
    }  // end delete()

    /* 通过值删除所有，返回是否删除成功 */
    public void deleteAll(long value){
        int i;
        for(i=0; i<nElems; i++){
            if(a[i] == value){
                deleteByIndex(i);
                i--;  // 删除后，后面数据又填充进来，因此还要再判断
            }  // end if
        }  // end for
    }  // end deleteAll()

}  // end Array
