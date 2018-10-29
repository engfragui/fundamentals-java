package com.github.engfragui.fundamentals.datastructures;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DirectedGraphTest {

  @Test
  public void testDepthFirstSearch() throws Exception {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Graph graph = new DirectedGraph();
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addNode(4);
    graph.addNode(5);
    graph.addNode(6);
    graph.addEgde(1,2);
    graph.addEgde(1,6);
    graph.addEgde(2,3);
    graph.addEgde(3,4);
    graph.addEgde(3,6);
    graph.addEgde(4,5);
    graph.addEgde(5,6);
    graph.depthFirstSearch(1);
    assertEquals("1, 2, 3, 4, 5, 6, ", outContent.toString());
  }

  @Test
  public void testDepthFirstSearchWithCycle() throws Exception {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Graph graph = new DirectedGraph();
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addNode(4);
    graph.addNode(5);
    graph.addNode(6);
    graph.addEgde(1,2);
    graph.addEgde(1,6);
    graph.addEgde(2,3);
    graph.addEgde(3,1);
    graph.addEgde(3,4);
    graph.addEgde(3,6);
    graph.addEgde(4,5);
    graph.addEgde(5,6);
    graph.depthFirstSearch(1);
    assertEquals("1, 2, 3, 4, 5, 6, ", outContent.toString());
  }

  @Test
  public void testHasPathDepthFirst() throws Exception {
    Graph graph = new DirectedGraph();
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addNode(4);
    graph.addNode(5);
    graph.addNode(6);
    graph.addEgde(1,2);
    graph.addEgde(1,6);
    graph.addEgde(2,3);
    graph.addEgde(3,4);
    graph.addEgde(3,6);
    graph.addEgde(4,5);
    graph.addEgde(5,6);
    assertTrue(graph.hasPathDepthFirst(1,4));
  }

  @Test
  public void testBreathFirstSearch() throws Exception {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Graph graph = new DirectedGraph();
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addNode(4);
    graph.addNode(5);
    graph.addNode(6);
    graph.addEgde(1,2);
    graph.addEgde(1,6);
    graph.addEgde(2,3);
    graph.addEgde(3,4);
    graph.addEgde(3,6);
    graph.addEgde(4,5);
    graph.addEgde(5,6);
    graph.breathFirstSearch(1);
    assertEquals("1, 2, 6, 3, 4, 5, ", outContent.toString());
  }

  @Test
  public void testBreathFirstSearchWithCycle() throws Exception {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Graph graph = new DirectedGraph();
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addNode(4);
    graph.addNode(5);
    graph.addNode(6);
    graph.addEgde(1,2);
    graph.addEgde(1,6);
    graph.addEgde(2,3);
    graph.addEgde(3,1);
    graph.addEgde(3,4);
    graph.addEgde(3,6);
    graph.addEgde(4,5);
    graph.addEgde(5,6);
    graph.breathFirstSearch(1);
    assertEquals("1, 2, 6, 3, 4, 5, ", outContent.toString());
  }

  @Test
  public void testHasPathBreathFirst() throws Exception {
    Graph graph = new DirectedGraph();
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addNode(4);
    graph.addNode(5);
    graph.addNode(6);
    graph.addEgde(1,2);
    graph.addEgde(1,6);
    graph.addEgde(2,3);
    graph.addEgde(3,4);
    graph.addEgde(3,6);
    graph.addEgde(4,5);
    graph.addEgde(5,6);
    assertTrue(graph.hasPathBreathFirst(1,4));
  }

  @Test
  public void testTopologicalSort() throws Exception {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Graph graph = new DirectedGraph();
    graph.addNode(0);
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addNode(4);
    graph.addNode(5);
    graph.addEgde(5,2);
    graph.addEgde(5,0);
    graph.addEgde(4,0);
    graph.addEgde(4,1);
    graph.addEgde(2,3);
    graph.addEgde(3,1);
    graph.topologicalSort();
    assertEquals("4, 5, 2, 0, 3, 1, ", outContent.toString());
  }

  @Test(expected = Exception.class)
  public void testTopologicalSortWithCycle() throws Exception {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Graph graph = new DirectedGraph();
    graph.addNode(0);
    graph.addNode(1);
    graph.addNode(2);
    graph.addNode(3);
    graph.addNode(4);
    graph.addNode(5);
    graph.addEgde(5,2);
    graph.addEgde(5,0);
    graph.addEgde(4,0);
    graph.addEgde(4,1);
    graph.addEgde(2,3);
    graph.addEgde(3,1);
    graph.addEgde(3,5);
    graph.topologicalSort();
  }
}
