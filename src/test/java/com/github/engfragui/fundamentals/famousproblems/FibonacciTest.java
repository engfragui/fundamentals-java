package com.github.engfragui.fundamentals.famousproblems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

  @Test
  public void tesFibonacciRecursion() throws Exception {
    assertEquals(8, Fibonacci.getFibonacciRecursion(6));
  }

  @Test
  public void tesFibonacciTopDown() throws Exception {
    assertEquals(8, Fibonacci.getFibonacciTopDown(6));
  }

  @Test
  public void tesFibonacciBottomUp() throws Exception {
    assertEquals(8, Fibonacci.getFibonacciBottomUp(6));
  }

  @Test
  public void tesFibonacciBottomUpImproved() throws Exception {
    assertEquals(8, Fibonacci.getFibonacciBottomUpImproved(6));
  }
}

