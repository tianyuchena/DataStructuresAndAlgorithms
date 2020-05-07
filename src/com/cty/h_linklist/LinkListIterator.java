package com.cty.h_linklist;

import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/5/5 15:43
 * @Description: 链表迭代器  进行遍历控制
 * @version: 1.0
 */
public class LinkListIterator {
    private Link current;
    private Link previous;
    private Link currentRight;  // 二维链表（矩阵）使用
    private Link previousRight;  // 二维链表（矩阵）使用
    private LinkList ourList;

    public void reset()
    {
        current = ourList.getFirst();
        previous = null;
    }

    public void resetRight()  // 二维链表（矩阵）使用
    {
        currentRight = ourList.getFirst();
        previousRight = null;
    }

    public LinkListIterator(LinkList list)
    {
        ourList = list;
        reset();
        resetRight();  // 二维链表（矩阵）使用
    }

    public Link getCurrent()
    {
        return current;
    }

    public Link getCurrentRight()  // 二维链表（矩阵）使用
    {
        return currentRight;
    }

    public boolean atEnd()
    {
        return (current.next == null);
    }

    public boolean atRightEnd()  // 二维链表（矩阵）使用
    {
        return (currentRight.nextRight == null);
    }

    public void nextLink()
    {
        previous = current;
        current = current.next;
    }

    public void nexRightLink()  // 二维链表（矩阵）使用
    {
        previousRight = currentRight;
        currentRight = currentRight.nextRight;
    }

    public void insertAfter(long d)
    {
        Link newLink = new Link(d);

        if(ourList.isEmpty())
        {
            ourList.setFirst(newLink);
            current = newLink;
        }
        else
        {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }  // end method insertAfter

    public void insertRightAfter(long d)  // 二维链表（矩阵）使用
    {
        Link newLink = new Link(d);

        if(ourList.isEmpty())
        {
            ourList.setFirst(newLink);
            currentRight = newLink;
        }
        else
        {
            newLink.nextRight = currentRight.nextRight;
            currentRight.nextRight = newLink;
            nexRightLink();
        }
    }  // end method insertRightAfter

    public void insertBefore(long d)
    {
        Link newLink = new Link(d);

        if(previous == null)  // 在表头或空表
        {
            newLink.next = current;
            ourList.setFirst(newLink);
            //// reset();
            // current = newLink;
        }
        else
        {
            newLink.next = current;
            previous.next = newLink;
            // current = newLink;
        }
        current = newLink;
    }  // end method insertBefore

    public long deleteCurrent()
    {
        if(ourList.isEmpty())
            return -1;
        else
        {
            long temp = current.dData;

            if(previous == null)  // 起始位置
            {
                ourList.setFirst(current.next);
                current = current.next;
            }
            else
            {
                previous.next = current.next;
                if(atEnd())  // 如果是删除末尾，重置
                    reset();
                else
                    current = current.next;
            }  // end else
            return temp;
        }
    }  // end method deleteCurrent

    public void displayRightList()
    {
        resetRight();
        while(!atRightEnd())
        {
            currentRight.displayLink();
            nexRightLink();
        }
        currentRight.displayLink();
        System.out.println("");
    }

}  // end class LinkListIterator

class LinkListIteratorApp
{
    public static char getChar()
    {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        return s.charAt(0);
    }

    public static long getLong()
    {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        return Long.parseLong(s);
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        LinkListIterator iter1 = list.getIterator();
        long value;


        iter1.insertAfter(20);
        iter1.insertAfter(40);
        iter1.insertAfter(60);
        iter1.insertAfter(80);

        while(true)
        {
            System.out.print("Enter first letter of show, reset, ");
            System.out.print("next, get, before, after, delete: ");
            int choice = getChar();
            switch(choice)
            {
                case 's':
                    if(!list.isEmpty())
                        list.displayList();
                    else
                        System.out.println("List is empty");
                    break;
                case 'r':
                    iter1.reset();
                    break;
                case 'n':
                    if(!list.isEmpty() && !iter1.atEnd())
                        iter1.nextLink();
                    else
                        System.out.println("Can't go to next link");
                    break;
                case 'g':
                    if(!list.isEmpty())
                        System.out.println("Returned " + iter1.getCurrent().dData);
                    else
                        System.out.println("List is empty");
                    break;
                case 'b':
                    System.out.print("Enter value to insert: ");
                    iter1.insertBefore(getLong());
                    break;
                case 'a':
                    System.out.print("Enter value to insert: ");
                    iter1.insertAfter(getLong());
                    break;
                case 'd':
                    long temp = iter1.deleteCurrent();
                    if(-1 == temp)
                        System.out.println("Can't delete");
                    else
                        System.out.println("Deleted " + temp);
                    break;
                default:
                    System.out.println("Invalid entry");
            }  // end switch
        }  // end while
    }  // end method main

}  // end LinkListIteratorApp

/** 2020年5月5日
 * Enter first letter of show, reset, next, get, before, after, delete: s
 * 20 40 60 80
 * Enter first letter of show, reset, next, get, before, after, delete: r
 * Enter first letter of show, reset, next, get, before, after, delete: n
 * Enter first letter of show, reset, next, get, before, after, delete: n
 * Enter first letter of show, reset, next, get, before, after, delete: g
 * Returned 60
 * Enter first letter of show, reset, next, get, before, after, delete: b
 * Enter value to insert: 100
 * Enter first letter of show, reset, next, get, before, after, delete: a
 * Enter value to insert: 7
 * Enter first letter of show, reset, next, get, before, after, delete: s
 * 20 40 100 7 60 80
 */