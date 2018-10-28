package com.github.engfragui.fundamentals.datastructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by fguiducci on 6/30/18.
 */
// Usage of both Iterator and ListIterator
public class IteratorUsage {

  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    list.add("E");
    list.add("F");

    printList(list);
    changeContent(list);
    printList(list);
    printListBackwards(list);
    printList(list);
  }

  public static void printList(List<String> list) {
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      String element = (String) iterator.next();
      System.out.print(element + ", ");
    }
    System.out.println();
  }

  public static void changeContent(List<String> list) {
    ListIterator listIterator = list.listIterator();
    while (listIterator.hasNext()) {
      String element = (String) listIterator.next();
      listIterator.set(element + "+");
    }
  }

  public static void printListBackwards(List<String> list) {
    ListIterator listIterator = list.listIterator(list.size());
    while (listIterator.hasPrevious()) {
      String element = (String) listIterator.previous();
      System.out.print(element + ", ");
    }
    System.out.println();
  }
}
