package com.github.engfragui.fundamentals.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Java implementation of "double ended queue"
 * It can be used as a queue for FIFO policy or as a stack for LIFO policy
 *
 * In general, Deque should be used instead of Stack
 * From Java docs: "This interface should be used in preference to the legacy Stack class"
 */
public class DequeUsage {

  public static void main(String[] args) {
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(4);
    deque.add(1);
    deque.add(7);
    deque.add(9);
    deque.add(3);
    deque.add(10);
    System.out.println(deque.getFirst());
    System.out.println(deque.removeFirst());
    System.out.println(deque.getFirst());
    System.out.println(deque.getLast());
    System.out.println(deque.removeLast());
    System.out.println(deque.getLast());
  }
}
