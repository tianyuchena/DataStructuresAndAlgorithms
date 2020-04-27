package com.cty.array;

/**
 * @Auther: cty
 * @Date: 2020/4/25 17:25
 * @Description: 测试无序数组
 * @version: 1.0
 */
public class ArrayApp {
    public static void main(String[] args) {
        int maxSize = 10;
        Array arr = new Array(maxSize);

        System.out.println("---------------------------------------------------------");
        // 测试新增
        System.out.println("测试新增");
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(99);
        arr.insert(99);
        arr.insert(00);
        arr.insert(66);
        int insertValue = 33;
        if(arr.insert(insertValue)){
            System.out.println("Insert " + insertValue);
        } else{
            System.out.println("Can't insert " + insertValue);
        }
        arr.display();
        System.out.println("---------------------------------------------------------");

        // 测试查找
        System.out.println("测试查找");
        int searchKey = 66;
        if(arr.find(searchKey)){
            System.out.println("Found " + searchKey);
        }
        else{
            System.out.println("Can't find " + searchKey);
        }
        System.out.println("---------------------------------------------------------");


        // 测试删除
        System.out.println("测试删除");
        arr.delete(00);
        arr.delete(55);
        arr.deleteAll(99);
        arr.display();

        int deleteValue = 18;
        if(arr.delete(deleteValue))
            System.out.println("Delete " + deleteValue);
        else
            System.out.println("Can't delete " + deleteValue);
        System.out.println("---------------------------------------------------------");


        // 测试获取最大值
        System.out.println("测试最大值操作");
        arr.display();

        long max = arr.getMax();  // 获取最大值
        System.out.println("获取最大值：" + max);

        arr.display();

        long max2 = arr.removeMax();  // 获取并删除最大值
        System.out.println("获取并删除最大值：" + max);

        arr.display();

        System.out.println("使用removeMax实现简单排序：");
        System.out.print("当前数组为：");
        arr.display();

        // P50-T2.3
        Array sortArr = new Array(10);
        long curMax = 0;
        while(-1 != curMax){
            curMax = arr.removeMax();
            if(-1 != curMax){
                sortArr.insert(curMax);
            }
        }

        System.out.print("排序后的数组为：");
        sortArr.display();
        System.out.println("---------------------------------------------------------");


        // 测试noDup
        System.out.println("测试测试noDup");
        Array arr2 = new Array(10);
        arr2.insert(1);
        arr2.insert(3);
        arr2.insert(4);
        arr2.insert(1);
        arr2.insert(9);
        arr2.insert(4);
        arr2.insert(1);
        arr2.insert(5);
        arr2.insert(7);
        arr2.insert(10);
        arr2.display();

        arr2.noDup();
        arr2.display();
        System.out.println("---------------------------------------------------------");

    }
}

/* 2020年4月26日
---------------------------------------------------------
测试新增
Insert 33
77 99 44 55 22 99 99 0 66 33
---------------------------------------------------------
测试查找
Found 66
---------------------------------------------------------
测试删除
77 44 22 66 33
Can't delete 18
---------------------------------------------------------
测试最大值操作
77 44 22 66 33
获取最大值：77
77 44 22 66 33
获取并删除最大值：77
44 22 66 33
使用removeMax实现简单排序：
当前数组为：44 22 66 33
排序后的数组为：66 44 33 22
---------------------------------------------------------
*/
