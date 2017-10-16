package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {

  @Test
  public void testAppend() throws Exception {
    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    linkedList.append(2);
    assertEquals("[2]", linkedList.toString());
    linkedList.append(6);
    assertEquals("[2,6]", linkedList.toString());
    linkedList.append(1);
    assertEquals("[2,6,1]", linkedList.toString());
  }

  @Test
  public void testDelete() throws Exception {
    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    linkedList.append(2);
    linkedList.append(6);
    linkedList.append(1);
    linkedList.delete(2);
    assertEquals("[6,1]", linkedList.toString());
    linkedList.delete(1);
    assertEquals("[6]", linkedList.toString());
  }
}

