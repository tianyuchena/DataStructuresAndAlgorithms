package com.cty.k_binarytree.exercise;
import java.util.Scanner;
import java.util.Stack;
/**
 * @Auther: cty
 * @Date: 2020/5/17 15:40
 * @Description: P322-T8.3
 * @version: 1.0
 */

class Exercise5App
{
    public static void main(String[] args) {
        HuffmanTree tree = new HuffmanTree();

        // 1 获取输入字符串
        int maxSize = 5;
        String[] strs = tree.getInput(maxSize);

        // 2 创建哈夫曼树和生成编码表
        tree.createHuffmanTree(strs);
         tree.displayTree();  // 显示哈夫曼树
        tree.displayCodeArray();  // 显示编码表

        // 3 编码
        String code = tree.enCode(strs);
        System.out.println("⭐编码结果如下：");
        System.out.println(code);

        // 4 解码
        String message = tree.deCode(code);
        System.out.println("⭐解码结果如下：");
        System.out.println(message);

    }  // end method main

    /**
     * 请输入待处理信息（空行输入q或Q结束，最多输入5行）：
     * SUSIE SAYS IT IS EASY
     * q
     * ⭐哈夫曼树如下：
     * ............................................................
     *                                 ⚪
     *                 ⚪                              ⚪
     *         SP              ⚪              S               ⚪
     *     --      --      A       ⚪      --      --      I       ⚪
     *   --  --  --  --  --  --  LF  ⚪  --  --  --  --  --  --  Y   E
     *  ----------------------------U T --------------------------------
     * ............................................................
     * ⭐编码表如下：
     * 字符 频次 编码
     * LF	1	0110
     *  	4	00
     * A	2	010
     * E	2	1111
     * I	3	110
     * S	6	10
     * T	1	01111
     * U	1	01110
     * Y	2	1110
     *
     * ⭐编码结果如下：
     * 10011101011011110010010111010001100111100110100011110101011100110
     * ⭐解码结果如下：
     * SUSIE SAYS IT IS EASY
     */

}  // end class Exercise1App


/**
 * 哈夫曼树
 */
class HuffmanTree {
    private HuffmanNode root;
    private codeNode[] codeArray;

    public HuffmanTree() {
        root = null;
        codeArray = new codeNode[128];
    }

    /**
     * 1-1 获取输入字符串数组（可能不止一行）
     * @return
     */
    public String[] getInput(int maxSize) {
        System.out.println("请输入待处理信息（空行输入q或Q结束，最多输入"+ maxSize +"行）：");

        String[] strs = new String[maxSize];  // 最大输入maxSize行字符串
        Scanner scan  = new Scanner(System.in);

        int strIn = 0;
        String str = scan.nextLine();
        while(!str.equals("q") && !str.equals("Q"))
        {
            strs[strIn++] = str;
            if(strIn == maxSize)
            {
                System.out.println("已经到达输入字符串行数上限，强制结束");
                break;
            }
            str = scan.nextLine();  // 获取下一行数据
        }  // end while

        if(strs[0] == null)  // 若第一行都没有数据
            return null;  // 返回null
        return strs;
    }

    /**
     * 1-2 统计字符出现频次，将字符及其频次信息封装到节点中，然后全部放入有序数组
     * @param strs
     * @return
     */
    private OrdList countFrequency(String[] strs)
    {
        int strLen = strs.length;
        OrdList list = new OrdList();

        // 统计换行符(ASCII码是10)
        codeArray[10] = new codeNode(0);
        for(int a=0; a<strLen; a++)
            if(strs[a] != null)
                codeArray[10].frequency++;

        // 统计其他字符频次
        for(int i=0; i<codeArray[10].frequency; i++)
            for(int j=0; j<strs[i].length(); j++)
            {
                int ascii = strs[i].charAt(j);  // 获取当前字符的ascii码
                if(codeArray[ascii] == null)  // 若该字符还未出现过
                    codeArray[ascii] = new codeNode(0);  // 则在编码表上创建该节点
                codeArray[ascii].frequency++;  // 该字符出现频次加1
            }

        // 将统计好字符频次的节点插入有序列表
        for(int k=0; k<codeArray.length; k++)
            if(codeArray[k] != null)
                list.insertPriority(new HuffmanNode(codeArray[k].frequency, k));

        return list;
    }

