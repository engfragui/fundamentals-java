package com.github.engfragui.fundamentals.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

  @Test
  public void testRecursiveBinarySearch() throws Exception {
    LRUCache<Integer> cache = new LRUCache<Integer>(2);
    cache.put(1, 1);
    cache.put(2, 2);
    Assert.assertEquals((Integer) 1, cache.get(1));
    cache.put(3, 3);
    Assert.assertNull(cache.get(2)); // returns null since 2 was evicted
    cache.put(4, 4);
    Assert.assertNull(cache.get(1)); // returns null since 1 was evicted
    Assert.assertEquals((Integer) 3, cache.get(3));
    Assert.assertEquals((Integer) 4, cache.get(4));
  }
}
