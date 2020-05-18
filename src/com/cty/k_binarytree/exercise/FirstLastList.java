package com.cty.k_binarytree.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/17 11:46
 * @Description:
 * @version: 1.0
 */
/**
 * 列表节点
 * @param <E>
 */
class ListNode<E>
{
    public E data;
    public ListNode next;

    public ListNode(E data) {
        this.data = data;
    }
}

/**
 * 工具列表
 * @param <E>
 */
class FirstLastList<E>
{
    private ListNode first;
    private ListNode last;

    public FirstLastList()
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

    public E peekFirst()
    {
        return (E)first.data;
    }

    public void insertFirst(E data)
    {
        ListNode<E> newNode = new ListNode<>(data);

        if(isEmpty())
            last = newNode;
        else
            newNode.next = first;
        first = newNode;
    }

    public E deleteFirst()
    {
        if (isEmpty())
            return null;
        else
        {
            E temp = (E)first.data;
            first = first.next;
            if (first == null)
                last = null;
            return temp;
        }
    }

    public void insertLast(E data)
    {
        ListNode<E> newNode = new ListNode<>(data);
        if (isEmpty())
            first = newNode;
        else
            last.next = newNode;
        last = newNode;
    }
}
