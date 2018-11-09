package com.github.engfragui.fundamentals.datastructures;

import java.util.ArrayList;
import java.util.List;

public class HashMap {

  private final static int TABLE_SIZE = 128;
  private List<HashMapEntry>[] table;

  public HashMap() {
    table = new ArrayList[TABLE_SIZE];
  }

  public Integer get(int key) {
    int hash = generateHash(key);
    if (table[hash] != null) {
      for (HashMapEntry entry : table[hash]) {
        if (entry.key == key)
          return entry.value;
      }
    }
    // if key not found, return -1 as error condition
    return null;
  }

  public void put(int key, Integer value) {
    int hash = generateHash(key);
    HashMapEntry entry = new HashMapEntry(key, value);
    // if entry is empty, create new list and add the entry
    if (table[hash] == null) {
      table[hash] = new ArrayList<>();
      table[hash].add(entry);
    } else {
      // if list already exists, check if list already has an entry with the same key
      // if so, override the existing value
      // if not, append entry to list
      boolean found = false;
      for (HashMapEntry existing : table[hash]) {
        if (existing.getKey() == key) {
          // override existing value
          existing.setValue(value);
          found = true;
          break;
        }
      }
      if (!found) {
        table[hash].add(entry);
      }
    }
  }

  public int generateHash(int value) {
    return value % TABLE_SIZE;
  }

  public class HashMapEntry {
    private int key;
    private Integer value;

    public HashMapEntry(int key, int value) {
      this.key = key;
      this.value = value;
    }

    public int getKey() {
      return key;
    }

    public void setKey() {
      this.key = key;
    }

    public Integer getValue() {
      return value;
    }

    public void setValue(Integer value) {
      this.value = value;
    }
  }

  public static void main(String[] args) throws Exception {
    HashMap map = new HashMap();
    map.put(0, 0);
    map.put(1, 1);
    System.out.println(map.get(0));
    System.out.println(map.get(1));
  }
}
