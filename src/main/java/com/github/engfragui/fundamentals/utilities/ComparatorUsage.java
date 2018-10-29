package com.github.engfragui.fundamentals.utilities;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ComparatorUsage {

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(4);
    list.add(1);
    list.add(7);
    list.add(25);
    list.add(9);
    list.add(3);
    list.add(10);

    Comparator<Integer> regularComparator = new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    };

    Comparator<Integer> reverseComparator = new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    };

    Comparator<Integer> alphabeticComparator = new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer o2) {
        String s1 = String.valueOf(o1);
        String s2 = String.valueOf(o2);
        return s1.compareTo(s2);
      }
    };

    Collections.sort(list, alphabeticComparator);
    for (Integer i : list) {
      System.out.println(i);
    }
  }
}
