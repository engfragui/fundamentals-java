package com.github.engfragui.fundamentals.datastructures;

/**
 * Queue implementation using two stacks, with expensive enqueue operation
 * https://www.geeksforgeeks.org/queue-using-stacks/
 *
 * Add (enqueue) to "new" stack (contains new elements)
 * Remove (dequeue) from "old" stack (contains old elements)
 *
 * In this implementation, the enqueue operation is more costly
 * Whenever we want to add an element, we move items from the "new" stack to "old" stack
 * The dequeue operation is cheap, since the oldest element is already at the top of the "old" stack
 */
public class Queue2<T> {

  private Stack<T> newStack;
  private Stack<T> oldStack;

  public Queue2() {
    newStack = new Stack<>();
    oldStack = new Stack<>();
  }

  public void add(T data) throws Exception {

    // push everything from oldStack to newStack
    while(!oldStack.isEmpty()) {
      T element = oldStack.pop();
      newStack.push(element);
    }

    // push new element to oldStack
    oldStack.push(data);

    // push everything back to oldStack
    while(!newStack.isEmpty()) {
      T element = newStack.pop();
      oldStack.push(element);
    }
  }

  public T remove() throws Exception {

    // If oldStack is empty then error
    if (oldStack.isEmpty()) {
      throw new Exception("Cannot extract item if stack is empty");
    }

    // pop an item from oldStack and return it
    return oldStack.pop();
  }

  public T peek() throws Exception {
    if (oldStack.isEmpty()) {
      throw new Exception("Cannot peek item if stack is empty");
    }

    return oldStack.peek();
  }

  public boolean isEmpty() {
    return oldStack.isEmpty();
  }
}
