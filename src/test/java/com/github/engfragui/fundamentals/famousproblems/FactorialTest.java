package com.github.engfragui.fundamentals.famousproblems;

import com.github.engfragui.fundamentals.famousproblems.Factorial;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialTest {

  @Test
  public void testFactorialRecursion() throws Exception {
    assertEquals(720, Factorial.getFactorialRecursion(6));
  }

  @Test
  public void testFactorialIterative() throws Exception {
    assertEquals(720, Factorial.getFactorialIterative(6));
  }
}
