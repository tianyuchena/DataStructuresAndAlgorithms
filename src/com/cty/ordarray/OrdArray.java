package com.cty.ordarray;

/**
 * @Auther: cty
 * @Date: 2020/4/26 9:18
 * @Description: 有序数组
 * @version: 1.0
 */
public class OrdArray {
    private long[] a;
    private int nElems;

    /**
     * 基本方法
     *      构造器
     *      显示
     *      元素个数
     */
    /* 构造器 */
    public OrdArray(int maxSize){
        a = new long[maxSize];
        nElems = 0;
    }  // end OrdArray()

    // 显示
    public void display(){
        int i;
        for(i=0; i<nElems; i++){
            System.out.print(a[i]+" ");
        }  // end for
        System.out.println("");
    }  // end display()

    /* 元素个数 */
    public int size(){
        return nElems;
    }  // end size()

    /**
     * 查找
     *      根据值查找，返回查找到第一个的索引
     *
     * 使用的二分法
     */
    /* 根据值查找，返回查找到第一个的索引 */
    public int find(long searchKey){
        int lowerBound = 0;
        int upperBound = nElems-1;
        int curIn;

        while(true){
            curIn = (lowerBound + upperBound)/2;
            if(a[curIn] == searchKey){
                return curIn;  // 找到
            }else if(lowerBound > upperBound){
                return nElems;  // 未找到
            }else{
                if(a[curIn] < searchKey){
                    lowerBound = curIn + 1;  // 在上半边
                }else{
                    upperBound = curIn - 1;  // 在下半边
                }  // end else
            }  // end else
        }  // end while
    }  // end find()

    /**
     * 插入
     *      有序插入-在第一个大于新增值的位置插入
     *
     * 注意：
     *      是否数组已满
     */
    /* 有序插入-在第一个大于新增值的位置插入 */
    public boolean insert(long value){
        if(nElems == a.length){
            return false;  // 插入失败-数组已满
        }else{
            int i;
            for(i=0; i<nElems; i++){  // 找到第一个大于value的位置
                if(a[i] > value){
                    break;
                }  // end if
            }  // end for
            int j;
            for(j=nElems; j>i; j--){  // 高位上移，留出空位
                a[j] = a[j-1];
            }  // end for
            a[i] = value;  // 插入
            nElems++;
            return true;
        }  // end else
    }  // end insert()

    /**
     * 删除
     *      通过索引删除，返回是否删除成功
     *      通过值删除第一个，返回是否删除成功
     *      通过值删除所有，返回是否删除成功
     *
     * 注意：
     *      是否查找到（决定是否删除成功）
     *      是否数组已满（高位下移时分析）
     */
    /* 通过索引删除，返回是否删除成功 */
    public boolean deleteByIndex(int i){
        if(i == nElems){
            return false;  // 删除失败-没有找到
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
            return true;  // 删除成功
        }  // end else
    }  // end deleteByIndex()

    /* 通过值删除第一个，返回是否删除成功 */
    public boolean delete(long value){
        int i = find(value);
        return deleteByIndex(i);
    }  // end delete()

    /* 通过值删除所有，返回是否删除成功 */
    public boolean deleteAll(long value){
        int i = find(value);
        if(deleteByIndex(i)){  // 删除第一个
            int j = i-1;
            while(a[j] == value){
                deleteByIndex(j);
                j--;
            }  // end while
            int k = i;  // 高位自动回落，此时i处是一个新值
            while(a[k] == value){
                deleteByIndex(k);
                // j++; // 不需要自增，因为若删除成功，高位会自动回落
            }  // end while
            return true;
        }else{
            return false;  // 删除失败-未找到
        }  // end else
    }  // end deleteAll()

}  // end OrdArray{}
