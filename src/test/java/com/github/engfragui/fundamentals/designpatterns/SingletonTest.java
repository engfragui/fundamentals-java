package com.github.engfragui.fundamentals.designpatterns;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonTest {

  @Test
  public void testSingleton() throws Exception {
    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();
    assertEquals(s1.hashCode(), s2.hashCode());
  }
}

