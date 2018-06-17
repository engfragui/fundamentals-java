package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoublyLinkedListTest {

  @Test
  public void testAppend() throws Exception {
    DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
    doublyLinkedList.append(2);
    assertEquals("[2]", doublyLinkedList.toString());
    doublyLinkedList.append(6);
    assertEquals("[2,6]", doublyLinkedList.toString());
    doublyLinkedList.append(1);
    assertEquals("[2,6,1]", doublyLinkedList.toString());
  }

  @Test
  public void testDelete() throws Exception {
    DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
    doublyLinkedList.append(2);
    doublyLinkedList.append(6);
    doublyLinkedList.append(1);
    doublyLinkedList.delete(2);
    assertEquals("[6,1]", doublyLinkedList.toString());
    doublyLinkedList.delete(1);
    assertEquals("[6]", doublyLinkedList.toString());
  }
}

