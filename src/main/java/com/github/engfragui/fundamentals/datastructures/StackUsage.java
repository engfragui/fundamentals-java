package com.github.engfragui.fundamentals.datastructures;

/**
 * Created by fguiducci on 6/30/18.
 */
// Java implementation of stack
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
