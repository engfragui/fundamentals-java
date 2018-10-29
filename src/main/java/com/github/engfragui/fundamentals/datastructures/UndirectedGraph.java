package com.github.engfragui.fundamentals.datastructures;

public class UndirectedGraph extends Graph {

  @Override
  public void addEgde(int source, int destination) {
    GraphNode s = getNode(source);
    GraphNode d = getNode(destination);
    s.addToAdjacents(d);
    d.addToAdjacents(s);
  }

  @Override
  public void topologicalSort() throws Exception {
    throw new Exception("Cannot execute Topological Sort on undirected graph");
  }
}
