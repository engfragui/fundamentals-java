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
}
