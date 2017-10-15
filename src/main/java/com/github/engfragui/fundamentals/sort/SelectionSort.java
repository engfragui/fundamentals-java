package com.github.engfragui.fundamentals.sort;

import java.util.Arrays;

/**
 * Sort an array by getting the smallest item and swapping it with
 */
public class SelectionSort {

  private static void selectionSort(int[] array) {

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

  public static void main(String args[]) {

    int[] array = new int[] {5,2,7,8,9,4,2,6};

    System.out.println("initial array = " + Arrays.toString(array));

    selectionSort(array);

    System.out.println("final array = " + Arrays.toString(array));
  }
}
