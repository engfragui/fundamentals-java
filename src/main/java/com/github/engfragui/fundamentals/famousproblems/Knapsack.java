package com.github.engfragui.fundamentals.famousproblems;

/**
 * Returns the maximum value that can be put in a knapsack of capacity W
 * wt are the items' weights
 * val are the items' values
 *
 * O(nW) where n is the number of items and W is the capacity of knapsack
 *
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * https://dzone.com/articles/knapsack-problem
 */
public class Knapsack {

  public static int knapsackRecursion(int W, int wt[], int val[], int n) {

    if (n == 0 || W == 0) {
      return 0;
    }

    // If weight of the nth item is more than Knapsack capacity W, then
    // this item cannot be included in the optimal solution
    if (wt[n-1] > W) {
      return knapsackRecursion(W, wt, val, n - 1);
    }

    // Return the maximum of two cases:
    // (1) nth item included
    // (2) not included

    return Math.max(val[n-1] + knapsackRecursion(W-wt[n-1], wt, val, n-1),
        knapsackRecursion(W, wt, val, n-1)
    );
  }

  public static int knapsackIterative(int W, int wt[], int val[], int n) {
    int i, w;
    int K[][] = new int[n+1][W+1];

    // Build table K[][] in bottom up manner
    for (i = 0; i <= n; i++) {
      for (w = 0; w <= W; w++) {
        if (i == 0 || w == 0) {
          K[i][w] = 0;
        } else if (wt[i - 1] <= w) {
          K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
        } else {
          K[i][w] = K[i - 1][w];
        }
      }
    }

    return K[n][W];
  }
}
