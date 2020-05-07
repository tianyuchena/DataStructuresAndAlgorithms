package com.cty.h_linklist.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/6 19:05
 * @Description: Josephus问题  P187-5.5
 * @version: 1.0
 */
public class Exercise5
{
    public static void main(String[] args) {
        Josephus jp = new Josephus(41, 3, 1);
        jp.run();

    }  // end method main

    /**
     * CircleLinkList (current-->current): 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41
     * 当前位置：1
     * 被消去人的顺序是：3 6 9 12 15 18 21 24 27 30 33 36 39 1 5 10 14 19 23 28 32 37 41 7 13 20 26 34 40 8 17 29 38 11 25 2 22 4 35 16
     * 最后剩下的人是：31
     */
}  // end class Exercise5

class Josephus
{
    private CircleLinkList circle;
    private int peopleNum;
    private int outNum;
    private int startNum;

    public Josephus(int peopleNum, int outNum, int startNum)
    {
        circle = new CircleLinkList();
        this.peopleNum = peopleNum;
        this.outNum = outNum;
        this.startNum = startNum;

        for(int j=this.peopleNum; j>=1; j--)  // 根据人数创建循环链表
            circle.insertNext(j);
        circle.display();

        for(int j=1; j<startNum; j++)  // 将current移到开始的人的位置
            circle.step();
        System.out.println("当前位置：" + circle.peekNext());
    }

    public void run()
    {
        Long[] outs = new Long[peopleNum];  // 依次存放出局人的编号
        int i = 0;
        while(!circle.isEmpty())
        {
            for(int j=1; j<outNum; j++)  // 报数
                circle.step();
            outs[i] = circle.removeNext();  // 报数到outNum的人出局，并依次保存在数组中
            i++;

        }  // end while

        // 结果显示
        System.out.print("被消去人的顺序是：");
        for(int j=0; j<peopleNum-1; j++)
            System.out.print(outs[j] + " ");
        System.out.println("");
        System.out.println("最后剩下的人是：" + outs[peopleNum-1]);
    }  // end method run
}  // end class Josephus
