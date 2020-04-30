package com.cty.d_stackarray;

import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/4/29 15:33
 * @Description: 栈的应用——单词逆序
 * @version: 1.0
 */
// 执行逆序类
public class Reverser{
    private String input;
    private String output;

    public Reverser(String in){
        input = in;
    }

    public String doRev(){
        // 创建栈
        StackCharArray stack = new StackCharArray(input.length());
        // 压栈
        for(int i=0; i<input.length(); i++){
            stack.push(input.charAt(i));
        }
        // 出栈
        output = "";
        while(!stack.isEmpty()){
            output += stack.pop();
        }
        return output;
    }
}  // end class Reverser

class ReverseAPP{
    public static void main(String[] args) {
        String input;
        String output;
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("请输入字符串：");
            input = scan.nextLine();
            if(input.equals("q") || input.equals("Q")){
                System.out.println("结束");
                break;
            }else {
                output = new Reverser(input).doRev();
                System.out.println("Reversed:"+output);
            }  // end else
        }  // end while
    }  // end main
}  // end class ReverseApp