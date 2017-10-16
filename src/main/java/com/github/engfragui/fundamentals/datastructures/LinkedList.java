package com.github.engfragui.fundamentals.datastructures;

public class LinkedList<T> {

  private Node<T> head;

  public void append(T data) {
    Node<T> end = new Node<T>(data);
    if (head == null) {
      head = end;
      return;
    }

    Node<T> n = head;
    while (n.getNext() != null) {
      n = n.getNext();
    }
    n.setNext(end);
  }

  public void delete(T data) throws Exception {
    if (head == null) {
      throw new Exception("Cannot delete item from empty list");
    }
    Node n = head;
    if (n.getData() == data) {
      head = head.getNext();
      return;
    }

    while (n.getNext() != null) {
      if (n.getNext().getData() == data) {
        n.setNext(n.getNext().getNext());
        return;
      }
      n = n.getNext();
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    Node<T> n = head;
    while(n != null) {
      if (sb.length()>1) {
        sb.append(",");
      }
      sb.append(n.getData());
      n = n.getNext();
    }
    sb.append("]");
    return sb.toString();
  }
}
