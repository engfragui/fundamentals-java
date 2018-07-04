package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GraphTest {

  @Test
  public void testHasPathDepthFirst() throws Exception {
    Graph graph = new Graph();
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addNode(4);
    graph.addNode(5);
    graph.addNode(6);
    graph.addEgde(1,2);
    graph.addEgde(2,3);
    graph.addEgde(3,4);
    graph.addEgde(4,5);
    graph.addEgde(5,6);
    assertTrue(graph.hasPathDepthFirst(1,6));
  }

  @Test
  public void testHasPathBreathFirst() throws Exception {
    Graph graph = new Graph();
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addNode(4);
    graph.addNode(5);
    graph.addNode(6);
    graph.addEgde(1,2);
    graph.addEgde(2,3);
    graph.addEgde(3,4);
    graph.addEgde(4,5);
    graph.addEgde(5,6);
    assertTrue(graph.hasPathBreathFirst(1,6));
  }
}
