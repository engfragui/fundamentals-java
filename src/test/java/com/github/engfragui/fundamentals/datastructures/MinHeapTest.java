package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinHeapTest {

  @Test
  public void testPeek() throws Exception {
    MinHeap minHeap = new MinHeap();
    minHeap.add(20);
    minHeap.add(2);
    minHeap.add(50);
    minHeap.add(4);
    assertEquals(2, minHeap.peek());
  }

  @Test
  public void testPoll() throws Exception {
    MinHeap minHeap = new MinHeap();
    minHeap.add(20);
    minHeap.add(2);
    minHeap.add(50);
    minHeap.add(4);
    assertEquals(2, minHeap.poll());
    assertEquals(4, minHeap.poll());
    assertEquals(20, minHeap.poll());
  }
}
