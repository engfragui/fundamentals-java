package com.github.engfragui.fundamentals.datastructures;

import java.util.Arrays;

/**
 * peek() - O(1)
 * poll() - O(log n)
 * add() - O(log n)
 * delete() - O(log n)
 */
public class MinHeap { // TODO This should use generics
  int capacity = 10;
  int size = 0;
  int[] items = new int[capacity];

  private int getLeftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  private int getRightChildIndex(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  private int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  private boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) < size;
  }

  private boolean hasRightChild(int index) {
    return getRightChildIndex(index) < size;
  }

  private boolean hasParent(int index) {
    return getParentIndex(index) < size;
  }

  private int getLeftChild(int index) {
    return items[getLeftChildIndex(index)];
  }

  private int getRightChild(int index) {
    return items[getRightChildIndex(index)];
  }

  private int getParent(int index) {
    return items[getParentIndex(index)];
  }

  private void swap(int indexOne, int indexTwo) {
    int temp = items[indexOne];
    items[indexOne] = items[indexTwo];
    items[indexTwo] = temp;
  }

  private void ensureExtraCapacity() {
    if (size == capacity) {
      items = Arrays.copyOf(items, capacity * 2);
      capacity *= 2;
    }
  }

  public int peek() throws Exception {
    if (size == 0) {
      throw new Exception("Cannot peek item if stack is empty");
    }
    return items[0];
  }

  public int poll() throws Exception {
    if (size == 0) {
      throw new Exception("Cannot peek item if stack is empty");
    }
    int item = items[0];
    items[0] = items[size - 1]; // copy the last item in the heap to the head of the heap
    size--;
    heapifyDown();
    return item;
  }

  public void add(int item) {
    ensureExtraCapacity();
    items[size] = item; // add the item at the bottom of the heap
    size++;
    heapifyUp();
  }

  private void heapifyUp() {
    int index = size - 1;
    while(hasParent(index) && getParent(index) > items[index]) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }

  private void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) {
     int smallerChildIndex = getLeftChildIndex(index);
      if (hasRightChild(index) && getRightChild(index) < smallerChildIndex) {
        smallerChildIndex = getRightChildIndex(index);
      }
      if (items[index] < items[smallerChildIndex]) {
        break; // parent < smallerChild so no work needed here
      } else {
        swap(index, smallerChildIndex);
      }
      index = smallerChildIndex;
    }
  }
}
