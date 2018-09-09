package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeTest {

  @Test
  public void testContains() throws Exception {
    Tree tree = new Tree();
    tree.insert(20);
    tree.insert(2);
    tree.insert(50);
    tree.insert(4);
    tree.insert(8);
    tree.insert(17);
    tree.insert(1);
    assertTrue(tree.contains(20));
    assertTrue(tree.contains(2));
    assertTrue(tree.contains(50));
    assertTrue(tree.contains(4));
    assertTrue(tree.contains(8));
    assertTrue(tree.contains(17));
    assertTrue(tree.contains(1));
    assertFalse(tree.contains(3));
    assertFalse(tree.contains(10));
  }

  @Test
  public void testVisitInOrder() throws Exception {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Tree tree = new Tree();
    tree.insert(20);
    tree.insert(2);
    tree.insert(50);
    tree.insert(4);
    tree.insert(8);
    tree.insert(17);
    tree.insert(1);
    tree.visitInOrder();
    assertEquals("1, 2, 4, 8, 17, 20, 50, \n", outContent.toString());
  }

  @Test
  public void testVisitPreOrder() throws Exception {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Tree tree = new Tree();
    tree.insert(20);
    tree.insert(2);
    tree.insert(50);
    tree.insert(4);
    tree.insert(8);
    tree.insert(17);
    tree.insert(1);
    tree.visitPreOrder();
    assertEquals("20, 2, 1, 4, 8, 17, 50, ", outContent.toString());
  }

  @Test
  public void testVisitPostOrder() throws Exception {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Tree tree = new Tree();
    tree.insert(20);
    tree.insert(2);
    tree.insert(50);
    tree.insert(4);
    tree.insert(8);
    tree.insert(17);
    tree.insert(1);
    tree.visitPostOrder();
    assertEquals("1, 17, 8, 4, 2, 50, 20, ", outContent.toString());
  }

  @Test
  public void testVisitLevelOrder() throws Exception {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Tree tree = new Tree();
    tree.insert(20);
    tree.insert(2);
    tree.insert(50);
    tree.insert(4);
    tree.insert(8);
    tree.insert(17);
    tree.insert(1);
    tree.visitLevelOrder();
    assertEquals("20, 2, 50, 1, 4, 8, 17, ", outContent.toString());
  }
}
