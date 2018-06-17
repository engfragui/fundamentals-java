package com.github.engfragui.fundamentals.datastructures;

public class StackNode<T> {

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
