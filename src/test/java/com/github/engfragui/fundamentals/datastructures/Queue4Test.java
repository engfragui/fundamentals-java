package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class Queue4Test {

  @Test
  public void testAdd() throws Exception {
    Queue4 queue = new Queue4();
    queue.add(9);
    assertEquals(9, queue.peek());
    queue.add(10);
    assertEquals(9, queue.peek());
    queue.add(11);
    assertEquals(9, queue.peek());
  }

  @Test(expected = Exception.class)
  public void testAddException() throws Exception {
    Queue4 queue = new Queue4();
    queue.add(9);
    assertEquals(9, queue.peek());
    queue.add(10);
    assertEquals(9, queue.peek());
    queue.add(11);
    assertEquals(9, queue.peek());
    queue.add(11);
  }

  @Test
  public void testRemove() throws Exception {
    Queue4 queue = new Queue4();
    queue.add(30);
    queue.add(31);
    queue.add(32);
    assertEquals(30, queue.remove());
    assertEquals(31, queue.remove());
    assertEquals(32, queue.remove());
  }

  @Test(expected = Exception.class)
  public void testRemoveException() throws Exception {
    Queue4 queue = new Queue4();
    queue.remove();
  }

  @Test
  public void testPeek() throws Exception {
    Queue4 queue = new Queue4();
    queue.add(10);
    assertEquals(10, queue.peek());
  }

  @Test(expected = Exception.class)
  public void testPeekException() throws Exception {
    Queue4 queue = new Queue4();
    queue.peek();
  }

  @Test
  public void testIsEmpty() throws Exception {
    Queue4 queue = new Queue4();
    assertTrue(queue.isEmpty());
    queue.add(10);
    assertFalse(queue.isEmpty());
  }

  @Test
  public void testIsFull() throws Exception {
    Queue4 queue = new Queue4();
    queue.add(9);
    assertFalse(queue.isFull());
    queue.add(10);
    assertFalse(queue.isFull());
    queue.add(11);
    assertTrue(queue.isFull());
  }

  @Test
  public void testAddAndRemove() throws Exception {
    Queue4 queue = new Queue4();
    queue.add(9);
    assertEquals(9, queue.peek());
    queue.add(10);
    assertEquals(9, queue.peek());
    queue.add(11);
    assertEquals(9, queue.peek());
    queue.remove(); // 10,11
    assertEquals(10, queue.peek());
    queue.add(12); // 10,11,12
    assertEquals(10, queue.remove()); // 11,12
    assertEquals(11, queue.remove()); // 12
    assertEquals(12, queue.remove()); // empty
    assertTrue(queue.isEmpty());
  }
}

