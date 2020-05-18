package com.cty.k_binarytree.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/17 11:46
 * @Description:
 * @version: 1.0
 */

/**
 * 代码表节点
 */
class codeNode
{
    public int frequency;
    public String code;

    public codeNode() {
    }

    public codeNode(int frequency) {
        this.frequency = frequency;
    }
}

/**
 * 哈夫曼树节点
 */
class HuffmanNode
{
    public int frequency;
    public int ascii;
    public HuffmanNode leftChild;
    public HuffmanNode rightChild;

    public HuffmanNode() {
    }

    public HuffmanNode(int frequency, int ascii) {
        this.frequency = frequency;
        this.ascii = ascii;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "frequency=" + frequency +
                ", ascii=" + ascii +
                '}';
    }
}


/**
 * 链表节点
 */
class OrdListNode
{
    public HuffmanNode data;
    public OrdListNode next;

    public OrdListNode() {
    }

    public OrdListNode(HuffmanNode data) {
        this.data = data;
    }
}

/**
 * 有序列表
 */
class OrdList
{
    private OrdListNode first;
    private OrdListNode last;

    public OrdList()
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public boolean isLeftOne()
    {
        return (first!=null && first==last);
    }

    public void displayList()
    {
        OrdListNode current = first;
        while(current != null)
        {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public HuffmanNode deleteFirst()
    {
        if (isEmpty())
            return null;
        else
        {
            HuffmanNode temp = first.data;
            first = first.next;
            if (first == null)
                last = null;
            return temp;
        }
    }

    public void insertPriority(HuffmanNode data)
    {
        OrdListNode newNode = new OrdListNode(data);
        OrdListNode previous = null;
        OrdListNode current = first;

        while(current!=null && data.frequency>current.data.frequency)
        {
            previous = current;
            current = current.next;
        }

        if(previous == null)  // 空或左端
        {
            if(first == null)  // 若为null
                last = newNode;
            first = newNode;
        }
        else
        {
            if(current == null)  // 若为末尾
                last = newNode;
            previous.next = newNode;
        }
        newNode.next = current;
    }  // end method Priority


}  // end class OrdList
