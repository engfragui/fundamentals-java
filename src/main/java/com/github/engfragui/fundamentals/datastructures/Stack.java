package com.github.engfragui.fundamentals.datastructures;

public class Stack<T> {

  private StackNode<T> top;

  public T pop() throws Exception {
    if (isEmpty()) {
      throw new Exception("Cannot extract item if stack is empty");
    }
    T data = top.getData();
    top = top.getNext();
    return data;
  }

  public void push(T data) {
    StackNode<T> node = new StackNode<T>(data);
    node.setNext(top);
    top = node;
  }

  public T peek() throws Exception {
    if (isEmpty()) {
      throw new Exception("Cannot peek item if stack is empty");
    }
    return top.getData();
  }

  public boolean isEmpty() {
    return top == null;
  }

  private class StackNode<T> {

    private T data;
    private StackNode<T> next;

    public StackNode(T data) {
      this.data = data;
      this.next = null;
    }

    public StackNode(T data, StackNode<T> next) {
      this.data = data;
      this.next = next;
    }

    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }

    public StackNode<T> getNext() {
      return next;
    }

    public void setNext(StackNode<T> next) {
      this.next = next;
    }
  }
}
