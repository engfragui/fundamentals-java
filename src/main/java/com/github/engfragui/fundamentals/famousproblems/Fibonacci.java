package com.github.engfragui.fundamentals.famousproblems;

public class Fibonacci {

  // recursive implementation
  public static int getFibonacciRecursion(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    return getFibonacciRecursion(n-1) + getFibonacciRecursion(n-2);
  }

  // top-down dynamic programming (memoization)
  public static int getFibonacciTopDown(int n) {
    return getFibonacciTopDown(n, new int[n+1]);
  }

  private static int getFibonacciTopDown(int n, int[] memo) {

    if (n == 0 || n == 1) {
      return n;
    }

    // if I've never calculated memo[n] before, I do that
    if (memo[n] == 0) {
      memo[n] = getFibonacciTopDown(n-1, memo) + getFibonacciTopDown(n-2, memo);
    }

    return memo[n];
  }

  // bottom-up dynamic programming
  public static int getFibonacciBottomUp(int n) {
    if (n == 0 || n == 1) {
      return n;
    }

    int[] memo = new int[n];
    memo[0] = 0;
    memo[1] = 1;
    for (int i=2; i<n; i++) {
      memo[i] = memo[i-1] + memo[i-2];
    }
    return memo[n-1] + memo[n-2];
  }

  // bottom-up dynamic programming (improved)
  public static int getFibonacciBottomUpImproved(int n) {
    if (n == 0 || n == 1) {
      return n;
    }

    int a = 0;
    int b = 1;
    for (int i=2; i<n; i++) {
      int c = a + b;
      a = b;
      b = c;
    }

    return a + b;
  }

  // iterative implementation
  public static int getFibonacciIterative(int n) {
    // TODO implement
    return n;
  }
}
