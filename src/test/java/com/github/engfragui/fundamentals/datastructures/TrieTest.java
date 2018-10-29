package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {

  @Test
  public void testFind() throws Exception {
    Trie trie = new Trie();
    trie.insert("meow");
    trie.insert("cat");
    trie.insert("me");
    trie.insert("mentor");
    assertTrue(trie.find("mentor"));
    assertTrue(trie.find("cat"));
    assertFalse(trie.find("mentadent"));
    assertFalse(trie.find("men"));
    assertFalse(trie.find("car"));
    assertFalse(trie.find("apple"));
  }

  @Test
  public void testDelete() throws Exception {
    Trie trie = new Trie();
    trie.insert("meow");
    trie.insert("cat");
    trie.insert("me");
    trie.insert("mentor");
    assertTrue(trie.find("mentor"));
    trie.delete("mentor");
    assertFalse(trie.find("mentor"));
  }
}
