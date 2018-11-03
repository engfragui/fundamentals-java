package com.github.engfragui.fundamentals.datastructures;

import java.util.Stack;

/**
 * Java implementation of Stack (LIFO policy)
 *
 * In general, Deque should be used instead of Stack
 * From Java docs: "A more complete and consistent set of LIFO stack operations is provided by the Deque"
 */
public class StackUsage {

  public static void main(String[] args) throws Exception {
    Stack<Integer> stack = new Stack<>();
    stack.push(4);
    stack.push(1);
    stack.push(7);
    stack.push(9);
    stack.push(3);
    stack.push(10);
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.peek());
  }
}
