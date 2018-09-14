package com.github.engfragui.fundamentals.famousproblems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

  @Test
  public void testFibonacciRecursion() throws Exception {
    assertEquals(8, Fibonacci.getFibonacciRecursion(6));
  }

  @Test
  public void testFibonacciTopDown() throws Exception {
    assertEquals(8, Fibonacci.getFibonacciTopDown(6));
  }

  @Test
  public void testFibonacciBottomUp() throws Exception {
    assertEquals(8, Fibonacci.getFibonacciBottomUp(6));
  }

  @Test
  public void testFibonacciIterative() throws Exception {
    assertEquals(8, Fibonacci.getFibonacciIterative(6));
  }
}

