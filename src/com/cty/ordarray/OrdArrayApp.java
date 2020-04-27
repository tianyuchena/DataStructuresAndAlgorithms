package com.cty.ordarray;

/**
 * @Auther: cty
 * @Date: 2020/4/26 11:03
 * @Description: 测试有序数组
 * @version: 1.0
 */
public class OrdArrayApp {
    public static void main(String[] args) {
        int maxSize = 10;
        OrdArray arr = new OrdArray(maxSize);

        System.out.println("---------------------------------------------------------");
        // 测试新增
        System.out.println("测试新增");
        arr.fastInsert(77);
        arr.fastInsert(99);
        arr.fastInsert(44);
        arr.fastInsert(55);
        arr.fastInsert(22);
        arr.fastInsert(99);
        arr.fastInsert(99);
        arr.fastInsert(00);
        arr.fastInsert(66);
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


        //测试合并
        System.out.println("测试合并");
        OrdArray src1 = new OrdArray(10);
        src1.insert(56);
        src1.insert(2);
        src1.insert(8);
        src1.display();
        OrdArray src2 = new OrdArray(10);
        src2.insert(13);
        src2.insert(8);
        src2.insert(100);
        src2.insert(999);
        src2.insert(36);
        src2.display();
        OrdArray dst = OrdArray.merge(src1, src2);
        dst.display();

        System.out.println("---------------------------------------------------------");

    }
}

/* 2020年4月26日
---------------------------------------------------------
测试新增
Insert 33
0 22 33 44 55 66 77 99 99 99
---------------------------------------------------------
测试查找
Found 66
---------------------------------------------------------
测试删除
22 33 44 66 77
删除失败-索引位置为空值
Can't delete 18
---------------------------------------------------------
测试合并
2 8 56
8 13 36 100 999
2 8 8 13 36 56 100 999
---------------------------------------------------------
*/