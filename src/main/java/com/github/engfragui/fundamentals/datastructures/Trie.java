package com.github.engfragui.fundamentals.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// https://www.baeldung.com/trie-java
public class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode current = root;

    for (int i = 0; i < word.length(); i++) {
      current = current.getChildren()
              .computeIfAbsent(word.charAt(i), c -> new TrieNode());
    }
    current.setIsEndOfWord(true);
  }

  public boolean find(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      TrieNode node = current.getChildren().get(c);
      if (node == null) {
        return false;
      }
      current = node;
    }
    return current.isEndOfWord();
  }

  public void delete(String word) {
    delete(root, word, 0);
  }

  private boolean delete(TrieNode current, String word, int index) {
    if (index == word.length()) {
      if (!current.isEndOfWord()) {
        return false;
      }
      current.setIsEndOfWord(false);
      return current.getChildren().isEmpty();
    }
    char ch = word.charAt(index);
    TrieNode node = current.getChildren().get(ch);
    if (node == null) {
      return false;
    }
    boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

    if (shouldDeleteCurrentNode) {
      current.getChildren().remove(ch);
      return current.getChildren().isEmpty();
    }
    return false;
  }

  private class TrieNode {
    private HashMap<Character, TrieNode> children;
    private boolean isEndOfWord;

    public TrieNode() {
      children = new HashMap<Character, TrieNode>();
    }

    public HashMap<Character, TrieNode> getChildren() {
      return children;
    }

    public void setIsEndOfWord(boolean isEndOfWord) {
      this.isEndOfWord = isEndOfWord;
    }

    public boolean isEndOfWord() {
      return this.isEndOfWord;
    }
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("meow");
    trie.insert("cat");
    trie.insert("me");
    trie.insert("mentor");
  }
}
