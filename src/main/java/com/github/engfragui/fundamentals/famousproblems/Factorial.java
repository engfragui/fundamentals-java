package com.github.engfragui.fundamentals.famousproblems;

public class Factorial {

  // recursive implementation
  public static int getFactorialRecursion(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    return n * getFactorialRecursion(n-1);
  }

  // iterative implementation
  public static int getFactorialIterative(int n) {
    int result = 1;
    for (int i=1; i<=n; i++) {
      result *= i;
      System.out.println(result);
    }
    return result;
  }
}
