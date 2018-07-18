package com.github.engfragui.fundamentals.datastructures;

/**
 * Created by fguiducci on 6/30/18.
 */
// Java representation for stacks (kinda)
public class LinkedListUsage {

  public static void main(String[] args) {
    java.util.LinkedList<Integer> linkedList = new java.util.LinkedList<Integer>();
    linkedList.add(4);
    linkedList.add(1);
    linkedList.add(7);
    linkedList.add(9);
    linkedList.add(3);
    linkedList.add(10);
    System.out.println(linkedList.poll());
    System.out.println(linkedList.poll());
    System.out.println(linkedList.poll());
    System.out.println(linkedList.poll());
    System.out.println(linkedList.poll());
  }
}
