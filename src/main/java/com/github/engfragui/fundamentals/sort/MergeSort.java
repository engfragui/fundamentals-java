package com.github.engfragui.fundamentals.sort;

/**
 * Sort an array by dividing the array in two, applying sorting on each half and then merging them together.
 * Runtime: O(n log(n)). Memory: depends.
 */
public class MergeSort {

  public static void mergeSort(int[] array) {

    int n = array.length;

    if (n<2) {
      return;
    }

    int m = n/2;
    int[] leftArray = new int[m];
    int[] rightArray = new int[n-m];

    // copy first half of array into leftArray
    System.arraycopy(array, 0, leftArray, 0, m);

    // copy second half of array into rightArray
    System.arraycopy(array, m, rightArray, 0, array.length - m);

    mergeSort(leftArray);
    mergeSort(rightArray);
    merge(leftArray, rightArray, array);
  }

  private static void merge(int[] leftArray, int[] rightArray, int[] destinationArray) {

    int i = 0; // i index in leftArray
    int j = 0; // j index in rightArray
    int k = 0; // k index in destinationArray

    while(i<leftArray.length && j<rightArray.length) {

      if (leftArray[i] <= rightArray[j]) {
        destinationArray[k] = leftArray[i];
        i++;

      } else { // rightArray[j] < leftArray[i]
        destinationArray[k] = rightArray[j];
        j++;
      }

      k++;
    }

    //if leftArray still has items, but rightArray does not
    while (i<leftArray.length) {
      destinationArray[k] = leftArray[i];
      i++;
      k++;
    }

    //if rightArray still has items, but leftArray does not
    while (j<rightArray.length) {
      destinationArray[k] = rightArray[j];
      j++;
      k++;
    }
  }
}
