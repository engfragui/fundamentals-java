package com.github.engfragui.fundamentals.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This is Java's own implementation of "double ended queue"
 * It can be used as a queue for FIFO policy or as a stack for LIFO policy
 *
 * From Java docs: "This interface should be used in preference to the legacy Stack class"
 */
public class DequeUsage {

  public static void main(String[] args) {

    // use deque as a queue (FIFO)
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(4);
    deque.add(1);
    deque.add(7);
    deque.add(9);
    deque.add(3);
    deque.add(10);
    System.out.println(deque.getFirst()); // removes first inserted item
    System.out.println(deque.removeFirst());
    System.out.println(deque.getFirst());
    System.out.println(deque.removeFirst());
    System.out.println(deque.getFirst());
    System.out.println(deque.removeFirst());

    // using deque as a stack (LIFO)
    Deque<Integer> stack = new ArrayDeque<>();
    stack.add(4);
    stack.add(1);
    stack.add(7);
    stack.add(9);
    stack.add(3);
    stack.add(10);
    System.out.println(stack.getLast()); // removes last inserted item
    System.out.println(stack.removeLast());
    System.out.println(stack.getLast());
    System.out.println(stack.removeLast());
    System.out.println(stack.getLast());
    System.out.println(stack.removeLast());
  }
}
