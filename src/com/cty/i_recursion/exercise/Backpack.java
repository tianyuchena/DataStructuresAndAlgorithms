package com.cty.i_recursion.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/9 10:50
 * @Description: 背包问题
 * @version: 1.0
 */
public class Backpack {
    private List<Long> weights;
    private List<Integer> selects;

    public List<Long> getWeights() {
        return weights;
    }
    public List<Integer> getSelects() {
        return selects;
    }

    public Backpack(long... weightList)
    {
        if(null != weightList)
        {
            int maxSize = weightList.length;
            weights = new List<>(maxSize);
            selects = new List<>(maxSize);
            for(long weight : weightList)
                weights.insertByOrder(weight);
        }
    }

    /**
     * 显示所有选择值
     */
    public void displaySelects()
    {
        int i;
        for(i=0; i<selects.size(); i++)
            System.out.printf("%2d ", weights.findByIndex((int)selects.findByIndex(i)));
        for(int j=i; j<3; j++)
            System.out.print("   ");
    }

    /**
     * 结尾处理
     * @param curIn
     * @param target
     */
    public void dealEnd(int curIn, long target)
    {
        System.out.println(". No more items");

        selects.deleteRight();  // 删除当前选择值
        Integer previousIn = selects.deleteRight();  // 删除上一个选择值

        if(null == previousIn)
        {
            System.out.println("Failed!");
            return;  // 结束
        }

        long previousVal = weights.findByIndex(previousIn);
        doBackpack(previousIn+1, target+previousVal);
    }

    /**
     * 递归实现背包问题
     * @param curIn
     * @param target
     * @return
     */
    public void doBackpack(int curIn, long target)
    {
        long curVal = weights.findByIndex(curIn);
        selects.insertRight(curIn);  // 将当前起始索引值放入选择列表
        displaySelects();  // 显示当前所有选择值
        System.out.print("   // Target = " + target + ", ");  // 显示当前目标值

        if(curVal == target)
        {
            System.out.println(curVal + " is just right. Success!");
            return;  // 结束
        }
        else if(curVal < target)
        {
            System.out.print(curVal + " is too small");
            if(curIn == weights.size()-1)
                dealEnd(curIn, target);  // 结尾处理
            else
            {
                System.out.println("");
                doBackpack(curIn+1, target-curVal);  // curVal保留，target缩小
            }
        }
        else  // curVal > target
        {
            System.out.print(curVal + " is too big");
            if(curIn == weights.size()-1)
                dealEnd(curIn, target);  // 结尾处理
            else
            {
                System.out.println("");
                selects.deleteRight();
                doBackpack(curIn+1, target);  // curVal删除，target不变
            }
        }  // end else
    }  // end method doBackpack

}  // end class Backpack