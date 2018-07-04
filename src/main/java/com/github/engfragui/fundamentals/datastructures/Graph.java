package com.github.engfragui.fundamentals.datastructures;

import java.util.*;
import java.util.LinkedList;

public class Graph {
  private HashMap<Integer, GraphNode> nodeLookup = new HashMap<Integer, GraphNode>();

  private GraphNode getNode(int id) {
    return nodeLookup.get(id);
  }

  public void addNode(int id) {
    GraphNode node = new GraphNode(id);
    nodeLookup.put(id, node);
  }

  public void addEgde(int source, int destination) {
    GraphNode s = getNode(source);
    GraphNode d = getNode(destination);
    s.addToAdjacents(d);
    d.addToAdjacents(s);
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

  private class GraphNode {

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
