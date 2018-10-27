package com.github.engfragui.fundamentals.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Least Recently Used cache (LRU cache) implemented with doubly linked list and hashmap
 *
 * Notes about the implementation:
 *  - head node of the list = most recently used
 *  - tail node of the list = least recently used
 */
public class LRUCache<T> {

  private Map<Integer, Node<T>> map;
  private DoublyLinkedListLRUCache<T> list;
  private int capacity;

  public LRUCache(int capacity) {
    this.map = new HashMap<Integer, Node<T>>();
    this.list = new DoublyLinkedListLRUCache<T>();
    this.capacity = capacity;
  }

  public T get(int key) {
    Node<T> node = map.get(key);
    if (node == null) {
      return null;
    }

    // update MRU node in list
    list.markNodeAsMRU(node);
    return node.getValue();
  }

  public void put(int key, T value) {

    // if key already present, just update the value and mark node as MRU
    if (map.containsKey(key)) {
      Node<T> node = map.get(key);
      node.setValue(value);
      list.markNodeAsMRU(node);
      return;
    }

    // the key is not present

    // if we are at capacity, drop the least-recently used before inserting the new key,value
    if (list.getSize() == this.capacity) {
      Node last = list.removeLast(); // remove from list
      map.remove(last.getKey()); // remove from hashmap
    }

    Node<T> newNode = list.addFirst(key, value); // add node in the front of the list
    map.put(key, newNode);
  }

  public static void main(String[] args) {
    LRUCache<Integer> cache = new LRUCache<Integer>(2);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    System.out.println(cache.get(1));
    System.out.println(cache.get(2));
  }

  private class Node<T> {
    private int key;
    private T value;
    private Node<T> prev;
    private Node<T> next;

    public Node(int key, T value, Node<T> next, Node<T> prev) {
      this.key = key;
      this.value = value;
      this.next = next;
      this.prev = prev;
    }

    public String toString() {
      return "(" + key + ", " + value + ")";
    }

    public int getKey() {
      return this.key;
    }

    public T getValue() {
      return this.value;
    }

    public void setValue(T value) {
      this.value = value;
    }

    public Node<T> getNext() {
      return this.next;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }

    public Node<T> getPrev() {
      return this.prev;
    }

    public void setPrev(Node<T> prev) {
      this.prev = prev;
    }
  }

  private class DoublyLinkedListLRUCache<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedListLRUCache() {
      head = null;
      tail = null;
      size = 0;
    }

    public Node<T> addFirst(int key, T value) {
      Node<T> newNode = new Node<T>(key, value, this.head, null); // add node before head
      if (this.head != null ) { // if head exists
        this.head.setPrev(newNode); // connect head with new node
      }
      this.head = newNode; // newNode becomes the new head
      if (this.tail == null) {  // if tail does not exist
        this.tail = newNode; // newNode becomes the new tail
      }
      size++;
      return this.head;
    }

    public Node<T> removeLast() {
      if (size == 0) {
        return null;
      }
      Node<T> node = this.tail;

      // the list has at least one item
      if (this.tail.getPrev() != null) { // if there's a node before the tail
        this.tail.getPrev().setNext(null); // the tail becomes the node before the tail
        this.tail = this.tail.getPrev();
      } else { // if there's no node before the tail (meaning the tail is the only element in the list)
        this.head = null;
        this.tail = null;
      }

      size--;

      return node;
    }

    public void markNodeAsMRU(Node<T> node) {

      // if node is already the head of the list, do nothing
      if (node == this.head) {
        return;
      }

      if (node == this.tail) {
        this.tail.getPrev().setNext(null);
        this.tail = this.tail.getPrev();
      } else {
        // we are in the middle, we need to update the items before and after our item
        Node<T> prev = node.getPrev();
        Node<T> next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
      }

      // move our item at the head of the list
      node.setPrev(null);
      node.setNext(this.head);
      this.head.setPrev(node);
      this.head = node;
    }

    public int getSize(){
      return size;
    }
  }
}
