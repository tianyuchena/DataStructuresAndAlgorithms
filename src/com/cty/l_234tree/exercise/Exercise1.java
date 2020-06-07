package com.cty.l_234tree.exercise;

import com.cty.l_234tree.DataItem;
import com.cty.l_234tree.Node;
import com.cty.l_234tree.Tree234;

/**
 * @Auther: cty
 * @Date: 2020/6/7 19:10
 * @Description: 返回234树中的最小值
 * @version: 1.0
 */
public class Exercise1 {
    public static void main(String[] args) {
        Tree234Child tree = new Tree234Child();

        tree.insert(50);
        tree.insert(40);
        tree.insert(60);
        tree.insert(30);
        tree.insert(70);

        System.out.println(tree.getMinKeyItem().dData);
    }
}

class Tree234Child extends Tree234 {

    public DataItem getMinKeyItem()
    {
        Node current = root;
        while(!current.isLeaf()){
            current = current.getChild(0);
        }
        return current.getItem(0);
    }

}
