package com.github.engfragui.fundamentals.famousproblems;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RedBlueBlueRedTest {

  @Test
  public void testWordPattern() throws Exception {
    assertTrue(RedBlueBlueRed.matchesPattern("abab", "abab"));
    assertTrue(RedBlueBlueRed.matchesPattern("abab", "rbrb"));
    assertTrue(RedBlueBlueRed.matchesPattern("abab", "redblueredblue"));
    assertTrue(RedBlueBlueRed.matchesPattern("aaaa", "johnjohnjohnjohn"));

    assertFalse(RedBlueBlueRed.matchesPattern("aaaa", "rbrb"));
    assertFalse(RedBlueBlueRed.matchesPattern("abab", "abcd"));
    assertFalse(RedBlueBlueRed.matchesPattern("abba", "redblueredblue"));
    assertFalse(RedBlueBlueRed.matchesPattern("aaaa", "johnjohnjohn"));
    assertFalse(RedBlueBlueRed.matchesPattern("aaaa", "johnjohnjohnjohnjohn"));
  }
}
