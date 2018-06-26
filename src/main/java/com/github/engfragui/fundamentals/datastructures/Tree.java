package com.github.engfragui.fundamentals.datastructures;

/**
 * Created by fguiducci on 6/25/18.
 */
public class Tree { // TODO This should use generics

  private TreeNode<Integer> root;

  public void insert(Integer data) {
    root = insert(root, data);
  }

  private TreeNode<Integer> insert(TreeNode<Integer> root, Integer data) {
    if (root == null) {
      return new TreeNode<Integer>(data);
    }
    if (data < root.data) {
      root.left = insert(root.left, data);
    } else if (data > root.data) {
      root.right = insert(root.right, data);
    }
    return root;
  }

  public void visitInOrder() {
    visitInOrder(root);
  }

  private void visitInOrder(TreeNode<Integer> node) {
    if (node != null) {
      this.visitInOrder(node.left);
      visit(node);
      this.visitInOrder(node.right);
    }
  }

  private void visitPreOrder(TreeNode<Integer> node) {
    if (node != null) {
      visit(node);
      this.visitPreOrder(node.left);
      this.visitPreOrder(node.right);
    }
  }

  public void visitPreOrder() {
    visitPreOrder(root);
  }

  private void visitPostOrder(TreeNode<Integer> node) {
    if (node != null) {
      this.visitPostOrder(node.left);
      this.visitPostOrder(node.right);
      visit(node);
    }
  }

  public void visitPostOrder() {
    visitPostOrder(root);
  }

  public void visit(TreeNode<Integer> node) {
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
