package com.cty.i_recursion.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/9 19:54
 * @Description: 组合：选择一支队
 * @version: 1.0
 */
public class Combination {

    private List<Character> allMember;

    public List<Character> getAllMember() {
        return allMember;
    }

    public Combination(char... chars)
    {
        if(null != chars)
        {
            int maxSize = chars.length;
            allMember = new List<>(maxSize);
            for(char ch : chars)
                allMember.insertRight(ch);
        }
    }

    /**
     * 组合：从指定成员中选择一支序列，显示所有可能的序列
     * @param sequence 当前选择序列
     * @param targetNum  序列目标长度
     * @param curMemberNum  当前成员个数
     * @param curSelectNum  当前还需要选择成员个数
     * 原理：(n, k) = (n-1, k-1) + (n-1, k)
     */
    public void showTeams(String sequence, int targetNum, int curMemberNum, int curSelectNum)
    {
        if(curMemberNum==0 || curSelectNum==0 || curMemberNum<curSelectNum)
            return;
        else
        {
            int startIn = allMember.size() - curMemberNum;  // 当前起始索引
            char startChar = allMember.findByIndex(startIn);  // 当前起始值
            String newSequence = sequence + startChar;  // 更新序列
            // 执行左项表达式
            showTeams(newSequence, targetNum, curMemberNum-1, curSelectNum-1);
            // 当前序列若满足长度则显示
            if(newSequence.length() == targetNum)
                System.out.println(newSequence);
            // 执行右项表达式
            showTeams(sequence, targetNum, curMemberNum-1, curSelectNum);
        }
    }

}  // end class Combination