    /**
     * 1-3 创建哈夫曼树 并获取编码
     * @param strs
     */
    public void createHuffmanTree(String[] strs)
    {
        OrdList list = countFrequency(strs);
        // list.displayList();

        if(!list.isEmpty()) {
            while (!list.isLeftOne()) {
                HuffmanNode newNode = new HuffmanNode(0, 16);  // ascii=16代表空数据节点
                newNode.leftChild = list.deleteFirst();
                newNode.rightChild = list.deleteFirst();
                newNode.frequency = newNode.leftChild.frequency + newNode.rightChild.frequency;
                list.insertPriority(newNode);
            }
            root = list.deleteFirst();
        }  // end if

        getCode("", root);  // 获取编码
    }  // end method createHuffmanTree

    /**
     * 2 生成编码表
     * @param code
     * @param node
     */
    private void getCode(String code, HuffmanNode node)
    {
        if(node == null)
            return;
        else if(node.leftChild==null && node.rightChild==null)
        {
            codeArray[node.ascii].code = code;  // 编码
            return;
        }
        else
        {
            getCode(code+"0", node.leftChild);
            getCode(code+"1", node.rightChild);
        }
    }

    /**
     * 显示编码表
     */
    public void displayCodeArray()
    {
        System.out.println("⭐编码表如下：");
        System.out.println("字符 频次 编码");
        for(int i=0; i<128; i++)
            if(codeArray[i] != null)
            {
                if(i == 10)
                    System.out.println("LF\t"+codeArray[i].frequency+"\t"+codeArray[i].code);
                else
                    System.out.println((char)i+"\t"+codeArray[i].frequency+"\t"+codeArray[i].code);
            }
        System.out.println();
    }

    /**
     * 3 编码
     * @param strs
     * @return
     */
    public String enCode(String[] strs)
    {
        String code = "";
        for(int i=0; i<codeArray[10].frequency; i++)
        {
            for(int j=0; j<strs[i].length(); j++)
                code += codeArray[strs[i].charAt(j)].code;  // 为每一行的每一个字符添加编码

            code += codeArray[10].code;  // 添加换行符编码
        }
        return code;
    }

    /**
     * 4 解码
     * @param code
     * @return
     */
    public String deCode(String code)
    {
        String message = "";
        HuffmanNode current = root;

        for(int i=0; i<code.length(); i++)
        {
            if(code.charAt(i)-'0' == 0)
                current = current.leftChild;
            else if(code.charAt(i)-'0' == 1)
                current = current.rightChild;

            if(current.ascii != 16)
            {
                message += (char)current.ascii;  // 若遇到叶子节点
                current = root;  // 则重新开始遍历
            }
        }  // end for
        return message;
    }


    /**
     * 显示树
     */
    public void displayTree()
    {
       System.out.println("⭐哈夫曼树如下：");

        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("............................................................");

        while(!isRowEmpty)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for(int i=0; i<nBlanks; i++)
                System.out.print(' ');

            while(!globalStack.empty())
            {
                HuffmanNode temp = (HuffmanNode) globalStack.pop();
                if(temp != null)
                {
                    if(temp.ascii == 10)
                        System.out.print("LF");
                    else if(temp.ascii == 32)
                        System.out.print("SP");
                    else if(temp.ascii == 16)
                        System.out.print("⚪");
                    else
                        System.out.print((char) temp.ascii + " ");
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if(temp.leftChild!=null || temp.rightChild!=null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for(int i=0; i<nBlanks*2-2; i++)
                    System.out.print(' ');
            }  // end while !globalStack.empty()

            System.out.println();
            nBlanks /= 2;
            while(!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }  // end while !isRowEmpty

        System.out.println("............................................................");
    }  // end method displayTree

}  // end class BinaryCharTree


