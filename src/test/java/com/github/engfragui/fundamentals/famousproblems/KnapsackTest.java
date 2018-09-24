package com.github.engfragui.fundamentals.famousproblems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {

  @Test
  public void testKnapsackRecursion() throws Exception {
    int val[] = new int[] {60, 100, 120};
    int wt[] = new int[] {10, 20, 30};
    int W = 50;
    assertEquals(220, Knapsack.knapsackRecursion(W, wt, val));
  }

  @Test
  public void testKnapsackIterative() throws Exception {
    int val[] = new int[] {60, 100, 120};
    int wt[] = new int[] {10, 20, 30};
    int W = 50;
    assertEquals(220, Knapsack.knapsackIterative(W, wt, val));
  }
}
