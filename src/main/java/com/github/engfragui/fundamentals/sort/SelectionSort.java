package com.github.engfragui.fundamentals.sort;

/**
 * Sort an array by getting the smallest item and move it to the front of the array.
 * Runtime: O(n^2). Memory: O(1).
 */
public class SelectionSort {

  public static void selectionSort(int[] array) {

    for (int i=0; i<array.length; i++) {

      // get index with min item
      int minIndex = getMinIndex(array, i);

      // swap minIndex with current element
      if (minIndex != i) {
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
      }
    }
  }

  private static int getMinIndex(int[] array, int start) {
    int min = Integer.MAX_VALUE;
    int minIndex = -1;
    for(int i=start; i<array.length; i++) {
      if (array[i] < min) {
        min = array[i];
        minIndex = i;
      }
    }
    return minIndex;
  }
}
