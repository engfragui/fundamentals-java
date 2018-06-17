package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StackTest {

  @Test
  public void testPop() throws Exception {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(30);
    assertEquals((Integer) 30, stack.pop());
  }

  @Test(expected = Exception.class)
  public void testPopException() throws Exception {
    Stack<Integer> stack = new Stack<Integer>();
    stack.pop();
  }

  @Test
  public void testPush() throws Exception {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(9);
    assertEquals((Integer) 9, stack.peek());
    stack.push(10);
    assertEquals((Integer) 10, stack.peek());
  }

  @Test
  public void testPeek() throws Exception {
    Stack<Integer> stack = new Stack<Integer>();
    assertEquals(null, stack.peek());
    stack.push(10);
    assertEquals((Integer) 10, stack.peek());
  }

  @Test
  public void testIsEmpty() throws Exception {
    Stack<Integer> stack = new Stack<Integer>();
    assertTrue(stack.isEmpty());
    stack.push(10);
    assertFalse(stack.isEmpty());
  }
}

