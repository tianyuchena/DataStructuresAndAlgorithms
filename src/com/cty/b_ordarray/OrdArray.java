package com.cty.b_ordarray;

/**
 * @Auther: cty
 * @Date: 2020/4/26 9:18
 * @Description: 有序数组
 * @version: 1.0
 */
public class OrdArray {
    private long[] a;
    private int nElems;


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
    public OrdArray(int maxSize){
        a = new long[maxSize];
        nElems = 0;
    }  // end OrdArray()

    /**
     * 显示所有数组中的元素
     */
    public void display(){
        int i;
        for(i=0; i<nElems; i++){
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
     *      根据索引查找，返回元素值  s=1  O(1)
     *      根据值查找，返回查找到第一个的索引  s=log2N  O(logN)
     *      根据值查找，返回是否查找到  s=log2N  O(logN)
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /**
     * 根据索引查找，返回元素值
     * @param i  索引
     * @return long
     *          case 1 -1-查找失败，索引值超出数组范围
     *          case 2 a[i]-查找成功
     * 时间复杂度分析：
     *      s=1  O(1)
     */
    public long findByIndex(int i){
        if((i>=a.length) || (i<0)){
            System.out.println("查找失败，索引值超出数组范围");
            return -1;  // case 1 -1-查找失败，索引值超出数组范围
        }else{
            return a[i];  // case 2 a[i]-查找成功
        }
    }

    /**
     * 根据值查找，返回查找到第一个的索引
     * @param searchKey  查找键（值）
     * @return int
     *          case 1 curIn-返回查找到第一个的索引
     *          case 2 nElems-空数组、之间未找到、小于左边界或大于有边界，未查找到
     * 时间复杂度分析：
     *      s=log2N  O(logN)
     */
    public int findIndex(long searchKey){
        int lowerBound = 0;
        int upperBound = nElems-1;
        int curIn;

        while(true){
            curIn = (lowerBound + upperBound)/2;
            if(a[curIn] == searchKey){
                return curIn;  // case 1 curIn-返回查找到第一个的索引
            }else if(lowerBound > upperBound){
                return nElems;  // case 2 nElems-空数组、之间未找到、小于左边界、大于有边界，未查找到返回nElems
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
     * 根据值查找，返回是否查找到
     * @param searchKey  查找键
     * @return boolean
     *      case 1 false
     *      case2 true
     * 时间复杂度分析：
     *      s=log2N  O(logN)
     */
    public boolean find(long searchKey){
        return findIndex(searchKey)==nElems?false:true;
    }  // end find


    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * 插入总结：
     *      在指定索引的位置插入  s=N/2  O(N)
     *      有序线性插入-线性查找，在合适的位置插入  s=N/2+N/2+1  O(N)
     *      有序二分法插入-二分法查找，在合适的位置插入  s=log2N  O(logN)
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /**
     * 在指定索引的位置插入
     * @param i  索引值
     * @param value  待插入值
     * @return boolean
     *          case 1 false-数组已经满
     *          case 2 false-索引值超出数组范围
     *          case 3 true-高位上移（若存在的话）并赋值
     * 注意：
     *      是否数组已满
     *      是否索引值超出数组范围
     * 时间复杂度分析：
     *      s=N/2  O(N)
     */
    public boolean insertByIndex(int i, long value){
        if(nElems == a.length){
            System.out.println("插入失败-数组已经满");
            return false;  // case 1 false-数组已经满
        }else{
            if((i>=a.length) || (i<0)){
                System.out.println("插入失败-索引值超出数组范围");
                return false;  // case 2 false-索引值超出数组范围
            }else{
                int j;
                for(j=nElems; j>i; j--){  // 高位上移，留出空位
                    a[j] = a[j-1];
                }  // end for
                a[j] = value;  // 赋值
                nElems++;
                return true;  // case 3 true-高位上移（若存在的话）并赋值
            }  // end else
        }  // end else
    }  // end indexByIndex()

    /**
     * 有序线性插入-线性查找，在合适的位置插入
     * @param value  待插入值
     * @return boolean
     *          case 1 false-数组已满
     *          case 2 true-找到第一个大于value的位置并插入
     *          case 3 true-未找到大于value的值，在末尾插入
     * 注意：
     *      是否数组已满
     * 时间复杂度分析：
     *      s=N/2+N/2+1  O(N)
     */
    public boolean insert(long value){
        if(nElems == a.length){  // 已满
            return false;  // case 1 false-数组已满
        }else{  // 未满
            int i;
            for(i=0; i<nElems; i++){
                if(a[i] > value){
                    return insertByIndex(i, value);  // case 2 true-找到第一个大于value的位置并插入
                }  // end if
            }  // end for
            a[i] = value;  // case 3 true-未找到大于value的值，在末尾插入
            nElems++;
            return true;
        }  // end else
    }  // end insert()

    /**  P50-T2.4-2
     * 有序二分法插入-二分法查找，在合适的位置插入
     * @param value 待插入值
     * @return boolean
     *          case 1 false-数组已满
     *          case 2 true-value在有序数组的最大值和最小值之间且有相同值，在找到的一个相同值的位置插入
     *          case 3 true-空数组、之间未找到、小于左边界、大于右边界，在lowerBound的位置插入
     * 注意：
     *      是否数组已满
     * 时间复杂度分析：
     *      s=log2N  O(logN)
     */
    public boolean fastInsert(long value){
        if(nElems == a.length){  // 已满
            return false;  // case 1 false-数组已满
        }else{  // 未满
            int lowerBound = 0;
            int upperBound = nElems-1;
            int curIn;

            while(true){
                curIn = (lowerBound + upperBound)/2;
                if(a[curIn] == value){  // 有相同值
                    return insertByIndex(curIn, value);  // case 2 true-value在有序数组的最大值和最小值之间且有相同值，
                    // 在找到的一个相同值的位置插入
                }  else if(lowerBound > upperBound){
                    return insertByIndex(lowerBound, value);  // case 3 true-空数组、之间未找到、小于左边界、大于右边界，
                    // 在lowerBound的位置插入
                } else{
                    if(a[curIn] < value){
                        lowerBound = curIn + 1;  // 在上半边
                    }  // end if
                    else{
                        upperBound = curIn - 1;  // 在下半边
                    } // end else
                }  // end else
            }  // end while
        }  // end else
    }  // end fastInsert()


    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * 删除总结：
     *      通过索引删除  s=N/2  O(N)
     *      通过值删除第一个  s=log2N+N/2  O(N)
     *      通过值删除所有  s>log2N+N/2  O(N)
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /**
     * 通过索引删除
     * @param i  索引值
     * @return boolean
     *         case 1 false-索引超出数组范围
     *         case 2 false-索引位置为空值
     *         case 3 true-删除成功
     * 注意：
     *      是否索引超出数组范围
     *      是否索引位置为空值
     *      是否数组已满（高位下移时分析）
     * 时间复杂度分析：
     *      s=N/2  O(N)
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

    /** P50-T2.4-2
     * 通过值删除第一个
     * @param value  待删除值
     * @return boolean
     * 时间复杂度分析：
     *      s=log2N+N/2  O(N)
     */
    /* 通过值删除第一个，返回是否删除成功 */
    public boolean delete(long value){
        int i = findIndex(value);
        return deleteByIndex(i);
    }  // end delete()

    /**
     * 通过值删除所有
     * @param value  待删除值
     * @return boolean
     * 时间复杂度分析：
     *      s>log2N+N/2  O(N)
     *      >来自不止删除1个
     */
    public void deleteAll(long value){
        int i = findIndex(value);
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
        }
    }  // end deleteAll()


    /** P50-T2.5
     * 合并有序数组
     * @param src1  有序数组1
     * @param src2  有序数组2
     * @return OrdArray
     *          case 1 src2-src1为空，直接返回src2
     *          case 2 src1-src2为空，直接返回src1
     *          case 3 dst-都不为空，src1先遍历完
     *          case 4 dst-都不为空，src2先遍历完
     *          case 5 dst-都不为空，同时遍历完
     * 时间复杂度分析：
     *      s=N1+N2  O(N)
     */
    public static OrdArray merge(OrdArray src1, OrdArray src2){
        if(0 == src1.size()){
            return src2;  // case 1 src2-src1为空，直接返回src2
        }else if(0 == src2.size()){
            return src1;  // case 2 src1-src2为空，直接返回src1
        }else{  // 都不为空
            int size1 = src1.size();
            int size2 = src2.size();
            OrdArray dst = new OrdArray(size1+size2);

            int ind1 = 0;
            int ind2 = 0;
            while(true){
                if((ind1==size1) && (ind2<size2)){  // src1遍历完，src2还有剩余
                    int j;
                    for(j=ind2; j<size2; j++){
                        dst.insert(src2.findByIndex(j));
                    }  // end for
                    return dst;  // case 3 dst-都不为空，src1先遍历完
                }else if((ind2==size2) && (ind1<size1)){  // src2遍历完，src1还有剩余
                    int j;
                    for(j=ind1; j<size1; j++){
                        dst.insert(src1.findByIndex(j));
                    }  // end for
                    return dst;  // case 4 dst-都不为空，src2先遍历完
                }else if((ind1==size1) && (ind2==size2)){  // src1和src2都遍历完
                    return dst;  // case 5 dst-都不为空，同时遍历完
                }else{  // src1和src2都未遍历完
                    if(src1.findByIndex(ind1) <= src2.findByIndex(ind2)){
                        dst.insert(src1.findByIndex(ind1));
                        ind1++;
                    }else {
                        dst.insert(src2.findByIndex(ind2));
                        ind2++;
                    }
                }// end else
            }  // end while
        }  // end else
    }  // end merge()

}  // end OrdArray{}
