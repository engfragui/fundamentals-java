package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

  @Test
  public void testAdd() throws Exception {
    Queue<Integer> queue = new Queue<Integer>();
    queue.add(9);
    assertEquals((Integer) 9, queue.peek());
    queue.add(10);
    assertEquals((Integer) 9, queue.peek());
    queue.add(11);
    assertEquals((Integer) 9, queue.peek());
  }

  @Test
  public void testRemove() throws Exception {
    Queue<Integer> queue = new Queue<Integer>();
    queue.add(30);
    assertEquals((Integer) 30, queue.remove());
  }

  @Test(expected = Exception.class)
  public void testRemoveException() throws Exception {
    Queue<Integer> queue = new Queue<Integer>();
    queue.remove();
  }

  @Test
  public void testPeek() throws Exception {
    Queue<Integer> queue = new Queue<Integer>();
    queue.add(10);
    assertEquals((Integer) 10, queue.peek());
  }

  @Test(expected = Exception.class)
  public void testPeekException() throws Exception {
    Queue<Integer> queue = new Queue<Integer>();
    queue.peek();
  }

  @Test
  public void testIsEmpty() throws Exception {
    Queue<Integer> queue = new Queue<Integer>();
    assertTrue(queue.isEmpty());
    queue.add(10);
    assertFalse(queue.isEmpty());
  }
}

