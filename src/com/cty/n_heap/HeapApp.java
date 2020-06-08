package com.cty.n_heap;

import java.util.Scanner;

/**
 * @Auther: cty
 * @Date: 2020/6/8 16:59
 * @Description:
 * @version: 1.0
 */
public class HeapApp {
    public static void main(String[] args) {
        int value, value2;
        Heap theHeap = new Heap(31);
        boolean success;

        theHeap.insert(70);
        theHeap.insert(40);
        theHeap.insert(50);
        theHeap.insert(20);
        theHeap.insert(60);
        theHeap.insert(100);
        theHeap.insert(80);
        theHeap.insert(30);
        theHeap.insert(10);
        theHeap.insert(90);

        while(true){
            System.out.print("Enter first letter of show, insert, remove, change: ");
            int choice = getChar();
            switch(choice){
                case 's':
                    theHeap.displayArray();
                    theHeap.displayHeap();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    success = theHeap.insert(value);
                    if(!success)
                        System.out.println("Can't insert; heap full");
                    break;
                case 'r':
                    if(!theHeap.isEmpty())
                        theHeap.remove();
                    else
                        System.out.println("Can't remove; heap empty");
                    break;
                case 'c':
                    System.out.print("Enter current index of item: ");
                    value = getInt();
                    System.out.print("Enter new key: ");
                    value2 = getInt();
                    success = theHeap.change(value, value2);
                    if(!success)
                        System.out.println("Invalid index");
                    break;
                default:
                    System.out.println("Invalid entry");

            }  // end switch
        }  // end while
    }  // end main()

    /**
     * Enter first letter of show, insert, remove, change: s
     * heapArray:
     * 100 90 80 30 60 50 70 20 10 40
     * ............................................................
     *                                 100
     *                 90                              80
     *         30              60              50              70
     *     20      10      40
     * ............................................................
     * Enter first letter of show, insert, remove, change: i
     * Enter value to insert: 53
     * Enter first letter of show, insert, remove, change: s
     * heapArray:
     * 100 90 80 30 60 50 70 20 10 40 53
     * ............................................................
     *                                 100
     *                 90                              80
     *         30              60              50              70
     *     20      10      40      53
     * ............................................................
     * Enter first letter of show, insert, remove, change: r
     * Enter first letter of show, insert, remove, change: s
     * heapArray:
     * 90 60 80 30 53 50 70 20 10 40
     * ............................................................
     *                                 90
     *                 60                              80
     *         30              53              50              70
     *     20      10      40
     * ............................................................
     */

    public static String getString() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static int getInt(){
        String s = getString();
        return Integer.parseInt(s);
    }

    public static char getChar(){
        String s = getString();
        return s.charAt(0);
    }
}
