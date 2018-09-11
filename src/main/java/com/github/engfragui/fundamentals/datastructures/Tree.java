package com.github.engfragui.fundamentals.datastructures;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by fguiducci on 6/25/18.
 */
public class Tree { // TODO This should use generics

  private TreeNode<Integer> root;

  public void insert(Integer data) {
    root = insert(root, data);
  }

  private TreeNode<Integer> insert(TreeNode<Integer> node, Integer data) {
    if (node == null) {
      return new TreeNode<Integer>(data);
    }
    if (data < node.data) {
      node.left = insert(node.left, data);
    } else if (data > node.data) {
      node.right = insert(node.right, data);
    }
    return node;
  }

  public boolean contains(Integer data) {
    return contains(root, data);
  }

  private boolean contains(TreeNode<Integer> node, Integer data) {
    if (node == null) {
      return false;
    }
    if (data == node.data) {
      return true;
    } else if (data < node.data) {
      return contains(node.left, data);
    } else { // data > root.data
      return contains(node.right, data);
    }
  }

  // DFS in order traversal
  public void visitInOrder() {
    visitInOrder(root);
  }

  private void visitInOrder(TreeNode<Integer> node) {
    if (node != null) {
      visitInOrder(node.left);
      visit(node);
      visitInOrder(node.right);
    }
  }

  // DFS pre order traversal
  public void visitPreOrder() {
    visitPreOrder(root);
  }

  private void visitPreOrder(TreeNode<Integer> node) {
    if (node != null) {
      visit(node);
      visitPreOrder(node.left);
      visitPreOrder(node.right);
    }
  }

  // DFS post order traversal
  public void visitPostOrder() {
    visitPostOrder(root);
  }

  private void visitPostOrder(TreeNode<Integer> node) {
    if (node != null) {
      visitPostOrder(node.left);
      visitPostOrder(node.right);
      visit(node);
    }
  }

  // BFS level order traversal
  public void visitLevelOrder() {
    Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode<Integer> node = queue.poll(); // extract head of the queue
      visit(node);
      // enqueue left child if it exists
      if (node.left != null) {
        queue.add(node.left);
      }
      // enqueue right child if it exists
      if (node.right != null) {
        queue.add(node.right);
      }
    }
  }

  private void visit(TreeNode<Integer> node) {
    System.out.print(node.data + ", ");
  }

  private class TreeNode<T> {
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data) {
      this.data = data;
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }
}
