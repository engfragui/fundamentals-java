package com.github.engfragui.fundamentals.datastructures;

public class DoublyLinkedNode<T> {

  private T data;
  private DoublyLinkedNode<T> next;
  private DoublyLinkedNode<T> prev;

  public DoublyLinkedNode(T data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }

  public DoublyLinkedNode(T data, DoublyLinkedNode<T> next, DoublyLinkedNode<T> prev) {
    this.data = data;
    this.next = next;
    this.prev = prev;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public DoublyLinkedNode<T> getNext() {
    return next;
  }

  public void setNext(DoublyLinkedNode<T> next) {
    this.next = next;
  }

  public DoublyLinkedNode<T> getPrev() {
    return prev;
  }

  public void setPrev(DoublyLinkedNode<T> prev) {
    this.prev = prev;
  }
}
