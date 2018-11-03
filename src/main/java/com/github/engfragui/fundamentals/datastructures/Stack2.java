package com.github.engfragui.fundamentals.datastructures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Stack implementation using two queues
 * https://www.geeksforgeeks.org/implement-stack-using-queue/
 *
 * In this implementation the push operation is costly
 * The new element is always at the front of the first queue
 * The second queue is used to move every new element at front of queue2
 */
public class Stack2<T> {

  private Queue<T> queue1;
  private Queue<T> queue2;

  public Stack2() {
    queue1 = new LinkedList<T>();
    queue2 = new LinkedList<T>();
  }

  public T pop() throws Exception {

    if (queue1.isEmpty()) {
      throw new Exception("Cannot extract item if stack is empty");
    }
    // dequeue an item from queue1 and return it
    return queue1.remove();
  }

  public void push(T data) {

    // enqueue element to queue2
    queue2.add(data);

    // dequeue everything from queue1 and enqueue to queue2
    while (!queue1.isEmpty()) {
      T element = queue1.remove();
      queue2.add(element);
    }

    // swap queue1 and queue2
    Queue<T> temp = queue1;
    queue1 = queue2;
    queue2 = temp;
  }

  public T peek() throws Exception {
    if (queue1.isEmpty()) {
      throw new Exception("Cannot peek item if stack is empty");
    }

    return queue1.peek();
  }

  public boolean isEmpty() {
    return queue1.isEmpty();
  }
}
