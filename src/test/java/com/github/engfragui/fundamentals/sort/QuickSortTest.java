package com.github.engfragui.fundamentals.sort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {

  @Test
  public void testQuickSort() throws Exception {
    int[] array = new int[]{5,2,7,8,9,4,2,6};
    QuickSort.quickSort(array);
    assertEquals("[2, 2, 4, 5, 6, 7, 8, 9]", Arrays.toString(array));
  }
}
