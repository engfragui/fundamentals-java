package com.github.engfragui.fundamentals.sort;

import java.util.Arrays;

/**
 * Sort an array by comparing two adjacent items and swapping them if needed
 */
public class BubbleSort {

  private static void bubbleSort(int[] array) {

    boolean swappedOnce = true;
    int iteration = 0;

    // optimization compared to regular bubble sort algorithm:
    // check if I swapped once during the last iteration
    // if I didn't have to swap any items, it means that the array is already sorted
    while (swappedOnce) {

      swappedOnce = false;

      // for loop stops before expected (array.length-1-iteration)
      // because we know that, for every iteration, the last element is placed in the right position
      // iteration 0: [4, 3, 2, 1]
      // iteration 1: [3, 2, 1, 4] (4 is in the right position)
      // iteration 2: [2, 1, 3, 4] (3,4 are in the right position)
      // iteration 3: [1, 2, 3, 4] (2,3,4 are in the right position)
      // iteration 4: [1, 2, 3, 4] (1,2,3,4 are in the right position)
      for (int i=0; i<array.length-1-iteration; i++) {
        if (array[i] > array[i+1]) {
          int temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          swappedOnce = true;
        }
      }

      iteration++;
      System.out.println("array after " + iteration + " iteration = " + Arrays.toString(array));
    }

  }

  public static void main(String args[]) {

    int[] array = new int[] {5,2,7,8,9,4,2,6};

    System.out.println("initial array = " + Arrays.toString(array));

    bubbleSort(array);

    System.out.println("final array = " + Arrays.toString(array));

    array = new int[] {4,3,2,1};

    System.out.println("initial array = " + Arrays.toString(array));

    bubbleSort(array);

    System.out.println("final array = " + Arrays.toString(array));
  }
}
