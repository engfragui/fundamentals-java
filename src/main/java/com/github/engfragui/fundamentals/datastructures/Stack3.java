package com.github.engfragui.fundamentals.datastructures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Stack implementation using two queues
 * https://www.geeksforgeeks.org/implement-stack-using-queue/
 *
 * In this implementation the pop operation is costly
 */
public class Stack3<T> {

  private Queue<T> queue1;
  private Queue<T> queue2;
  int size;

  public Stack3() {
    queue1 = new LinkedList<T>();
    queue2 = new LinkedList<T>();
  }

  public T pop() throws Exception {

    if (queue1.isEmpty()) {
      throw new Exception("Cannot extract item if stack is empty");
    }

    // dequeue elements from queue1 and enqueue to queue2, except the last element
    while (queue1.size() > 1) {
      T element = queue2.remove();
      queue1.add(element);
    }

    // dequeue the last item of queue1, store it and return it at the end of the method
    T element = queue1.remove();
    size--;

    // swap queue1 and queue2
    Queue<T> temp = queue1;
    queue1 = queue2;
    queue2 = temp;

    // return the element
    return element;
  }

  public void push(T data) {

    // enqueue element to queue1
    queue1.add(data);
    size++;
  }

  public T peek() throws Exception {
    if (queue1.isEmpty()) {
      throw new Exception("Cannot peek item if stack is empty");
    }

    // dequeue elements from queue1 and enqueue to queue2, except the last element
    while (queue1.size() > 1) {
      T element = queue2.remove();
      queue1.add(element);
    }

    // dequeue the last item of queue1, store it and return it at the end of the method
    T element = queue1.peek();

    // swap queue1 and queue2
    Queue<T> temp = queue1;
    queue1 = queue2;
    queue2 = temp;

    // return the element
    return element;
  }

  public boolean isEmpty() {
    return queue1.isEmpty();
  }
}
