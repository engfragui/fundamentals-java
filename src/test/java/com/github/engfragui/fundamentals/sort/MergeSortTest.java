package com.github.engfragui.fundamentals.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MergeSortTest {

  @Test
  public void testMergeSort() throws Exception {
    int[] array = new int[]{5,2,7,8,9,4,2,6};
    MergeSort.mergeSort(array);
    assertEquals("[2, 2, 4, 5, 6, 7, 8, 9]", Arrays.toString(array));
  }
}
