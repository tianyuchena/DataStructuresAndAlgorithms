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

        // 测试新增
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

        // 测试查找
        int searchKey = 66;
        if(arr.find(searchKey)){
            System.out.println("Found " + searchKey);
        }
        else{
            System.out.println("Can't find " + searchKey);
        }

        // 测试删除
        arr.delete(00);
        arr.delete(55);
        arr.deleteAll(99);
        arr.display();

        int deleteValue = 18;
        if(arr.delete(deleteValue))
            System.out.println("Delete " + deleteValue);
        else
            System.out.println("Can't delete " + deleteValue);
    }
}

/* 2020年4月26日
Insert 33
77 99 44 55 22 99 99 0 66 33
Found 66
77 44 22 66 33
Can't delete 18
*/
