package com.github.engfragui.fundamentals.datastructures;

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

  public void visitInOrder() {
    visitInOrder(root);
    System.out.println();
  }

  private void visitInOrder(TreeNode<Integer> node) {
    if (node != null) {
      visitInOrder(node.left);
      visit(node);
      visitInOrder(node.right);
    }
  }

  public void visitPreOrder() {
    visitPreOrder(root);
    System.out.println();
  }

  private void visitPreOrder(TreeNode<Integer> node) {
    if (node != null) {
      visit(node);
      visitPreOrder(node.left);
      visitPreOrder(node.right);
    }
  }

  private void visitPostOrder(TreeNode<Integer> node) {
    if (node != null) {
      visitPostOrder(node.left);
      visitPostOrder(node.right);
      visit(node);
    }
  }

  public void visitPostOrder() {
    visitPostOrder(root);
    System.out.println();
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
