package com.github.engfragui.fundamentals.datastructures;

import java.util.PriorityQueue;

/**
 * Created by fguiducci on 6/30/18.
 */
public class PriorityQueueUsage {

  public static void main(String[] args) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    minHeap.add(4);
    minHeap.add(1);
    minHeap.add(7);
    minHeap.add(9);
    minHeap.add(3);
    minHeap.add(10);
    System.out.println(minHeap.poll());
    System.out.println(minHeap.poll());
    System.out.println(minHeap.poll());
    System.out.println(minHeap.poll());
    System.out.println(minHeap.poll());

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((x, y) -> y - x);
    maxHeap.add(4);
    maxHeap.add(1);
    maxHeap.add(7);
    maxHeap.add(9);
    maxHeap.add(3);
    maxHeap.add(10);
    System.out.println(maxHeap.poll());
    System.out.println(maxHeap.poll());
    System.out.println(maxHeap.poll());
    System.out.println(maxHeap.poll());
    System.out.println(maxHeap.poll());
  }
}
