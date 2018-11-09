package com.github.engfragui.fundamentals.datastructures;

/**
 * O(log n) complexity
 * Based on the fact that the array is already sorted
 */
public class BinarySearch {

  public static int recursiveBinarySearch(int[] sortedArray, int key) {
    return recursiveBinarySearch(sortedArray, key, sortedArray[0], sortedArray[sortedArray.length - 1]);
  }

  private static int recursiveBinarySearch(int[] sortedArray, int key, int low, int high) {
    if (high < low) {
      return -1;
    }

    int middle = (low + high)/2;

    if (key == sortedArray[middle]) {
      return middle;

    } else if (key < sortedArray[middle]) {
      return recursiveBinarySearch(sortedArray, key, low, middle - 1);

    } else {
      return recursiveBinarySearch(sortedArray, key, middle + 1, high);
    }
  }

  public static int iterativeBinarySearch(int[] sortedArray, int key) {
    int start = 0;
    int end = sortedArray.length - 1;

    while (start <= end) {
      int middle = (start + end) / 2;

      if (key < sortedArray[middle]) {
        end = middle - 1;
      }

      if (key > sortedArray[middle]) {
        start = middle + 1;
      }

      if (key == sortedArray[middle]) {
        return middle;
      }
    }
    return -1;
  }
}
