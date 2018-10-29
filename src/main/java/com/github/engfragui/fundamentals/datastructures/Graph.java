package com.github.engfragui.fundamentals.datastructures;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.HashMap;

public abstract class Graph {
  protected HashMap<Integer, GraphNode> nodeLookup = new HashMap<Integer, GraphNode>();

  protected GraphNode getNode(int id) {
    return nodeLookup.get(id);
  }

  public void addNode(int id) {
    GraphNode node = new GraphNode(id);
    nodeLookup.put(id, node);
  }

  abstract void addEgde(int source, int destination);

  // DFS
  public void depthFirstSearch(int source) {
    GraphNode s = getNode(source);
    HashSet<Integer> visited = new HashSet<Integer>();
    depthFirstSearch(s, visited);
  }

  private void depthFirstSearch(GraphNode source, HashSet<Integer> visited) {
    visit(source);
    visited.add(source.getId());
    for (GraphNode adjacent : source.getAdjacents()) {
      if (!visited.contains(adjacent.getId())) {
        depthFirstSearch(adjacent, visited);
      }
    }
  }

  public boolean hasPathDepthFirst(int source, int destination) {
    GraphNode s = getNode(source);
    GraphNode d = getNode(destination);
    HashSet<Integer> visited = new HashSet<Integer>();
    return hasPathDepthFirst(s, d, visited);
  }

  private boolean hasPathDepthFirst(GraphNode source, GraphNode destination, HashSet<Integer> visited) {
    if (source == destination) {
      return true;
    }
    if (visited.contains(source.getId())) {
      return false;
    }
    visited.add(source.getId());
    for (GraphNode adjacent : source.getAdjacents()) {
      if (hasPathDepthFirst(adjacent, destination, visited)) {
        return true;
      }
    }
    return false;
  }

  // BFS
  public void breathFirstSearch(int source) {
    GraphNode s = getNode(source);
    breathFirstSearch(s);
  }

  private void breathFirstSearch(GraphNode source) {
    HashSet<Integer> visited = new HashSet<Integer>();
    LinkedList<GraphNode> nextToVisit = new LinkedList<GraphNode>();
    visited.add(source.getId());
    nextToVisit.add(source);
    while (!nextToVisit.isEmpty()) {
      GraphNode node = nextToVisit.remove();
      visit(node);
      for (GraphNode adjacent : node.getAdjacents()) {
        if (!visited.contains(adjacent.getId())) {
          visited.add(adjacent.getId());
          nextToVisit.add(adjacent);
        }
      }
    }
  }

  public boolean hasPathBreathFirst(int source, int destination) {
    return hasPathBreathFirst(getNode(source), getNode(destination));
  }

  private boolean hasPathBreathFirst(GraphNode source, GraphNode destination) {
    HashSet<Integer> visited = new HashSet<Integer>();
    LinkedList<GraphNode> nextToVisit = new LinkedList<GraphNode>();
    nextToVisit.add(source);
    while (!nextToVisit.isEmpty()) {
      GraphNode node = nextToVisit.remove();
      if (node == destination) {
        return true;
      }
      if (visited.contains(node.getId())) {
        continue;
      }
      visited.add(node.getId());
      nextToVisit.addAll(node.getAdjacents());
    }
    return false;
  }

  abstract void topologicalSort() throws Exception;

  protected void visit(GraphNode node) {
    System.out.print(node.getId() + ", ");
  }

  protected class GraphNode {

    private int id;
    private java.util.LinkedList<GraphNode> adjacents = new java.util.LinkedList<GraphNode>();

    public GraphNode(int id) {
      this.id = id;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public LinkedList<GraphNode> getAdjacents() {
      return adjacents;
    }

    public void setAdjacents(LinkedList<GraphNode> adjacents) {
      this.adjacents = adjacents;
    }

    public void addToAdjacents(GraphNode node) {
      adjacents.add(node);
    }
  }
}
