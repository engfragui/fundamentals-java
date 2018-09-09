package com.github.engfragui.fundamentals;

/**
 * Created by fguiducci on 8/25/18.
 */
public class BinarySearch {

  public static int binarySearch(int[] sortedArray, int key) {
    return binarySearch(sortedArray, key, sortedArray[0], sortedArray[sortedArray.length-1]);
  }

  public static int binarySearch(int[] sortedArray, int key, int low, int high) {
    if (high < low) {
      return -1;
    }

    int middle = (low + high)/2;

    if (key == sortedArray[middle]) {
      return middle;

    } else if (key < sortedArray[middle]) {
      return binarySearch(sortedArray, key, low, middle - 1);

    } else {
      return binarySearch(sortedArray, key, middle + 1, high);
    }
  }
}
