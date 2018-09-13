package com.github.engfragui.fundamentals;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

  @Test
  public void testRecursiveBinarySearch() throws Exception {
    int[] sortedArray = new int[]{1,2,3,4,5,6,7,8,9};
    int key = 3;
    int position = BinarySearch.recursiveBinarySearch(sortedArray, key);
    assertEquals(Arrays.binarySearch(sortedArray, key), position);
  }

  @Test
  public void testIterativeBinarySearch() throws Exception {
    int[] sortedArray = new int[]{1,2,3,4,5,6,7,8,9};
    int key = 3;
    int position = BinarySearch.iterativeBinarySearch(sortedArray, key);
    assertEquals(Arrays.binarySearch(sortedArray, key), position);
  }
}
