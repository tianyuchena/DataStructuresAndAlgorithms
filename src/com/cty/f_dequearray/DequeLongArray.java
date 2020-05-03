package com.cty.f_dequearray;

/**
 * @Auther: cty
 * @Date: 2020/5/1 10:58
 * @Description: 长整型数组 循环 双端 队列  有元素个数nElems P129-T4.2
 * @version: 1.0
 */
public class DequeLongArray
{
    private int maxSize;
    private long[] deque;
    private int left;
    private int right;
    private int nElems;

    public DequeLongArray(int maxSize)
    {
        this.maxSize = maxSize;
        deque = new long[maxSize];
        left = 0;
        right = -1;
        nElems = 0;
    }

    public int size()
    {
        return nElems;
    }

    public void enEmpty()
    {
        left = 0;
        right = -1;
        nElems = 0;
    }


    public boolean isEmpty()
    {
        return (0 == nElems) ? true : false;
    }

    public boolean isFull()
    {
        return (maxSize == nElems) ? true : false;
    }

    public void display()
    {
        if(isEmpty())
            System.out.println("");
        else
        {
            if(right >= left)
            {
                for(int i=left; i<=right; i++)
                {
                    System.out.print(deque[i]+" ");
                }
                System.out.println("");
            }
            else
            {
                for(int j=left; j<maxSize; j++)
                {
                    System.out.print(deque[j]+" ");
                }
                for(int k=0; k<=right; k++)
                {
                    System.out.print(deque[k]+" ");
                }
                System.out.println("");
            }
        }  // end else
    }  // end method display

    public boolean insertLeft(long value)
    {
        if(isFull())
            return false;  // 插入失败，队列已满
        else
        {
            left = (left - 1 + maxSize) % maxSize;
            deque[left] = value;
            nElems++;
            return true;  // 插入成功
        }
    }

    public long removeLeft()
    {
        if(isEmpty())
            return -1;  // 删除失败，队列为空
        else
        {
            long temp = deque[left];
            left = (left + 1) % maxSize;
            nElems--;
            return temp;
        }
    }

    public long peekLeft()
    {
        if(isEmpty())
            return -1;  // 查看失败-队列为空
        else
        {
            return deque[left];
        }
    }

    public boolean insertRight(long value)
    {
        if(isFull())
            return false;  // 插入失败-队列已满
        else
        {
            right = (right + 1) % maxSize;
            deque[right] = value;
            nElems++;
            return true;  // 插入成功
        }
    }

    public long removeRight()
    {
        if(isEmpty())
            return -1;  // 删除失败-队列为空
        else
        {
            long temp = deque[right];
            right = (right -1 +maxSize) % maxSize;
            nElems--;
            return temp;
        }
    }

    public long peekRight()
    {
        if(isEmpty())
            return -1;  // 查看失败-数组为空
        else
        {
            return deque[right];
        }
    }
}  // end class DequeLongArray

class DequeApp
{
    public static void main(String[] args)
    {
        DequeLongArray deque = new DequeLongArray(10);

        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);

        deque.insertRight(4);
        deque.insertRight(5);
        deque.insertRight(6);

        deque.display();
        System.out.println("size = "+deque.size());
    }
}  // end class DequeApp
