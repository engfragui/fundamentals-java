package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashMapTest {

  @Test
  public void testPut() throws Exception {
    HashMap map = new HashMap();
    map.put(0, 0);
    map.put(1, 1);
    map.put(128, 128);
    map.put(129, 129);
    map.put(200, 200);
    map.put(200, 201);
    assertEquals((Integer) 0, map.get(0));
    assertEquals((Integer) 1, map.get(1));
    assertEquals((Integer) 128, map.get(128));
    assertEquals((Integer) 129, map.get(129));
    assertEquals((Integer) 201, map.get(200));
    assertEquals(null, map.get(2));
  }
}
