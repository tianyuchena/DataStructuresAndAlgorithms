package com.cty.d_stackarray;

import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/4/29 16:32
 * @Description: 栈的应用——分隔符匹配
 * push和pop时间复杂的都为O(1)
 * @version: 1.0
 */
public class BracketChecker {
    private String input;

    public BracketChecker(String input){
        this.input = input;
    }

    public void checker(){
        StackCharArray stack = new StackCharArray(input.length());

        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            switch(ch){
                case '{':
                case '[':
                case '(':
                    stack.push(ch);  // 左分隔符压栈
                    break;
                case '}':
                case ']':
                case ')':
                    char chx = stack.pop();  // 右分隔符出栈
                    if(chx == '$')  // 数组为空
                        System.out.println("Error: "+ch+" at "+i);
                    else
                        if(ch=='}' && chx!='{' ||
                           ch==']' && chx!='[' ||
                           ch==')' && chx!='(')
                            System.out.println("Error: "+ch+" at "+i);
                    break;
                default:
                    break;
            }  // end switch
        }  // end for
    }  // end checker
}  // end class BracketChecker

class BracketApp{
    public static void main(String[] args) {
        String input;
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.print("请输入待检查分隔符的字符串：");
            input = scan.nextLine();
            if(input.equals("q") || input.equals("Q"))
                break;
            new BracketChecker(input).checker();
        }
    }
}  // end class BracketApp