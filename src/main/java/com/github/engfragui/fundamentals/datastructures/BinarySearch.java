package com.github.engfragui.fundamentals.datastructures;

/**
 * O(log n) complexity
 * Based on the fact that the array is already sorted
 */
public class BinarySearch {

  public static int recursiveBinarySearch(int[] sortedArray, int key) {
    return recursiveBinarySearch(sortedArray, key, 0, sortedArray.length - 1);
  }

  private static int recursiveBinarySearch(int[] sortedArray, int key, int lowIndex, int highIndex) {
    if (highIndex < lowIndex) {
      return -1;
    }

    int middleIndex = (lowIndex + highIndex)/2;

    if (key == sortedArray[middleIndex]) {
      return middleIndex;

    } else if (key < sortedArray[middleIndex]) {
      return recursiveBinarySearch(sortedArray, key, lowIndex, middleIndex - 1);

    } else {
      return recursiveBinarySearch(sortedArray, key, middleIndex + 1, highIndex);
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
