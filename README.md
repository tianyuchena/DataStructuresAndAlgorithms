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
    
    

#### 运行环境

1.  jdk-1.7
2.  Intellij IDEA 2019.3