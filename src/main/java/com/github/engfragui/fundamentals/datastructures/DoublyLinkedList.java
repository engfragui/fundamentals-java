package com.github.engfragui.fundamentals.datastructures;

public class DoublyLinkedList<T> {

  private DoublyLinkedNode<T> head;
  private DoublyLinkedNode<T> tail;

  public void append(T data) throws Exception {
    if (head == null && tail != null) {
      throw new Exception("Invalid state: head null but tail not null");
    }
    if (head != null && tail == null) {
      throw new Exception("Invalid state: head not null but tail null");
    }
    DoublyLinkedNode<T> end = new DoublyLinkedNode<T>(data);
    if (head == null && tail == null) {
      head = end;
      tail = end;
      return;
    }
    tail.setNext(end);
    end.setPrev(tail);
    tail = end;
  }

  public void delete(T data) throws Exception {
    if (head == null) {
      throw new Exception("Cannot delete item from empty list");
    }
    DoublyLinkedNode<T> n = head;
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
    DoublyLinkedNode<T> n = head;
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

  private class DoublyLinkedNode<T> {

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
}
