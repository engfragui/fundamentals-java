package com.github.engfragui.fundamentals.datastructures;

/**
 * Queue implementation using two stacks, with expensive dequeue operation
 * https://www.geeksforgeeks.org/queue-using-stacks/
 *
 * Add (enqueue) to "new" stack (contains new elements)
 * Remove (dequeue) from "old" stack (contains old elements)
 *
 * In this implementation, the dequeue operation is more costly
 * Whenever we want to add an element, we just add it to the "new" stack and this is cheap
 * The dequeue operation is more complex: we need to move elements from the "new" stack to the "old" stack
 */
public class Queue3<T> {

  private Stack<T> newStack;
  private Stack<T> oldStack;

  public Queue3() {
    newStack = new Stack<>();
    oldStack = new Stack<>();
  }

  public void add(T data) throws Exception {
    newStack.push(data);
  }

  public T remove() throws Exception {

    // if both stacks are empty then error
    if (oldStack.isEmpty() && newStack.isEmpty()) {
      throw new Exception("Cannot extract item if stack is empty");
    }

    // if oldStack is empty, push everything from newStack to oldStack
    if (oldStack.isEmpty()) {
      while (!newStack.isEmpty()) {
        T element = newStack.pop();
        oldStack.push(element);
      }
    }

    // pop the element from oldStack and return it
    return oldStack.pop();
  }

  public T peek() throws Exception {
    if (oldStack.isEmpty() && newStack.isEmpty()) {
      throw new Exception("Cannot peek item if stack is empty");
    }

    // if oldStack is empty, push everything from newStack to oldStack
    if (oldStack.isEmpty()) {
      while (!newStack.isEmpty()) {
        T element = newStack.pop();
        oldStack.push(element);
      }
    }

    return oldStack.peek();
  }

  public boolean isEmpty() {
    return oldStack.isEmpty() && newStack.isEmpty();
  }
}
