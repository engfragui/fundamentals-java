package com.github.engfragui.fundamentals.datastructures;

import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class DirectedGraph extends Graph {

  @Override
  public void addEgde(int source, int destination) {
    GraphNode s = getNode(source);
    GraphNode d = getNode(destination);
    s.addToAdjacents(d);
  }

  /**
   * Topological sorting based on Kahn's algorithm
   * https://en.wikipedia.org/wiki/Topological_sorting
   * https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
   */
  @Override
  public void topologicalSort() throws Exception {
    HashSet<Integer> visited = new HashSet<Integer>();
    HashMap<Integer, Integer> inDegrees = new HashMap<Integer, Integer>();
    LinkedList<GraphNode> nodesWithInDegreesZero = new LinkedList<GraphNode>();

    // calculate in-degree (number of incoming edges) for each of the nodes
    for (GraphNode node : nodeLookup.values()) {
      if (!inDegrees.containsKey(node.getId())) {
        inDegrees.put(node.getId(), 0);
      }

      for (GraphNode adj : node.getAdjacents()) {
        int adjId = adj.getId();
        if (inDegrees.containsKey(adjId)) {
          inDegrees.put(adjId, inDegrees.get(adjId)+1);
        } else {
          inDegrees.put(adjId, 1);
        }
      }
    }

    // pick all the nodes with inDegree 0 and add them to a queue
    for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
      if (entry.getValue() == 0) {
        GraphNode node = nodeLookup.get(entry.getKey());
        nodesWithInDegreesZero.add(node);
      }
    }

    // remove node from queue
    while (!nodesWithInDegreesZero.isEmpty()) {
      GraphNode node = nodesWithInDegreesZero.remove();
      visit(node);
      visited.add(node.getId());
      // decrease inDegree for all incoming nodes, a.k.a. nodes that have an edge coming from to node
      for (GraphNode n : node.getAdjacents()) {
        inDegrees.put(n.getId(), inDegrees.get(n.getId()) - 1); // decrease inDegree value of n
        // if inDegree value of n is now 0, add it to the queue of nodes with in degree zero
        if (inDegrees.get(n.getId()) == 0) {
          nodesWithInDegreesZero.add(n);
        }
      }
    }

    // if count of visited nodes is not equal to the number of nodes in the graph
    // then the topological sort is not possible for the given graph
    if (visited.size() != nodeLookup.size()) {
      throw new Exception("Cannot execute Topological Sort on given graph");
    }
  }
}
