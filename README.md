# DataStructureAndAlgorithms

#### 介绍
1. 本项目是笔者学习《Java数据结构和算法（第二版）》过程中整理的源代码，包括书中正文的代码清单和章节后面的编程作业。
2. 声明：项目代码包含笔者的思考，与书中代码不完全一样；编程作业笔者的实现或许不是最优的方法，甚至可能有一些错误，如有发现可评论告诉笔者，十分感谢。


#### 软件架构
1. com.cty.a_array : 无序数组
    * Array : 无序数组、P50-T2.1、P50-T2.2、P50-T2.6
    * ArrayApp : P50-T2.3
    
2. com.cty.b_ordarray : 有序数组
    * OrdArray : 有序数组、P50-T2.4、P50-T2.5
    
3. com.cty.sortbase : 简单排序
    * ArrayBubble : 数组实现冒泡排序、P78-T3.1、P79-T3.4
    * ArraySelect : 数组实现选择排序、P79-T3.5、P78-T3.2、P79-T3.3、P79-T3.6
    * ArrayInsert : 数组实现插入排序

4. com.cty.d_stackarray : 栈
    * StackLongArray : 长整型数组实现栈
    * StackCharArray : 字符数组实现栈
    * Reverser : 栈实现单词顺序反转
    * Bracket : 栈实现分隔符匹配检测
    
5. com.cty.e_queuearray : 队列
    * QueueLongArray : 长整型数组实现队列（有元素个数nElems字段）、P129-T4.1
    * QueueLongArray2 : 长整型数组实现队列（无元素个数nElems字段）
    * QueueMarket : 模拟超市收款排队（P130-T4.5）
    
6. com.cty.f_dequearray : 双端队列
    * DequeLongArray : 长整型数组实现双端队列（P129-T4.2）
    * StackDeque : 双端队列实现栈（P129-T4.3）
    
7. com.cty.g_priorityQLongArray : 优先级队列
    * PriorityQLongArray : 长整型数组实现慢插入快删除队列
    * PriorityQLongArray2 : 长整型数组实现慢删除快插入队列（P129-T4.4）
    
8. com.cty.h_linklist : 链表
    * Link : 链节点
    * LinkList : 单链表
        * StackLinkList : 单链表实现栈
        * LinkListIterator : 单链表迭代器
    * FirstLastList : 双端链表
    * OrdLinkList : 有序链表
        * OrdLinkListSort : 通过有序链表对数组进行插入排序
    * DoublyLinkList : 双向链表
    * exercise : P187-5.1 ~ P187-5.6
    
9. com.cty.i_recursion : 递归
    * Triangle : 三角数字
    * Factorial : 阶乘
    * Anagram : 变位字（单词全排列）
    * BinarySearch : 二分法查找
    * Towers : 汉诺塔
    * MergeSort : 归并排序
    * exercise : 
        * Exercise1 : P237-T6.1 加法通过递归实现乘法
        * Exercise2 : P237-T6.2 画二叉树 
        * Exercise3 : P237-T6.3 测试乘方     
            * Power : 乘方实现类
        * Exercise4 : P237-T6.4 测试背包问题
            * Backpack : 背包问题实现类
        * Exercise5 : P237-T6.5 测试组合问题
            * Combination : 组合问题实现类

10. com.cty.j_sortpro : 高级排序
    * SellSortApp : 希尔排序
    * PartitionApp : 划分
    * QuickSortApp : 快速排序
    * exercise : P275-T7.1 ~ P276-T7.5
    
11. com.cty.k_bianarytree : 二叉树
    * BinaryTree : 二叉搜索树
    * exercise : P321-T8.1 ~ P322-T8.3
        * Exercise5 : P322-T8.5 哈夫曼编码
        
12. com.cty.l_234tree : 234树

13. com.cty.m_hashtable : 哈希表
    * openaddress : 开放地址法的哈希表
        * HashTable : 线性探测法
        * HashTable2 : 二次探测法  P432-T11.1
        * HashTable3 : 再哈希法
    * chainaddress.HashTable : 连地址法的哈希表
    * exercise : P433-T11.2 ~ P433-T11.5


#### 运行环境

1.  jdk-1.7
2.  Intellij IDEA 2019.3