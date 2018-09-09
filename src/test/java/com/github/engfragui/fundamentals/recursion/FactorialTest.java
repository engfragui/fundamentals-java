package com.github.engfragui.fundamentals.recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialTest {

  @Test
  public void tesFactorialRecursion() throws Exception {
    assertEquals(720, Factorial.getFactorialRecursion(6));
  }

  @Test
  public void testFactorialIterative() throws Exception {
    assertEquals(720, Factorial.getFactorialIterative(6));
  }
}
