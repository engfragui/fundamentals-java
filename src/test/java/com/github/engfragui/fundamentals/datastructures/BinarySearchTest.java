package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

  @Test
  public void testRecursiveBinarySearchSuccessful() throws Exception {
    int[] sortedArray = new int[]{1,3,5,9,20,48};
    int key = 20;
    int position = BinarySearch.recursiveBinarySearch(sortedArray, key);
    assertEquals(4, position);
  }

  @Test
  public void testRecursiveBinarySearchFailed() throws Exception {
    int[] sortedArray = new int[]{1,3,5,9,20,48};
    int key = 21;
    int position = BinarySearch.recursiveBinarySearch(sortedArray, key);
    assertEquals(-1, position);
  }

  @Test
  public void testIterativeBinarySearchSuccessful() throws Exception {
    int[] sortedArray = new int[]{1,3,5,9,20,48};
    int key = 20;
    int position = BinarySearch.iterativeBinarySearch(sortedArray, key);
    assertEquals(4, position);
  }

  @Test
  public void testIterativeBinarySearchFailed() throws Exception {
    int[] sortedArray = new int[]{1,3,5,9,20,48};
    int key = 21;
    int position = BinarySearch.iterativeBinarySearch(sortedArray, key);
    assertEquals(-1, position);
  }
}
