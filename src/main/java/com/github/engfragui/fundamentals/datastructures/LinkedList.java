package com.github.engfragui.fundamentals.datastructures;

public class LinkedList<T> {

  private LinkedListNode<T> head;

  public void append(T data) {
    LinkedListNode<T> end = new LinkedListNode<T>(data);
    if (head == null) {
      head = end;
      return;
    }

    LinkedListNode<T> n = head;
    while (n.getNext() != null) {
      n = n.getNext();
    }
    n.setNext(end);
  }

  public void delete(T data) throws Exception {
    if (head == null) {
      throw new Exception("Cannot delete item from empty list");
    }
    LinkedListNode<T> n = head;
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
    LinkedListNode<T> n = head;
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

  private class LinkedListNode<T> {

    private T data;
    private LinkedListNode<T> next;

    public LinkedListNode(T data) {
      this.data = data;
      this.next = null;
    }

    public LinkedListNode(T data, LinkedListNode<T> next) {
      this.data = data;
      this.next = next;
    }

    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }

    public LinkedListNode<T> getNext() {
      return next;
    }

    public void setNext(LinkedListNode<T> next) {
      this.next = next;
    }
  }

}
