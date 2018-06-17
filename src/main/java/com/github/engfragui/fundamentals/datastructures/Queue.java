package com.github.engfragui.fundamentals.datastructures;

public class Queue<T> {

  private QueueNode<T> first;
  private QueueNode<T> last;

  public void add(T data) throws Exception {
    if (first == null && last != null) {
      throw new Exception("Invalid state: first null but last not null");
    }
    if (first != null && last == null) {
      throw new Exception("Invalid state: first not null but last null");
    }
    QueueNode<T> node = new QueueNode<T>(data);
    if (first == null && last == null) {
      first = node;
      last = node;
      return;
    }
    last.setNext(node);
    last = node;
  }

  public T remove() throws Exception {
    if (isEmpty()) {
      throw new Exception("Cannot extract item if stack is empty");
    }
    T data = first.getData();
    first = first.getNext();
    return data;
  }

  public T peek() throws Exception {
    if (isEmpty()) {
      throw new Exception("Cannot peek item if stack is empty");
    }
    return first.getData();
  }

  public boolean isEmpty() {
    return first == null && last == null;
  }

  private class QueueNode<T> {

    private T data;
    private QueueNode<T> next;

    public QueueNode(T data) {
      this.data = data;
      this.next = null;
    }

    public QueueNode(T data, QueueNode<T> next) {
      this.data = data;
      this.next = next;
    }

    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }

    public QueueNode<T> getNext() {
      return next;
    }

    public void setNext(QueueNode<T> next) {
      this.next = next;
    }
  }
}
