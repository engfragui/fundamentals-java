package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class Stack3Test {

  @Test
  public void testPop() throws Exception {
    Stack3<Integer> stack = new Stack3<Integer>();
    stack.push(30);
    assertEquals((Integer) 30, stack.pop());
  }

  @Test(expected = Exception.class)
  public void testPopException() throws Exception {
    Stack3<Integer> stack = new Stack3<Integer>();
    stack.pop();
  }

  @Test
  public void testPush() throws Exception {
    Stack3<Integer> stack = new Stack3<Integer>();
    stack.push(9);
    assertEquals((Integer) 9, stack.peek());
    stack.push(10);
    assertEquals((Integer) 10, stack.peek());
  }

  @Test
  public void testPeek() throws Exception {
    Stack3<Integer> stack = new Stack3<Integer>();
    stack.push(10);
    assertEquals((Integer) 10, stack.peek());
  }

  @Test(expected = Exception.class)
  public void testPeekException() throws Exception {
    Stack3<Integer> stack = new Stack3<Integer>();
    stack.peek();
  }

  @Test
  public void testIsEmpty() throws Exception {
    Stack3<Integer> stack = new Stack3<Integer>();
    assertTrue(stack.isEmpty());
    stack.push(10);
    assertFalse(stack.isEmpty());
  }
}

