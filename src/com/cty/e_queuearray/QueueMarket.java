package com.cty.e_queuearray;

import java.util.List;
import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/5/3 14:51
 * @Description: 超市排队模拟  P130-T4.5
 * @version: 1.0
 */
public class QueueMarket
{
    // 假设超市有四个收银台
    private QueueLongArray que1;
    private long deal1;
    private QueueLongArray que2;
    private long deal2;
    private QueueLongArray que3;
    private long deal3;
    private QueueLongArray que4;
    private long deal4;

    public QueueMarket(int maxSize)
    {
        que1 = new QueueLongArray(maxSize);
        deal1 = -1;
        que2 = new QueueLongArray(maxSize);
        deal2 = -1;
        que3 = new QueueLongArray(maxSize);
        deal3 = -1;
        que4 = new QueueLongArray(maxSize);
        deal4 = -1;
    }

    public void showQueue(long d1, long d2, long d3, long d4)
    {
        System.out.println("排队情况：");
        System.out.print("队列1：");
        que1.display();
        System.out.println("当前结算顾客："+d1);

        System.out.print("队列2：");
        que2.display();
        System.out.println("当前结算顾客："+d2);

        System.out.print("队列3：");
        que3.display();
        System.out.println("当前结算顾客："+d3);

        System.out.print("队列4：");
        que4.display();
        System.out.println("当前结算顾客："+d4);
    }

    public static long dealInOneMin(QueueLongArray que, long deal)
    {
        if(!que.isEmpty())
        {
            if(-1 == deal)
                deal = que.peek();
            deal--;
            if(0 == deal)
            {
                que.remove();
                deal = que.peek();
            }
        }
        return deal;
    }  // end method dealInOneMin

    public static void main(String[] args)
    {
        QueueMarket QM = new QueueMarket(100);
        QueueLongArray q1 = QM.que1;
        QueueLongArray q2 = QM.que2;
        QueueLongArray q3 = QM.que3;
        QueueLongArray q4 = QM.que4;
        Scanner scan = new Scanner(System.in);

        while(true)
        {
            // 查看当前排队情况
            System.out.println("");
            QM.showQueue(QM.deal1, QM.deal2, QM.deal3, QM.deal4);

            System.out.print("请键入(t, T or 1-9)：");
            String input = scan.nextLine();
            if(input.equals("t") || input.equals("T"))
            {
                QM.deal1 = dealInOneMin(q1, QM.deal1);  // 处理第1个队列
                QM.deal2 = dealInOneMin(q2, QM.deal2);  // 处理第2个队列
                QM.deal3 = dealInOneMin(q3, QM.deal3);  // 处理第3个队列
                QM.deal4 = dealInOneMin(q4, QM.deal4);  // 处理第4个队列
                System.out.println("时间流逝1分钟...");
            }
            else if(input.equals(""))
                System.out.println("输入不得为空！");
            else if(Long.parseLong(input)>0 && Long.parseLong(input)<9)
            {
                // 向长度最短的队列插入新增排队顾客
                if(q1.size()<=q2.size() && q1.size()<=q3.size() && q1.size()<=q4.size())
                {
                    q1.insert(Long.parseLong(input));
                    System.out.println("队列1添加一个值为 "+input+" 的顾客");
                }
                else if(q2.size()<q1.size() && q2.size()<=q3.size() && q2.size()<=q4.size())
                {
                    q2.insert(Long.parseLong(input));
                    System.out.println("队列2添加一个值为 "+input+" 的顾客");
                }
                else if(q3.size()<q1.size() && q3.size()<=q2.size() && q3.size()<=q4.size())
                {
                    q3.insert(Long.parseLong(input));
                    System.out.println("队列3添加一个值为 "+input+" 的顾客");
                }
                else if(q4.size()<q1.size() && q4.size()<q2.size() && q4.size()<q3.size())
                {
                    q4.insert(Long.parseLong(input));
                    System.out.println("队列4添加一个值为 "+input+" 的顾客");
                }
            }  // end else if(Long.parseLong(input)>0 && Long.parseLong(input)<9)
            else
                System.out.println("输入不合法！");
        }  // end while(true)
    }  // end method main

}  // end class QueueMarket

