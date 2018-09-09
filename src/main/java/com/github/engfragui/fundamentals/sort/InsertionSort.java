package com.github.engfragui.fundamentals.sort;

/**
 * Sort an array by inserting each item into its correct position in the sorted subarray to the left of that item.
 * Runtime: O(n^2). Memory: O(1).
 */
public class InsertionSort {

  public static void insertionSort(int[] array) {

    for (int i=1; i<array.length; i++) {
      insertIntoSortedArray(array, i);
    }
  }

  private static void insertIntoSortedArray(int[] array, int elementIndex) {

    int elementValue = array[elementIndex];
    int i = elementIndex - 1;

    // shift items towards the right, until we find a perfect spot for our element
    while (i>=0 && array[i] > elementValue) {
      array[i+1] = array[i];
      i = i-1;
    }

    // insert our element into the right position
    array[i+1] = elementValue;
  }
}
