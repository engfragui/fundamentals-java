package com.github.engfragui.fundamentals.sort;

import java.util.Arrays;

public class RadixSort {

  private static void radixSort(int[] array) {
    // TODO add implementation here
  }

  public static void main(String args[]) {

    int[] array = new int[] {5,2,7,8,9,4,2,6};

    System.out.println("initial array = " + Arrays.toString(array));

    radixSort(array);

    System.out.println("final array = " + Arrays.toString(array));
  }
}