/** 2020年5月3日
 排队情况：
 队列1：显示失败-队列为空
 当前结算顾客：-1
 队列2：显示失败-队列为空
 当前结算顾客：-1
 队列3：显示失败-队列为空
 当前结算顾客：-1
 队列4：显示失败-队列为空
 当前结算顾客：-1
 请键入(t, T or 1-9)：1
 队列1添加一个值为 1 的顾客

 排队情况：
 队列1：1
 当前结算顾客：-1
 队列2：显示失败-队列为空
 当前结算顾客：-1
 队列3：显示失败-队列为空
 当前结算顾客：-1
 队列4：显示失败-队列为空
 当前结算顾客：-1
 请键入(t, T or 1-9)：2
 队列2添加一个值为 2 的顾客

 排队情况：
 队列1：1
 当前结算顾客：-1
 队列2：2
 当前结算顾客：-1
 队列3：显示失败-队列为空
 当前结算顾客：-1
 队列4：显示失败-队列为空
 当前结算顾客：-1
 请键入(t, T or 1-9)：3
 队列3添加一个值为 3 的顾客

 排队情况：
 队列1：1
 当前结算顾客：-1
 队列2：2
 当前结算顾客：-1
 队列3：3
 当前结算顾客：-1
 队列4：显示失败-队列为空
 当前结算顾客：-1
 请键入(t, T or 1-9)：4
 队列4添加一个值为 4 的顾客

 排队情况：
 队列1：1
 当前结算顾客：-1
 队列2：2
 当前结算顾客：-1
 队列3：3
 当前结算顾客：-1
 队列4：4
 当前结算顾客：-1
 请键入(t, T or 1-9)：5
 队列1添加一个值为 5 的顾客

 排队情况：
 队列1：1 5
 当前结算顾客：-1
 队列2：2
 当前结算顾客：-1
 队列3：3
 当前结算顾客：-1
 队列4：4
 当前结算顾客：-1
 请键入(t, T or 1-9)：6
 队列2添加一个值为 6 的顾客

 排队情况：
 队列1：1 5
 当前结算顾客：-1
 队列2：2 6
 当前结算顾客：-1
 队列3：3
 当前结算顾客：-1
 队列4：4
 当前结算顾客：-1
 请键入(t, T or 1-9)：t
 时间流逝1分钟...

 排队情况：
 队列1：5
 当前结算顾客：5
 队列2：2 6
 当前结算顾客：1
 队列3：3
 当前结算顾客：2
 队列4：4
 当前结算顾客：3
 请键入(t, T or 1-9)：t
 时间流逝1分钟...

 排队情况：
 队列1：5
 当前结算顾客：4
 队列2：6
 当前结算顾客：6
 队列3：3
 当前结算顾客：1
 队列4：4
 当前结算顾客：2
 请键入(t, T or 1-9)：t
 查看失败-数组为空
 时间流逝1分钟...

 排队情况：
 队列1：5
 当前结算顾客：3
 队列2：6
 当前结算顾客：5
 队列3：显示失败-队列为空
 当前结算顾客：-1
 队列4：4
 当前结算顾客：1
 请键入(t, T or 1-9)：t
 查看失败-数组为空
 时间流逝1分钟...

 排队情况：
 队列1：5
 当前结算顾客：2
 队列2：6
 当前结算顾客：4
 队列3：显示失败-队列为空
 当前结算顾客：-1
 队列4：显示失败-队列为空
 当前结算顾客：-1
 请键入(t, T or 1-9)：t
 时间流逝1分钟...

 排队情况：
 队列1：5
 当前结算顾客：1
 队列2：6
 当前结算顾客：3
 队列3：显示失败-队列为空
 当前结算顾客：-1
 队列4：显示失败-队列为空
 当前结算顾客：-1
 请键入(t, T or 1-9)：t
 查看失败-数组为空
 时间流逝1分钟...

 排队情况：
 队列1：显示失败-队列为空
 当前结算顾客：-1
 队列2：6
 当前结算顾客：2
 队列3：显示失败-队列为空
 当前结算顾客：-1
 队列4：显示失败-队列为空
 当前结算顾客：-1
 请键入(t, T or 1-9)：t
 时间流逝1分钟...

 排队情况：
 队列1：显示失败-队列为空
 当前结算顾客：-1
 队列2：6
 当前结算顾客：1
 队列3：显示失败-队列为空
 当前结算顾客：-1
 队列4：显示失败-队列为空
 当前结算顾客：-1
 请键入(t, T or 1-9)：t
 查看失败-数组为空
 时间流逝1分钟...
 */