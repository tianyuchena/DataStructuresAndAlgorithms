package com.cty.i_recursion.exercise;

/**
 * @Auther: cty
 * @Date: 2020/5/9 21:43
 * @Description: 数组实现列表  泛型
 * @version: 1.0
 */
class List<E>
{
    private Object[] list;
    private int nElems;

    public List(int maxSize)
    {
        list = new Object[maxSize];
        nElems = 0;
    }

    public boolean isEmpty()
    {
        return (nElems == 0);
    }

    public boolean isFull()
    {
        return (nElems == list.length);
    }

    public int size()
    {
        return nElems;
    }

    public void displayList()
    {
        for(int i=0; i<list.length; i++)
            System.out.print(list[i] + " ");
    }

    public boolean insertRight(E value)
    {
        if(isFull())
            return false;
        else
        {
            list[nElems] = value;
            nElems++;
            return true;
        }
    }

    public E deleteRight()
    {
        if(isEmpty())
            return null;
        else
        {
            Object temp = list[nElems-1];
            nElems--;
            return (E)temp;
        }
    }

    public E findByIndex(int index)
    {
        if(index<0 || index>=nElems)
            return null;
        else
            return (E)list[index];
    }

    /**
     * 有序插入——数值类型时使用
     * @param value
     * @return
     */
    public boolean insertByOrder(Long value)
    {
        if(isFull())
            return false;
        else
        {
            int j;
            for(j=0; j<nElems; j++)
                if((Long)list[j] < value)
                    break;
            for(int i=nElems; i>j; i--)
                list[i] = list[i-1];
            list[j] = value;
            nElems++;
            return true;
        }
    }

}  // end class List