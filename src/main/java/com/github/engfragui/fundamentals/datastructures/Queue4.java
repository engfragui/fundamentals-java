package com.github.engfragui.fundamentals.datastructures;

/**
 * Queue implementation using a fixed-length array
 * The idea is to use the array as a circular buffer
 *
 * Add to tail, remove from head
 *
 * https://www.cs.bu.edu/teaching/c/queue/array/types.html
 */
public class Queue4 {

  private static final int ARRAY_SIZE = 3;

  private int[] array;
  private int head;
  private int tail;
  private int count; // TODO either this or tail is actually suprefluous

  public Queue4() {
    array = new int[ARRAY_SIZE];
    head = 0;
    tail = -1;
    count = 0;
  }

  public void add(int data) throws Exception {
    if (isFull()) {
      throw new Exception("Queue is full, cannot store more data");
    }
    // add item at the end of the queue
    tail++; // increment tail
    tail = tail % ARRAY_SIZE; // tail restarts from 0 if I finish the space
    array[tail] = data; // set data
    count++; // increase count of items in queue
  }

  public int remove() throws Exception {
    if (isEmpty()) {
      throw new Exception("Cannot extract item if queue is empty");
    }
    // remove the item from the end of the queue
    int item = array[head];
    head++; // increment tail
    head = head % ARRAY_SIZE; // tail restarts from 0 if I finish the space
    count--;
    return item;
  }

  public int peek() throws Exception {
    if (isEmpty()) {
      throw new Exception("Cannot peek if queue is empty");
    }
    return array[head];
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public boolean isFull() {
    return count == ARRAY_SIZE;
  }
}
