package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

public class TreeTest {

  @Test // TODO This is not a test, is more like a main() method
  public void testInOrderTraversalVisit() throws Exception {
    Tree tree = new Tree();
    tree.insert(20);
    tree.insert(2);
    tree.insert(50);
    tree.insert(4);
    tree.insert(8);
    tree.insert(17);
    tree.insert(1);
    tree.visitInOrder();
    System.out.println();
    tree.visitPreOrder();
    System.out.println();
    tree.visitPostOrder();
    System.out.println();
  }
}
